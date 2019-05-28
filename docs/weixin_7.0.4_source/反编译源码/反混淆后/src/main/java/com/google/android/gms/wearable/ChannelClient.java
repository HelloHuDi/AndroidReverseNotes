package com.google.android.gms.wearable;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wearable.Wearable.WearableOptions;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class ChannelClient extends GoogleApi<WearableOptions> {
    public static final String ACTION_CHANNEL_EVENT = "com.google.android.gms.wearable.CHANNEL_EVENT";

    @Retention(RetentionPolicy.SOURCE)
    public @interface CloseReason {
    }

    public interface Channel extends Parcelable {
        String getNodeId();

        String getPath();
    }

    public static abstract class ChannelCallback {
        public static final int CLOSE_REASON_DISCONNECTED = 1;
        public static final int CLOSE_REASON_LOCAL_CLOSE = 3;
        public static final int CLOSE_REASON_NORMAL = 0;
        public static final int CLOSE_REASON_REMOTE_CLOSE = 2;

        public void onChannelClosed(Channel channel, int i, int i2) {
        }

        public void onChannelOpened(Channel channel) {
        }

        public void onInputClosed(Channel channel, int i, int i2) {
        }

        public void onOutputClosed(Channel channel, int i, int i2) {
        }
    }

    public ChannelClient(Activity activity, Settings settings) {
        super(activity, Wearable.API, null, settings);
    }

    public ChannelClient(Context context, Settings settings) {
        super(context, Wearable.API, null, settings);
    }

    public abstract Task<Void> close(Channel channel);

    public abstract Task<Void> close(Channel channel, int i);

    public abstract Task<InputStream> getInputStream(Channel channel);

    public abstract Task<OutputStream> getOutputStream(Channel channel);

    public abstract Task<Channel> openChannel(String str, String str2);

    public abstract Task<Void> receiveFile(Channel channel, Uri uri, boolean z);

    public abstract Task<Void> registerChannelCallback(Channel channel, ChannelCallback channelCallback);

    public abstract Task<Void> registerChannelCallback(ChannelCallback channelCallback);

    public abstract Task<Void> sendFile(Channel channel, Uri uri);

    public abstract Task<Void> sendFile(Channel channel, Uri uri, long j, long j2);

    public abstract Task<Boolean> unregisterChannelCallback(Channel channel, ChannelCallback channelCallback);

    public abstract Task<Boolean> unregisterChannelCallback(ChannelCallback channelCallback);
}
