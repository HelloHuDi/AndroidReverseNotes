package com.tencent.mm.plugin.wear.model.service;

import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.DataMapItem;
import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.WearableListenerService;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.wear.a.b;
import com.tencent.mm.plugin.wear.model.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

@JgClassChecked(author = 100, fComment = "checked", lastDate = "20141125", reviewer = 20, vComment = {EType.SERVICESCHECK})
public class WearDataLayerService extends WearableListenerService {
    public void onCreate() {
        AppMethodBeat.i(26431);
        super.onCreate();
        ab.i("MicroMsg.Wear.WearDataLayerService", "onCreate");
        AppMethodBeat.o(26431);
    }

    public void onDestroy() {
        AppMethodBeat.i(26432);
        ab.i("MicroMsg.Wear.WearDataLayerService", "onDestroy");
        super.onDestroy();
        AppMethodBeat.o(26432);
    }

    public void onDataChanged(DataEventBuffer dataEventBuffer) {
        AppMethodBeat.i(26433);
        ab.i("MicroMsg.Wear.WearDataLayerService", "onDataChanged %d %s", Integer.valueOf(dataEventBuffer.getCount()), dataEventBuffer.getStatus());
        Iterator it = dataEventBuffer.iterator();
        while (it.hasNext()) {
            DataEvent dataEvent = (DataEvent) it.next();
            if (dataEvent.getType() == 1) {
                Uri uri = dataEvent.getDataItem().getUri();
                if (b.adz(uri.getPath())) {
                    Asset asset = DataMapItem.fromDataItem(dataEvent.getDataItem()).getDataMap().getAsset("key_data");
                    if (asset != null) {
                        byte[] a = new a().a(asset);
                        if (a == null) {
                            AppMethodBeat.o(26433);
                            return;
                        }
                        try {
                            ab.i("MicroMsg.Wear.WearDataLayerService", "receive data = %d", Integer.valueOf(a.length));
                            com.tencent.mm.plugin.wear.model.b.a.S(bD(a));
                        } catch (IOException e) {
                            ab.printErrStackTrace("MicroMsg.Wear.WearDataLayerService", e, "decode data error", new Object[0]);
                        }
                    }
                    new a().q(uri);
                } else {
                    continue;
                }
            }
        }
        dataEventBuffer.close();
        AppMethodBeat.o(26433);
    }

    private static Bundle bD(byte[] bArr) {
        AppMethodBeat.i(26434);
        Bundle bundle = new Bundle();
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        bundle.putInt("key_connecttype", dataInputStream.readInt());
        bundle.putInt("key_sessionid", dataInputStream.readInt());
        bundle.putInt("key_funid", dataInputStream.readInt());
        int readInt = dataInputStream.readInt();
        if (readInt > 0 && readInt < bArr.length) {
            byte[] bArr2 = new byte[readInt];
            dataInputStream.readFully(bArr2);
            bundle.putByteArray("key_data", bArr2);
        } else if (readInt >= bArr.length) {
            IOException iOException = new IOException("contentLength too large ".concat(String.valueOf(readInt)));
            AppMethodBeat.o(26434);
            throw iOException;
        }
        ab.i("MicroMsg.Wear.WearDataLayerService", "receive data connectType=%d sessionId=%d funId=%d contentLength=%d", Integer.valueOf(r2), Integer.valueOf(r3), Integer.valueOf(r4), Integer.valueOf(readInt));
        AppMethodBeat.o(26434);
        return bundle;
    }

    public void onMessageReceived(MessageEvent messageEvent) {
        AppMethodBeat.i(26435);
        ab.i("MicroMsg.Wear.WearDataLayerService", "onMessageReceived %s", messageEvent.getPath());
        if (b.adz(messageEvent.getPath())) {
            try {
                ab.i("MicroMsg.Wear.WearDataLayerService", "receive data = %d", Integer.valueOf(messageEvent.getData().length));
                com.tencent.mm.plugin.wear.model.b.a.S(bD(r0));
                AppMethodBeat.o(26435);
                return;
            } catch (IOException e) {
                ab.printErrStackTrace("MicroMsg.Wear.WearDataLayerService", e, "decode message error", new Object[0]);
            }
        }
        AppMethodBeat.o(26435);
    }

    public void onPeerConnected(Node node) {
        AppMethodBeat.i(26436);
        ab.i("MicroMsg.Wear.WearDataLayerService", "onPeerConnected %s", node.getId());
        Bundle bundle = new Bundle();
        bundle.putInt("key_connecttype", 3);
        bundle.putInt("key_funid", 1);
        bundle.putByteArray("key_data", node.getId().getBytes());
        com.tencent.mm.plugin.wear.model.b.a.S(bundle);
        AppMethodBeat.o(26436);
    }

    public void onPeerDisconnected(Node node) {
        AppMethodBeat.i(26437);
        ab.i("MicroMsg.Wear.WearDataLayerService", "onPeerDisconnected %s", node.getId());
        Bundle bundle = new Bundle();
        bundle.putInt("key_connecttype", 3);
        bundle.putInt("key_funid", -1);
        bundle.putByteArray("key_data", node.getId().getBytes());
        com.tencent.mm.plugin.wear.model.b.a.S(bundle);
        AppMethodBeat.o(26437);
    }

    public void onChannelOpened(Channel channel) {
        AppMethodBeat.i(26438);
        String path = channel.getPath();
        String nodeId = channel.getNodeId();
        File file = new File(e.evi, g.x(path.getBytes()));
        ab.i("MicroMsg.Wear.WearDataLayerService", "onChannelOpened %s %s %s", path, nodeId, file.getAbsolutePath());
        if (file.exists()) {
            file.delete();
        }
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            ab.printErrStackTrace("MicroMsg.Wear.WearDataLayerService", e, "onChannelOpened", new Object[0]);
        }
        try {
            channel.receiveFile(new a().cUw(), Uri.fromFile(file), false);
            AppMethodBeat.o(26438);
        } catch (Exception e2) {
            ab.printErrStackTrace("MicroMsg.Wear.WearDataLayerService", e2, "fuck Xiao Mi", new Object[0]);
            AppMethodBeat.o(26438);
        }
    }

    public void onInputClosed(Channel channel, int i, int i2) {
        AppMethodBeat.i(26439);
        String path = channel.getPath();
        String nodeId = channel.getNodeId();
        ab.i("MicroMsg.Wear.WearDataLayerService", "onInputClosed %s %s %d %d", path, nodeId, Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 0) {
            ab.i("MicroMsg.Wear.WearDataLayerService", "onInputClosed %s, %d", r2.getAbsolutePath(), Long.valueOf(new File(e.evi, g.x(path.getBytes())).length()));
            Bundle bundle = new Bundle();
            bundle.putInt("key_connecttype", 1);
            bundle.putInt("key_funid", b.adA(path));
            bundle.putInt("key_sessionid", 0);
            bundle.putByteArray("key_data", r2.getAbsolutePath().getBytes());
            com.tencent.mm.plugin.wear.model.b.a.S(bundle);
        }
        AppMethodBeat.o(26439);
    }

    public void onOutputClosed(Channel channel, int i, int i2) {
        AppMethodBeat.i(26440);
        String path = channel.getPath();
        String nodeId = channel.getNodeId();
        ab.i("MicroMsg.Wear.WearDataLayerService", "onOutputClosed %s %s %d %d", path, nodeId, Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.o(26440);
    }

    public void onChannelClosed(Channel channel, int i, int i2) {
        AppMethodBeat.i(26441);
        String path = channel.getPath();
        String nodeId = channel.getNodeId();
        ab.i("MicroMsg.Wear.WearDataLayerService", "onChannelClosed %s %s %d %d", path, nodeId, Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.o(26441);
    }
}
