package com.tencent.p177mm.plugin.sns.p520ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelsns.C37952b;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C31413au;
import com.tencent.p177mm.plugin.sns.storage.C21990h;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.ui.an */
public final class C22062an {
    private Activity czX;
    private List<bau> list = new ArrayList();

    public C22062an(Activity activity) {
        AppMethodBeat.m2504i(38962);
        this.czX = activity;
        AppMethodBeat.m2505o(38962);
    }

    /* renamed from: t */
    public final void mo37617t(View view, int i, int i2) {
        AppMethodBeat.m2504i(38963);
        mo37616a(view, i, i2, null);
        AppMethodBeat.m2505o(38963);
    }

    /* renamed from: a */
    public final void mo37616a(View view, int i, int i2, C31413au c31413au) {
        AppMethodBeat.m2504i(38964);
        if (view == null) {
            C4990ab.m7413e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] view is null! scene:%s", Integer.valueOf(i));
            AppMethodBeat.m2505o(38964);
            return;
        }
        Object tag = view.getTag();
        if (tag instanceof C29190ao) {
            C29190ao c29190ao = (C29190ao) tag;
            String str = c29190ao.czD;
            int i3 = c29190ao.index;
            int i4 = c29190ao.position;
            if (m33678dj(str, i3)) {
                C1720g.m3537RQ();
                if (C1720g.m3536RP().isSDCardAvailable()) {
                    C46236n YT = C21990h.m33616YT(str);
                    if (m33678dj(str, i3)) {
                        Intent intent = new Intent();
                        if (YT != null) {
                            C37952b lY;
                            if (c31413au != null) {
                                c31413au.qMn.mo69122x(YT);
                            }
                            TimeLineObject cqu = YT.cqu();
                            bau bau = c29190ao.index < cqu.xfI.wbK.size() ? (bau) cqu.xfI.wbK.get(c29190ao.index) : new bau();
                            if (i == 1) {
                                lY = C37952b.m64170lY(716);
                            } else {
                                lY = C37952b.m64171lZ(716);
                            }
                            lY.mo60722tx(C29036i.m46115j(YT)).mo60720mb(YT.field_type).mo60718cS(YT.mo74253DI(32)).mo60722tx(YT.crc()).mo60722tx(bau.f17915Id).mo60720mb(c29190ao.index).mo60720mb(cqu.xfI.wbK.size());
                            lY.ajK();
                            if (i == 1) {
                                lY = C37952b.m64170lY(744);
                            } else {
                                lY = C37952b.m64171lZ(744);
                            }
                            lY.mo60722tx(C29036i.m46115j(YT)).mo60720mb(YT.field_type).mo60718cS(YT.mo74253DI(32)).mo60722tx(YT.crc());
                            lY.mo60717b(intent, "intent_key_StatisticsOplog");
                            Bundle bundle = new Bundle();
                            bundle.putInt("stat_scene", 3);
                            bundle.putString("stat_msg_id", "sns_" + C29036i.m46117jV(YT.field_snsId));
                            bundle.putString("stat_send_msg_user", YT.field_userName);
                            intent.putExtra("_stat_obj", bundle);
                        } else {
                            C4990ab.m7412e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] info is null!");
                        }
                        int[] iArr = new int[2];
                        view.getLocationInWindow(iArr);
                        int width = view.getWidth();
                        int height = view.getHeight();
                        if (i == -1) {
                            intent.putExtra("k_is_from_sns_msg_ui", true);
                        }
                        intent.putExtra("sns_gallery_localId", str);
                        intent.putExtra("sns_gallery_position", i3);
                        intent.putExtra("sns_position", i4);
                        intent.putExtra("sns_gallery_showtype", 1);
                        intent.putExtra("K_ad_scene", i);
                        intent.putExtra("K_ad_source", i2);
                        intent.putExtra("k_is_from_sns_main_timeline", c29190ao.rps);
                        intent.putExtra("img_gallery_left", iArr[0]);
                        intent.putExtra("img_gallery_top", iArr[1]);
                        intent.putExtra("img_gallery_width", width);
                        intent.putExtra("img_gallery_height", height);
                        intent.setClass(this.czX, SnsBrowseUI.class);
                        this.czX.startActivity(intent);
                        this.czX.overridePendingTransition(0, 0);
                    } else {
                        C4990ab.m7413e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] initDataMediaList, localId:%s position:%s", str, Integer.valueOf(i3));
                        AppMethodBeat.m2505o(38964);
                        return;
                    }
                }
                C4990ab.m7412e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] isSDCardAvailable:false");
                AppMethodBeat.m2505o(38964);
                return;
            }
            C4990ab.m7413e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] initDataMediaList, localId:%s position:%s", str, Integer.valueOf(i3));
            AppMethodBeat.m2505o(38964);
            return;
        }
        AppMethodBeat.m2505o(38964);
    }

    /* renamed from: dj */
    private boolean m33678dj(String str, int i) {
        AppMethodBeat.m2504i(38965);
        C46236n YT = C21990h.m33616YT(str);
        if (YT == null) {
            C4990ab.m7413e("MicroMsg.SnsImageDialogShowerMgr", "[initDataMediaList] snsinfo is null! localId:%s index:%ss", str, Integer.valueOf(i));
            AppMethodBeat.m2505o(38965);
            return false;
        }
        TimeLineObject cqu = YT.cqu();
        if (cqu.xfI == null) {
            C4990ab.m7412e("MicroMsg.SnsImageDialogShowerMgr", "[initDataMediaList] timeline.ContentObj is null!");
            AppMethodBeat.m2505o(38965);
            return false;
        } else if (cqu.xfI.wbK.size() == 0) {
            C4990ab.m7412e("MicroMsg.SnsImageDialogShowerMgr", "[initDataMediaList] timeline.ContentObj.MediaObjList.size() == 0");
            AppMethodBeat.m2505o(38965);
            return false;
        } else {
            this.list.clear();
            Iterator it = cqu.xfI.wbK.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                bau bau = (bau) it.next();
                this.list.add(bau);
                if (i != i2 || C13373af.cnC().mo37429B(bau)) {
                    i2++;
                } else {
                    C4990ab.m7412e("MicroMsg.SnsImageDialogShowerMgr", "[initDataMediaList] is not exists");
                    AppMethodBeat.m2505o(38965);
                    return false;
                }
            }
            AppMethodBeat.m2505o(38965);
            return true;
        }
    }
}
