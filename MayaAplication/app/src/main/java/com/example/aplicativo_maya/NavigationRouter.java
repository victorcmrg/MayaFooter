package com.example.aplicativo_maya;

import android.app.Activity;
import android.content.Intent;
import java.util.LinkedHashMap;

public class NavigationRouter {

    private static final LinkedHashMap<Integer, Class<? extends Activity>> screenMap = new LinkedHashMap<>();

    static {
        screenMap.put(0, Homepage.class);
        screenMap.put(1, exercicio.class);
        screenMap.put(2, null); // futuro
        screenMap.put(3, null); // futuro
    }

    public static void navigateTo(Activity from, int index) {
        Class<? extends Activity> target = screenMap.get(index);
        if (target == null || target.equals(from.getClass())) return;
        Intent intent = new Intent(from, target);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_NO_ANIMATION);
        from.startActivity(intent);
        from.overridePendingTransition(0, 0);
    }
}