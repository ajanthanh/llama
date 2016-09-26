package com.ajanthan.twoliodemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

/**
 * Created by ajanthan on 16-09-18.
 */
public class IncomingSms extends BroadcastReceiver {
    private String TAG = IncomingSms.class.getSimpleName();
    private static final String phoneNo = "+16475591892";

    @Override
    public void onReceive(Context context, Intent intent) {
        // Get the data (SMS data) bound to intent
        Bundle bundle = intent.getExtras();

        SmsMessage[] msgs = null;

        String str = "";

        if (bundle != null) {
            // Retrieve the SMS Messages received
            Object[] pdus = (Object[]) bundle.get("pdus");
            msgs = new SmsMessage[pdus.length];

            // For every SMS message received
            for (int i = 0; i < msgs.length; i++) {
                // Convert Object array
                msgs[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                String textPhoneNo = msgs[i].getOriginatingAddress();
                Log.e("number", textPhoneNo);
                if (textPhoneNo.equals(phoneNo)) {
                    MessageHelper.recieveSms(textPhoneNo, msgs[i].getMessageBody().toString(), Message.MessageType.RECIEVE);
                }
            }
        }
    }
}
