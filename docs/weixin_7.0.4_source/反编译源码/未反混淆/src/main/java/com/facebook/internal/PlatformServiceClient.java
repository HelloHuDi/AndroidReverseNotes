package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class PlatformServiceClient implements ServiceConnection {
    private final String applicationId;
    private final Context context;
    private final Handler handler;
    private CompletedListener listener;
    private final int protocolVersion;
    private int replyMessage;
    private int requestMessage;
    private boolean running;
    private Messenger sender;

    public interface CompletedListener {
        void completed(Bundle bundle);
    }

    public abstract void populateRequestBundle(Bundle bundle);

    public PlatformServiceClient(Context context, int i, int i2, int i3, String str) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        this.context = context;
        this.requestMessage = i;
        this.replyMessage = i2;
        this.applicationId = str;
        this.protocolVersion = i3;
        this.handler = new Handler() {
            public void handleMessage(Message message) {
                AppMethodBeat.i(96654);
                PlatformServiceClient.this.handleMessage(message);
                AppMethodBeat.o(96654);
            }
        };
    }

    public void setCompletedListener(CompletedListener completedListener) {
        this.listener = completedListener;
    }

    /* Access modifiers changed, original: protected */
    public Context getContext() {
        return this.context;
    }

    public boolean start() {
        if (this.running || NativeProtocol.getLatestAvailableProtocolVersionForService(this.protocolVersion) == -1) {
            return false;
        }
        Intent createPlatformServiceIntent = NativeProtocol.createPlatformServiceIntent(this.context);
        if (createPlatformServiceIntent == null) {
            return false;
        }
        this.running = true;
        this.context.bindService(createPlatformServiceIntent, this, 1);
        return true;
    }

    public void cancel() {
        this.running = false;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.sender = new Messenger(iBinder);
        sendMessage();
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.sender = null;
        try {
            this.context.unbindService(this);
        } catch (IllegalArgumentException e) {
        }
        callback(null);
    }

    private void sendMessage() {
        Bundle bundle = new Bundle();
        bundle.putString(NativeProtocol.EXTRA_APPLICATION_ID, this.applicationId);
        populateRequestBundle(bundle);
        Message obtain = Message.obtain(null, this.requestMessage);
        obtain.arg1 = this.protocolVersion;
        obtain.setData(bundle);
        obtain.replyTo = new Messenger(this.handler);
        try {
            this.sender.send(obtain);
        } catch (RemoteException e) {
            callback(null);
        }
    }

    /* Access modifiers changed, original: protected */
    public void handleMessage(Message message) {
        if (message.what == this.replyMessage) {
            Bundle data = message.getData();
            if (data.getString(NativeProtocol.STATUS_ERROR_TYPE) != null) {
                callback(null);
            } else {
                callback(data);
            }
            try {
                this.context.unbindService(this);
            } catch (IllegalArgumentException e) {
            }
        }
    }

    private void callback(Bundle bundle) {
        if (this.running) {
            this.running = false;
            CompletedListener completedListener = this.listener;
            if (completedListener != null) {
                completedListener.completed(bundle);
            }
        }
    }
}
