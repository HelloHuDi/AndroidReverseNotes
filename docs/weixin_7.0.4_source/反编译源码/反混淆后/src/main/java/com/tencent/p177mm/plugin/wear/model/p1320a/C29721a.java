package com.tencent.p177mm.plugin.wear.model.p1320a;

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
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.plugin.wear.model.C43845h;
import com.tencent.p177mm.plugin.wear.model.p1320a.C22726b.C22727a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/* renamed from: com.tencent.mm.plugin.wear.model.a.a */
public final class C29721a implements C22726b {
    private GoogleApiClient tYq = new Builder(C4996ah.getContext()).addApi(Wearable.API).build();

    public C29721a() {
        AppMethodBeat.m2504i(26356);
        AppMethodBeat.m2505o(26356);
    }

    public final boolean isAvailable() {
        AppMethodBeat.m2504i(26357);
        if (C43845h.m78626OY() || C43845h.m78625OX()) {
            AppMethodBeat.m2505o(26357);
            return true;
        }
        AppMethodBeat.m2505o(26357);
        return false;
    }

    public final void cUv() {
        AppMethodBeat.m2504i(26358);
        this.tYq.disconnect();
        cUw();
        AppMethodBeat.m2505o(26358);
    }

    public final GoogleApiClient cUw() {
        AppMethodBeat.m2504i(26359);
        if (!this.tYq.isConnected()) {
            C4990ab.m7416i("MicroMsg.Wear.GlobalConnection", "connect to google api client");
            if (!this.tYq.blockingConnect(30, TimeUnit.SECONDS).isSuccess()) {
                C4990ab.m7413e("MicroMsg.Wear.GlobalConnection", "google api client connect error, code=%d, ", Integer.valueOf(this.tYq.blockingConnect(30, TimeUnit.SECONDS).getErrorCode()));
            }
        }
        GoogleApiClient googleApiClient = this.tYq;
        AppMethodBeat.m2505o(26359);
        return googleApiClient;
    }

    /* renamed from: a */
    public final byte[] mo38300a(Asset asset) {
        AppMethodBeat.m2504i(26360);
        GetFdForAssetResult getFdForAssetResult = (GetFdForAssetResult) Wearable.DataApi.getFdForAsset(cUw(), asset).await();
        if (getFdForAssetResult.getStatus().isSuccess()) {
            byte[] q = C1173e.m2574q(getFdForAssetResult.getInputStream());
            AppMethodBeat.m2505o(26360);
            return q;
        }
        C4990ab.m7413e("MicroMsg.Wear.GlobalConnection", "read asset data not success errorCode=%d | errorMsg=%s", Integer.valueOf(getFdForAssetResult.getStatus().getStatusCode()), getFdForAssetResult.getStatus().getStatusMessage());
        AppMethodBeat.m2505o(26360);
        return null;
    }

    /* renamed from: B */
    public final C22727a mo38298B(String str, byte[] bArr) {
        C22727a c22727a;
        AppMethodBeat.m2504i(26361);
        HashSet cUx = cUx();
        C22727a c22727a2 = new C22727a();
        Iterator it = cUx.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            if (cUw().isConnected()) {
                C22727a c22727a3 = new C22727a();
                Status status = ((SendMessageResult) Wearable.MessageApi.sendMessage(cUw(), str2, str, bArr).await(2, TimeUnit.SECONDS)).getStatus();
                if (!status.isSuccess()) {
                    c22727a3.code = WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
                    c22727a3.aIm = status.getStatusMessage();
                    C4990ab.m7413e("MicroMsg.Wear.GlobalConnection", "send message not success errorCode=%d | errorMsg=%s", Integer.valueOf(status.getStatusCode()), status.getStatusMessage());
                }
                String str3 = "MicroMsg.Wear.GlobalConnection";
                String str4 = "send Message %s %s %d";
                Object[] objArr = new Object[3];
                objArr[0] = str2;
                objArr[1] = str;
                objArr[2] = Integer.valueOf(bArr == null ? 0 : bArr.length);
                C4990ab.m7411d(str3, str4, objArr);
                c22727a = c22727a3;
            } else {
                c22727a = new C22727a((byte) 0);
            }
            if (c22727a.code != 0) {
                break;
            }
        }
        c22727a = c22727a2;
        AppMethodBeat.m2505o(26361);
        return c22727a;
    }

    public final HashSet<String> cUx() {
        AppMethodBeat.m2504i(26362);
        HashSet hashSet = new HashSet();
        GetConnectedNodesResult getConnectedNodesResult = (GetConnectedNodesResult) Wearable.NodeApi.getConnectedNodes(cUw()).await();
        if (getConnectedNodesResult != null) {
            for (Node id : getConnectedNodesResult.getNodes()) {
                hashSet.add(id.getId());
            }
        }
        AppMethodBeat.m2505o(26362);
        return hashSet;
    }

    /* renamed from: C */
    public final C22727a mo38299C(String str, byte[] bArr) {
        AppMethodBeat.m2504i(26363);
        C22727a c22727a;
        if (cUw().isConnected()) {
            PutDataMapRequest create = PutDataMapRequest.create(str);
            create.getDataMap().putLong("key_timestamp", System.currentTimeMillis());
            create.getDataMap().putAsset("key_data", Asset.createFromBytes(bArr));
            Wearable.DataApi.putDataItem(cUw(), create.asPutDataRequest());
            C4990ab.m7411d("MicroMsg.Wear.GlobalConnection", "send data request path=%s | length=%d", r0.getUri().getPath(), Integer.valueOf(r0.getData().length));
            c22727a = new C22727a();
            AppMethodBeat.m2505o(26363);
            return c22727a;
        }
        c22727a = new C22727a((byte) 0);
        AppMethodBeat.m2505o(26363);
        return c22727a;
    }

    /* renamed from: q */
    public final boolean mo38308q(Uri uri) {
        AppMethodBeat.m2504i(26364);
        Wearable.DataApi.deleteDataItems(cUw(), uri);
        C4990ab.m7417i("MicroMsg.Wear.GlobalConnection", "delete data item %s", uri);
        AppMethodBeat.m2505o(26364);
        return true;
    }

    public final boolean cUy() {
        AppMethodBeat.m2504i(26365);
        if (!cUw().isConnected()) {
            AppMethodBeat.m2505o(26365);
            return false;
        } else if (cUx().size() == 0) {
            AppMethodBeat.m2505o(26365);
            return false;
        } else {
            AppMethodBeat.m2505o(26365);
            return true;
        }
    }

    public final void finish() {
        AppMethodBeat.m2504i(26366);
        this.tYq.disconnect();
        AppMethodBeat.m2505o(26366);
    }

    public final void cUz() {
        AppMethodBeat.m2504i(26367);
        DataItemBuffer dataItemBuffer = (DataItemBuffer) Wearable.DataApi.getDataItems(cUw()).await();
        Iterator it = dataItemBuffer.iterator();
        while (it.hasNext()) {
            DataItem dataItem = (DataItem) it.next();
            if (dataItem.getUri().toString().startsWith("/wechat")) {
                C4990ab.m7417i("MicroMsg.Wear.GlobalConnection", "delete data item %s", dataItem.getUri().toString());
                Wearable.DataApi.deleteDataItems(cUw(), dataItem.getUri());
            }
        }
        dataItemBuffer.release();
        AppMethodBeat.m2505o(26367);
    }
}
