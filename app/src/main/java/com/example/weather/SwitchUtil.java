package com.example.weather;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.telephony.TelephonyManager;

public class SwitchUtil {
    public static boolean getLocationStatus(Context context){
        LocationManager lm = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        return lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }



}
