import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ActionManager {
    private Map<String, Object> actionHandlers = new HashMap<>();

    public ActionManager() {
        // 🔹 Ajouter toutes les classes d'actions ici
        actionHandlers.put("combat", new CombatActions());
        actionHandlers.put("menu", new MenuActions());
        actionHandlers.put("shop", new ShopActions());
    }

    public boolean executeAction(ActionType actionType, Object... params) {
        boolean isOngoing = true;

        try {
            for (Object handler : actionHandlers.values()) {
                Method[] methods = handler.getClass().getMethods();

                for (Method method : methods) {
                    if (method.getName().equals(actionType.name().toLowerCase())) { // 🔹 Utilise l'enum
                        Class<?>[] paramTypes = method.getParameterTypes();
                        Object[] args = new Object[paramTypes.length];

                        for (int i = 0; i < paramTypes.length; i++) {
                            for (Object param : params) {
                                if (param != null && paramTypes[i].isAssignableFrom(param.getClass())) {
                                    args[i] = param;
                                    break;
                                }
                            }
                        }

                        if (paramTypes.length > 0 && paramTypes[paramTypes.length - 1] == Boolean.class) {
                            args[args.length - 1] = true;
                        }

                        Object result = method.invoke(handler, args);
                        if (result instanceof Boolean) {
                            isOngoing = (Boolean) result;
                        }
                        return isOngoing;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isOngoing;
    }
}
