package com.tencent.p177mm.p612ui.chatting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.hardcoder.WXHardCoderJNI;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p190at.C25822e;
import com.tencent.p177mm.p190at.C32290n;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.p612ui.MMBaseActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5063r;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5730e;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.ui.chatting.SendImgProxyUI */
public class SendImgProxyUI extends MMBaseActivity {
    private static boolean isRunning = false;
    private C44275p iGY = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        int i = 0;
        AppMethodBeat.m2504i(31004);
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        C5222ae.m7935a(getWindow());
        C4990ab.m7417i("MicroMsg.SendImgProxyUI", "onCreate isRunning:%b ,%d", Boolean.valueOf(isRunning), Integer.valueOf(hashCode()));
        if (isRunning) {
            C4990ab.m7420w("MicroMsg.SendImgProxyUI", "duplicate instance");
            finish();
            AppMethodBeat.m2505o(31004);
            return;
        }
        isRunning = true;
        setContentView(2130968794);
        this.iGY = C30379h.m48458b((Context) this, getString(C25738R.string.cw8), false, null);
        final boolean isWifi = C5023at.isWifi((Context) this);
        boolean z = WXHardCoderJNI.hcSendPicMsgEnable;
        int i2 = WXHardCoderJNI.hcSendPicMsgDelay;
        int i3 = WXHardCoderJNI.hcSendPicMsgCPU;
        int i4 = WXHardCoderJNI.hcSendPicMsgIO;
        if (WXHardCoderJNI.hcSendPicMsgThr) {
            i = C1720g.m3539RS().doL();
        }
        final int startPerformance = WXHardCoderJNI.startPerformance(z, i2, i3, i4, i, WXHardCoderJNI.hcSendPicMsgTimeout, 203, WXHardCoderJNI.hcSendPicMsgAction, "MicroMsg.SendImgProxyUI");
        C9638aw.m17180RS().mo10302aa(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(31003);
                C4990ab.m7416i("MicroMsg.SendImgProxyUI", "test before sendMutiImage");
                SendImgProxyUI.m59472a(SendImgProxyUI.this, SendImgProxyUI.this.getIntent());
                ArrayList arrayList = new ArrayList();
                arrayList.add(Integer.valueOf(-1));
                C9638aw.m17180RS().doM();
                C4990ab.m7416i("MicroMsg.SendImgProxyUI", "test before finish");
                SendImgProxyUI.this.iGY.dismiss();
                SendImgProxyUI.this.setResult(-1, SendImgProxyUI.this.getIntent().putIntegerArrayListExtra("GalleryUI_ImgIdList", arrayList));
                SendImgProxyUI.isRunning = false;
                SendImgProxyUI.this.finish();
                if (C5023at.isWifi(SendImgProxyUI.this) == isWifi) {
                    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSendPicMsgEnable, startPerformance);
                }
                AppMethodBeat.m2505o(31003);
            }
        });
        AppMethodBeat.m2505o(31004);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(31005);
        C4990ab.m7417i("MicroMsg.SendImgProxyUI", "onDestroy isRunning:%b , %d", Boolean.valueOf(isRunning), Integer.valueOf(hashCode()));
        super.onDestroy();
        AppMethodBeat.m2505o(31005);
    }

    public void onResume() {
        AppMethodBeat.m2504i(31006);
        C4990ab.m7417i("MicroMsg.SendImgProxyUI", "onResume isRunning:%b ,%d", Boolean.valueOf(isRunning), Integer.valueOf(hashCode()));
        super.onResume();
        AppMethodBeat.m2505o(31006);
    }

    /* renamed from: a */
    private static ArrayList<String> m59471a(ArrayList<String> arrayList, int i, ArrayList<String> arrayList2, boolean z) {
        AppMethodBeat.m2504i(31007);
        ArrayList arrayList3 = new ArrayList();
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (C5063r.amn(str)) {
                    long asZ = C5730e.asZ(str);
                    if (z || asZ <= ((long) i)) {
                        arrayList3.add(str);
                    } else {
                        arrayList2.add(str);
                    }
                }
            }
        }
        AppMethodBeat.m2505o(31007);
        return arrayList3;
    }

    /* renamed from: g */
    private static void m59473g(ArrayList<Integer> arrayList, ArrayList<String> arrayList2) {
        AppMethodBeat.m2504i(31008);
        if (arrayList.size() != arrayList2.size()) {
            C4990ab.m7412e("MicroMsg.SendImgProxyUI", "[insertErrMsg] WTF");
            AppMethodBeat.m2505o(31008);
            return;
        }
        for (int i = 0; i < arrayList2.size(); i++) {
            int intValue = ((Integer) arrayList.get(i)).intValue();
            C25822e ly = C32291o.ahl().mo73116ly(intValue);
            int asZ = (int) C5730e.asZ((String) arrayList2.get(i));
            ly.setOffset(asZ);
            ly.mo43797lt(asZ);
            C32291o.ahl().mo73076a(intValue, ly);
            long j = ly.fDH;
            C4990ab.m7417i("MicroMsg.SendImgProxyUI", "[insertErrMsg] msgLocalId:%s oriImgLocalId:%s", Long.valueOf(j), Integer.valueOf(intValue));
            C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(j);
            jf.setStatus(5);
            jf.mo14785ht(256);
            ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a(j, jf);
            C4990ab.m7417i("MicroMsg.SendImgProxyUI", "after update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", Long.valueOf(jf.field_msgId), Long.valueOf(jf.field_msgSvrId), jf.field_talker, Integer.valueOf(jf.getType()), Integer.valueOf(jf.field_isSend), jf.field_imgPath, Integer.valueOf(jf.field_status), Long.valueOf(jf.field_createTime));
        }
        AppMethodBeat.m2505o(31008);
    }

    /* renamed from: a */
    static /* synthetic */ void m59472a(SendImgProxyUI sendImgProxyUI, Intent intent) {
        AppMethodBeat.m2504i(31009);
        if (intent == null) {
            C4990ab.m7412e("MicroMsg.SendImgProxyUI", "data is empty!");
            AppMethodBeat.m2505o(31009);
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra("CropImage_Compress_Img", true);
        intent.getStringExtra("GalleryUI_ToUser");
        ArrayList arrayList = new ArrayList();
        ArrayList a = SendImgProxyUI.m59471a(intent.getStringArrayListExtra("CropImage_OutputPath_List"), intent.getIntExtra("CropImage_limit_Img_Size", 26214400), arrayList, booleanExtra);
        intent.putStringArrayListExtra("CropImage_OutputPath_List", a);
        ArrayList stringArrayListExtra = intent.getStringArrayListExtra("key_select_video_list");
        if (a.size() == 0 && arrayList.size() == 0 && (stringArrayListExtra == null || stringArrayListExtra.size() == 0)) {
            Toast.makeText(sendImgProxyUI, sendImgProxyUI.getString(C25738R.string.c3a), 0).show();
            C4990ab.m7412e("MicroMsg.SendImgProxyUI", "filelist is empty!");
            AppMethodBeat.m2505o(31009);
            return;
        }
        int intExtra = intent.getIntExtra("from_source", 0);
        int intExtra2 = intent.getIntExtra("CropImage_rotateCount", 0);
        String stringExtra = intent.getStringExtra("GalleryUI_ToUser");
        C4990ab.m7410d("MicroMsg.SendImgProxyUI", "toUserName : ".concat(String.valueOf(stringExtra)));
        C4990ab.m7410d("MicroMsg.SendImgProxyUI", "dkimgsource" + intent.getIntExtra("from_source", 0));
        if (arrayList.size() > 0) {
            C32290n.ahb().mo52997a(arrayList, true, intExtra, intExtra2, stringExtra);
            SendImgProxyUI.m59473g(C32290n.ahb().mo53002sr(stringExtra), arrayList);
            C4990ab.m7413e("MicroMsg.SendImgProxyUI", "overSizeList size:%s!", Integer.valueOf(arrayList.size()));
        }
        C32290n.ahb().mo52997a(a, booleanExtra, intExtra, intExtra2, stringExtra);
        AppMethodBeat.m2505o(31009);
    }
}
