package com.tencent.p177mm.plugin.wear.model.service;

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
import com.p802jg.EType;
import com.p802jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.plugin.wear.model.p1320a.C29721a;
import com.tencent.p177mm.plugin.wear.model.p1419b.C29723a;
import com.tencent.p177mm.plugin.wear.p1624a.C43840b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

@JgClassChecked(author = 100, fComment = "checked", lastDate = "20141125", reviewer = 20, vComment = {EType.SERVICESCHECK})
/* renamed from: com.tencent.mm.plugin.wear.model.service.WearDataLayerService */
public class WearDataLayerService extends WearableListenerService {
    public void onCreate() {
        AppMethodBeat.m2504i(26431);
        super.onCreate();
        C4990ab.m7416i("MicroMsg.Wear.WearDataLayerService", "onCreate");
        AppMethodBeat.m2505o(26431);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(26432);
        C4990ab.m7416i("MicroMsg.Wear.WearDataLayerService", "onDestroy");
        super.onDestroy();
        AppMethodBeat.m2505o(26432);
    }

    public void onDataChanged(DataEventBuffer dataEventBuffer) {
        AppMethodBeat.m2504i(26433);
        C4990ab.m7417i("MicroMsg.Wear.WearDataLayerService", "onDataChanged %d %s", Integer.valueOf(dataEventBuffer.getCount()), dataEventBuffer.getStatus());
        Iterator it = dataEventBuffer.iterator();
        while (it.hasNext()) {
            DataEvent dataEvent = (DataEvent) it.next();
            if (dataEvent.getType() == 1) {
                Uri uri = dataEvent.getDataItem().getUri();
                if (C43840b.adz(uri.getPath())) {
                    Asset asset = DataMapItem.fromDataItem(dataEvent.getDataItem()).getDataMap().getAsset("key_data");
                    if (asset != null) {
                        byte[] a = new C29721a().mo38300a(asset);
                        if (a == null) {
                            AppMethodBeat.m2505o(26433);
                            return;
                        }
                        try {
                            C4990ab.m7417i("MicroMsg.Wear.WearDataLayerService", "receive data = %d", Integer.valueOf(a.length));
                            C29723a.m47126S(WearDataLayerService.m26162bD(a));
                        } catch (IOException e) {
                            C4990ab.printErrStackTrace("MicroMsg.Wear.WearDataLayerService", e, "decode data error", new Object[0]);
                        }
                    }
                    new C29721a().mo38308q(uri);
                } else {
                    continue;
                }
            }
        }
        dataEventBuffer.close();
        AppMethodBeat.m2505o(26433);
    }

    /* renamed from: bD */
    private static Bundle m26162bD(byte[] bArr) {
        AppMethodBeat.m2504i(26434);
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
            AppMethodBeat.m2505o(26434);
            throw iOException;
        }
        C4990ab.m7417i("MicroMsg.Wear.WearDataLayerService", "receive data connectType=%d sessionId=%d funId=%d contentLength=%d", Integer.valueOf(r2), Integer.valueOf(r3), Integer.valueOf(r4), Integer.valueOf(readInt));
        AppMethodBeat.m2505o(26434);
        return bundle;
    }

    public void onMessageReceived(MessageEvent messageEvent) {
        AppMethodBeat.m2504i(26435);
        C4990ab.m7417i("MicroMsg.Wear.WearDataLayerService", "onMessageReceived %s", messageEvent.getPath());
        if (C43840b.adz(messageEvent.getPath())) {
            try {
                C4990ab.m7417i("MicroMsg.Wear.WearDataLayerService", "receive data = %d", Integer.valueOf(messageEvent.getData().length));
                C29723a.m47126S(WearDataLayerService.m26162bD(r0));
                AppMethodBeat.m2505o(26435);
                return;
            } catch (IOException e) {
                C4990ab.printErrStackTrace("MicroMsg.Wear.WearDataLayerService", e, "decode message error", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(26435);
    }

    public void onPeerConnected(Node node) {
        AppMethodBeat.m2504i(26436);
        C4990ab.m7417i("MicroMsg.Wear.WearDataLayerService", "onPeerConnected %s", node.getId());
        Bundle bundle = new Bundle();
        bundle.putInt("key_connecttype", 3);
        bundle.putInt("key_funid", 1);
        bundle.putByteArray("key_data", node.getId().getBytes());
        C29723a.m47126S(bundle);
        AppMethodBeat.m2505o(26436);
    }

    public void onPeerDisconnected(Node node) {
        AppMethodBeat.m2504i(26437);
        C4990ab.m7417i("MicroMsg.Wear.WearDataLayerService", "onPeerDisconnected %s", node.getId());
        Bundle bundle = new Bundle();
        bundle.putInt("key_connecttype", 3);
        bundle.putInt("key_funid", -1);
        bundle.putByteArray("key_data", node.getId().getBytes());
        C29723a.m47126S(bundle);
        AppMethodBeat.m2505o(26437);
    }

    public void onChannelOpened(Channel channel) {
        AppMethodBeat.m2504i(26438);
        String path = channel.getPath();
        String nodeId = channel.getNodeId();
        File file = new File(C6457e.evi, C1178g.m2591x(path.getBytes()));
        C4990ab.m7417i("MicroMsg.Wear.WearDataLayerService", "onChannelOpened %s %s %s", path, nodeId, file.getAbsolutePath());
        if (file.exists()) {
            file.delete();
        }
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            C4990ab.printErrStackTrace("MicroMsg.Wear.WearDataLayerService", e, "onChannelOpened", new Object[0]);
        }
        try {
            channel.receiveFile(new C29721a().cUw(), Uri.fromFile(file), false);
            AppMethodBeat.m2505o(26438);
        } catch (Exception e2) {
            C4990ab.printErrStackTrace("MicroMsg.Wear.WearDataLayerService", e2, "fuck Xiao Mi", new Object[0]);
            AppMethodBeat.m2505o(26438);
        }
    }

    public void onInputClosed(Channel channel, int i, int i2) {
        AppMethodBeat.m2504i(26439);
        String path = channel.getPath();
        String nodeId = channel.getNodeId();
        C4990ab.m7417i("MicroMsg.Wear.WearDataLayerService", "onInputClosed %s %s %d %d", path, nodeId, Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 0) {
            C4990ab.m7417i("MicroMsg.Wear.WearDataLayerService", "onInputClosed %s, %d", r2.getAbsolutePath(), Long.valueOf(new File(C6457e.evi, C1178g.m2591x(path.getBytes())).length()));
            Bundle bundle = new Bundle();
            bundle.putInt("key_connecttype", 1);
            bundle.putInt("key_funid", C43840b.adA(path));
            bundle.putInt("key_sessionid", 0);
            bundle.putByteArray("key_data", r2.getAbsolutePath().getBytes());
            C29723a.m47126S(bundle);
        }
        AppMethodBeat.m2505o(26439);
    }

    public void onOutputClosed(Channel channel, int i, int i2) {
        AppMethodBeat.m2504i(26440);
        String path = channel.getPath();
        String nodeId = channel.getNodeId();
        C4990ab.m7417i("MicroMsg.Wear.WearDataLayerService", "onOutputClosed %s %s %d %d", path, nodeId, Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.m2505o(26440);
    }

    public void onChannelClosed(Channel channel, int i, int i2) {
        AppMethodBeat.m2504i(26441);
        String path = channel.getPath();
        String nodeId = channel.getNodeId();
        C4990ab.m7417i("MicroMsg.Wear.WearDataLayerService", "onChannelClosed %s %s %d %d", path, nodeId, Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.m2505o(26441);
    }
}
