package test.librarywrapper;

import android.content.Context;
import android.content.SharedPreferences;

import java.lang.ref.WeakReference;

import test.librarywrapper.constants.SettingsConstants;

/**
 * Created by mamba on 15.08.2017.
 */

public class ShtrihPrinterPreferences {
    private WeakReference<Context> weakContext;
    private static SharedPreferences preferences;

    public ShtrihPrinterPreferences(Context context) {
        this.weakContext = new WeakReference<>(context);
        if(preferences == null)
            preferences = weakContext.get().getSharedPreferences(SettingsConstants.SHTRIH_PREFERENCES, Context.MODE_PRIVATE);
    }

    public String getSettings(){
        String settings = null;
        if(preferences != null){
            settings = preferences.getString(SettingsConstants.SHTRIH_SETTINGS, settings);
        }
        return settings;
    }

    public void setSettings(String settings){
        if(preferences != null){
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString(SettingsConstants.SHTRIH_SETTINGS, settings);
            editor.apply();
        }
    }

    public void savePrinterName(String name){
        if (preferences != null) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString(SettingsConstants.SHTRIH_NAME_SAVED, name);
            editor.apply();
        }
    }

    public String loadNamePrinter(){
        String name = null;
        if(preferences != null){
            name = preferences.getString(SettingsConstants.SHTRIH_NAME_SAVED, null);
        }
        return name;
    }
}
