package com.tencent.mm.plugin.wear.model.a;

import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import com.google.android.gms.wearable.PutDataMapRequest;
import com.google.android.gms.wearable.Wearable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public final class a implements b {
    private GoogleApiClient tYq = new Builder(ah.getContext()).addApi(Wearable.API).build();

    public a() {
        AppMethodBeat.i(26356);
        AppMethodBeat.o(26356);
    }

    public final boolean isAvailable() {
        AppMethodBeat.i(26357);
        if (h.OY() || h.OX()) {
            AppMethodBeat.o(26357);
            return true;
        }
        AppMethodBeat.o(26357);
        return false;
    }

    public final void cUv() {
        AppMethodBeat.i(26358);
        this.tYq.disconnect();
        cUw();
        AppMethodBeat.o(26358);
    }

    public final GoogleApiClient cUw() {
        AppMethodBeat.i(26359);
        if (!this.tYq.isConnected()) {
            ab.i("MicroMsg.Wear.GlobalConnection", "connect to google api client");
            if (!this.tYq.blockingConnect(30, TimeUnit.SECONDS).isSuccess()) {
                ab.e("MicroMsg.Wear.GlobalConnection", "google api client connect error, code=%d, ", Integer.valueOf(this.tYq.blockingConnect(30, TimeUnit.SECONDS).getErrorCode()));
            }
        }
        GoogleApiClient googleApiClient = this.tYq;
        AppMethodBeat.o(26359);
        return googleApiClient;
    }

    public final byte[] a(Asset asset) {
        AppMethodBeat.i(26360);
        GetFdForAssetResult getFdForAssetResult = (GetFdForAssetResult) Wearable.DataApi.getFdForAsset(cUw(), asset).await();
        if (getFdForAssetResult.getStatus().isSuccess()) {
            byte[] q = e.q(getFdForAssetResult.getInputStream());
            AppMethodBeat.o(26360);
            return q;
        }
        ab.e("MicroMsg.Wear.GlobalConnection", "read asset data not success errorCode=%d | errorMsg=%s", Integer.valueOf(getFdForAssetResult.getStatus().getStatusCode()), getFdForAssetResult.getStatus().getStatusMessage());
        AppMethodBeat.o(26360);
        return null;
    }

    public final com.tencent.mm.plugin.wear.model.a.b.a B(String str, byte[] bArr) {
        com.tencent.mm.plugin.wear.model.a.b.a aVar;
        AppMethodBeat.i(26361);
        HashSet cUx = cUx();
        com.tencent.mm.plugin.wear.model.a.b.a aVar2 = new com.tencent.mm.plugin.wear.model.a.b.a();
        Iterator it = cUx.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            if (cUw().isConnected()) {
                com.tencent.mm.plugin.wear.model.a.b.a aVar3 = new com.tencent.mm.plugin.wear.model.a.b.a();
                Status status = ((SendMessageResult) Wearable.MessageApi.sendMessage(cUw(), str2, str, bArr).await(2, TimeUnit.SECONDS)).getStatus();
                if (!status.isSuccess()) {
                    aVar3.code = WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
                    aVar3.aIm = status.getStatusMessage();
                    ab.e("MicroMsg.Wear.GlobalConnection", "send message not success errorCode=%d | errorMsg=%s", Integer.valueOf(status.getStatusCode()), status.getStatusMessage());
                }
                String str3 = "MicroMsg.Wear.GlobalConnection";
                String str4 = "send Message %s %s %d";
                Object[] objArr = new Object[3];
                objArr[0] = str2;
                objArr[1] = str;
                objArr[2] = Integer.valueOf(bArr == null ? 0 : bArr.length);
                ab.d(str3, str4, objArr);
                aVar = aVar3;
            } else {
                aVar = new com.tencent.mm.plugin.wear.model.a.b.a((byte) 0);
            }
            if (aVar.code != 0) {
                break;
            }
        }
        aVar = aVar2;
        AppMethodBeat.o(26361);
        return aVar;
    }

    public final HashSet<String> cUx() {
        AppMethodBeat.i(26362);
        HashSet hashSet = new HashSet();
        GetConnectedNodesResult getConnectedNodesResult = (GetConnectedNodesResult) Wearable.NodeApi.getConnectedNodes(cUw()).await();
        if (getConnectedNodesResult != null) {
            for (Node id : getConnectedNodesResult.getNodes()) {
                hashSet.add(id.getId());
            }
        }
        AppMethodBeat.o(26362);
        return hashSet;
    }

    public final com.tencent.mm.plugin.wear.model.a.b.a C(String str, byte[] bArr) {
        AppMethodBeat.i(26363);
        com.tencent.mm.plugin.wear.model.a.b.a aVar;
        if (cUw().isConnected()) {
            PutDataMapRequest create = PutDataMapRequest.create(str);
            create.getDataMap().putLong("key_timestamp", System.currentTimeMillis());
            create.getDataMap().putAsset("key_data", Asset.createFromBytes(bArr));
            Wearable.DataApi.putDataItem(cUw(), create.asPutDataRequest());
            ab.d("MicroMsg.Wear.GlobalConnection", "send data request path=%s | length=%d", r0.getUri().getPath(), Integer.valueOf(r0.getData().length));
            aVar = new com.tencent.mm.plugin.wear.model.a.b.a();
            AppMethodBeat.o(26363);
            return aVar;
        }
        aVar = new com.tencent.mm.plugin.wear.model.a.b.a((byte) 0);
        AppMethodBeat.o(26363);
        return aVar;
    }

    public final boolean q(Uri uri) {
        AppMethodBeat.i(26364);
        Wearable.DataApi.deleteDataItems(cUw(), uri);
        ab.i("MicroMsg.Wear.GlobalConnection", "delete data item %s", uri);
        AppMethodBeat.o(26364);
        return true;
    }

    public final boolean cUy() {
        AppMethodBeat.i(26365);
        if (!cUw().isConnected()) {
            AppMethodBeat.o(26365);
            return false;
        } else if (cUx().size() == 0) {
            AppMethodBeat.o(26365);
            return false;
        } else {
            AppMethodBeat.o(26365);
            return true;
        }
    }

    public final void finish() {
        AppMethodBeat.i(26366);
        this.tYq.disconnect();
        AppMethodBeat.o(26366);
    }

    public final void cUz() {
        AppMethodBeat.i(26367);
        DataItemBuffer dataItemBuffer = (DataItemBuffer) Wearable.DataApi.getDataItems(cUw()).await();
        Iterator it = dataItemBuffer.iterator();
        while (it.hasNext()) {
            DataItem dataItem = (DataItem) it.next();
            if (dataItem.getUri().toString().startsWith("/wechat")) {
                ab.i("MicroMsg.Wear.GlobalConnection", "delete data item %s", dataItem.getUri().toString());
                Wearable.DataApi.deleteDataItems(cUw(), dataItem.getUri());
            }
        }
        dataItemBuffer.release();
        AppMethodBeat.o(26367);
    }
}
