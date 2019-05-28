package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.n;
import com.tencent.mm.at.o;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.Iterator;

public class SendImgProxyUI extends MMBaseActivity {
    private static boolean isRunning = false;
    private p iGY = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        int i = 0;
        AppMethodBeat.i(31004);
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        ae.a(getWindow());
        ab.i("MicroMsg.SendImgProxyUI", "onCreate isRunning:%b ,%d", Boolean.valueOf(isRunning), Integer.valueOf(hashCode()));
        if (isRunning) {
            ab.w("MicroMsg.SendImgProxyUI", "duplicate instance");
            finish();
            AppMethodBeat.o(31004);
            return;
        }
        isRunning = true;
        setContentView(R.layout.f7);
        this.iGY = h.b((Context) this, getString(R.string.cw8), false, null);
        final boolean isWifi = at.isWifi((Context) this);
        boolean z = WXHardCoderJNI.hcSendPicMsgEnable;
        int i2 = WXHardCoderJNI.hcSendPicMsgDelay;
        int i3 = WXHardCoderJNI.hcSendPicMsgCPU;
        int i4 = WXHardCoderJNI.hcSendPicMsgIO;
        if (WXHardCoderJNI.hcSendPicMsgThr) {
            i = g.RS().doL();
        }
        final int startPerformance = WXHardCoderJNI.startPerformance(z, i2, i3, i4, i, WXHardCoderJNI.hcSendPicMsgTimeout, 203, WXHardCoderJNI.hcSendPicMsgAction, "MicroMsg.SendImgProxyUI");
        aw.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(31003);
                ab.i("MicroMsg.SendImgProxyUI", "test before sendMutiImage");
                SendImgProxyUI.a(SendImgProxyUI.this, SendImgProxyUI.this.getIntent());
                ArrayList arrayList = new ArrayList();
                arrayList.add(Integer.valueOf(-1));
                aw.RS().doM();
                ab.i("MicroMsg.SendImgProxyUI", "test before finish");
                SendImgProxyUI.this.iGY.dismiss();
                SendImgProxyUI.this.setResult(-1, SendImgProxyUI.this.getIntent().putIntegerArrayListExtra("GalleryUI_ImgIdList", arrayList));
                SendImgProxyUI.isRunning = false;
                SendImgProxyUI.this.finish();
                if (at.isWifi(SendImgProxyUI.this) == isWifi) {
                    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSendPicMsgEnable, startPerformance);
                }
                AppMethodBeat.o(31003);
            }
        });
        AppMethodBeat.o(31004);
    }

    public void onDestroy() {
        AppMethodBeat.i(31005);
        ab.i("MicroMsg.SendImgProxyUI", "onDestroy isRunning:%b , %d", Boolean.valueOf(isRunning), Integer.valueOf(hashCode()));
        super.onDestroy();
        AppMethodBeat.o(31005);
    }

    public void onResume() {
        AppMethodBeat.i(31006);
        ab.i("MicroMsg.SendImgProxyUI", "onResume isRunning:%b ,%d", Boolean.valueOf(isRunning), Integer.valueOf(hashCode()));
        super.onResume();
        AppMethodBeat.o(31006);
    }

    private static ArrayList<String> a(ArrayList<String> arrayList, int i, ArrayList<String> arrayList2, boolean z) {
        AppMethodBeat.i(31007);
        ArrayList arrayList3 = new ArrayList();
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (r.amn(str)) {
                    long asZ = e.asZ(str);
                    if (z || asZ <= ((long) i)) {
                        arrayList3.add(str);
                    } else {
                        arrayList2.add(str);
                    }
                }
            }
        }
        AppMethodBeat.o(31007);
        return arrayList3;
    }

    private static void g(ArrayList<Integer> arrayList, ArrayList<String> arrayList2) {
        AppMethodBeat.i(31008);
        if (arrayList.size() != arrayList2.size()) {
            ab.e("MicroMsg.SendImgProxyUI", "[insertErrMsg] WTF");
            AppMethodBeat.o(31008);
            return;
        }
        for (int i = 0; i < arrayList2.size(); i++) {
            int intValue = ((Integer) arrayList.get(i)).intValue();
            com.tencent.mm.at.e ly = o.ahl().ly(intValue);
            int asZ = (int) e.asZ((String) arrayList2.get(i));
            ly.setOffset(asZ);
            ly.lt(asZ);
            o.ahl().a(intValue, ly);
            long j = ly.fDH;
            ab.i("MicroMsg.SendImgProxyUI", "[insertErrMsg] msgLocalId:%s oriImgLocalId:%s", Long.valueOf(j), Integer.valueOf(intValue));
            bi jf = ((j) g.K(j.class)).bOr().jf(j);
            jf.setStatus(5);
            jf.ht(256);
            ((j) g.K(j.class)).bOr().a(j, jf);
            ab.i("MicroMsg.SendImgProxyUI", "after update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", Long.valueOf(jf.field_msgId), Long.valueOf(jf.field_msgSvrId), jf.field_talker, Integer.valueOf(jf.getType()), Integer.valueOf(jf.field_isSend), jf.field_imgPath, Integer.valueOf(jf.field_status), Long.valueOf(jf.field_createTime));
        }
        AppMethodBeat.o(31008);
    }

    static /* synthetic */ void a(SendImgProxyUI sendImgProxyUI, Intent intent) {
        AppMethodBeat.i(31009);
        if (intent == null) {
            ab.e("MicroMsg.SendImgProxyUI", "data is empty!");
            AppMethodBeat.o(31009);
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra("CropImage_Compress_Img", true);
        intent.getStringExtra("GalleryUI_ToUser");
        ArrayList arrayList = new ArrayList();
        ArrayList a = a(intent.getStringArrayListExtra("CropImage_OutputPath_List"), intent.getIntExtra("CropImage_limit_Img_Size", 26214400), arrayList, booleanExtra);
        intent.putStringArrayListExtra("CropImage_OutputPath_List", a);
        ArrayList stringArrayListExtra = intent.getStringArrayListExtra("key_select_video_list");
        if (a.size() == 0 && arrayList.size() == 0 && (stringArrayListExtra == null || stringArrayListExtra.size() == 0)) {
            Toast.makeText(sendImgProxyUI, sendImgProxyUI.getString(R.string.c3a), 0).show();
            ab.e("MicroMsg.SendImgProxyUI", "filelist is empty!");
            AppMethodBeat.o(31009);
            return;
        }
        int intExtra = intent.getIntExtra("from_source", 0);
        int intExtra2 = intent.getIntExtra("CropImage_rotateCount", 0);
        String stringExtra = intent.getStringExtra("GalleryUI_ToUser");
        ab.d("MicroMsg.SendImgProxyUI", "toUserName : ".concat(String.valueOf(stringExtra)));
        ab.d("MicroMsg.SendImgProxyUI", "dkimgsource" + intent.getIntExtra("from_source", 0));
        if (arrayList.size() > 0) {
            n.ahb().a(arrayList, true, intExtra, intExtra2, stringExtra);
            g(n.ahb().sr(stringExtra), arrayList);
            ab.e("MicroMsg.SendImgProxyUI", "overSizeList size:%s!", Integer.valueOf(arrayList.size()));
        }
        n.ahb().a(a, booleanExtra, intExtra, intExtra2, stringExtra);
        AppMethodBeat.o(31009);
    }
}
