package com.ajanthan.twoliodemo;

import android.telephony.SmsManager;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by ajanthan on 16-09-18.
 */
public class MessageHelper {
    private static String phoneNo = "6475591892";

    public static void recieveSms(String number, String text, Message.MessageType type){
        //Todo: error check
        Log.d("MessageHelper: ", text);
        MessageModel.getInstance().addMessage(new Message(number, text, type));
    }

    public static void sendSMS(String text){
        try {
            SmsManager sms = SmsManager.getDefault();
            ArrayList<String> parts = sms.divideMessage(text);
            sms.sendMultipartTextMessage(phoneNo, null, parts, null, null);
//            Toast.makeText(getApplicationContext(), "SMS sent.", Toast.LENGTH_LONG).show();
        }
        catch (Exception e) {
//            Toast.makeText(getApplicationContext(), "SMS faild, please try again.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}
