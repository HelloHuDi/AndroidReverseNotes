package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.au;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class an {
    private Activity czX;
    private List<bau> list = new ArrayList();

    public an(Activity activity) {
        AppMethodBeat.i(38962);
        this.czX = activity;
        AppMethodBeat.o(38962);
    }

    public final void t(View view, int i, int i2) {
        AppMethodBeat.i(38963);
        a(view, i, i2, null);
        AppMethodBeat.o(38963);
    }

    public final void a(View view, int i, int i2, au auVar) {
        AppMethodBeat.i(38964);
        if (view == null) {
            ab.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] view is null! scene:%s", Integer.valueOf(i));
            AppMethodBeat.o(38964);
            return;
        }
        Object tag = view.getTag();
        if (tag instanceof ao) {
            ao aoVar = (ao) tag;
            String str = aoVar.czD;
            int i3 = aoVar.index;
            int i4 = aoVar.position;
            if (dj(str, i3)) {
                g.RQ();
                if (g.RP().isSDCardAvailable()) {
                    n YT = h.YT(str);
                    if (dj(str, i3)) {
                        Intent intent = new Intent();
                        if (YT != null) {
                            b lY;
                            if (auVar != null) {
                                auVar.qMn.x(YT);
                            }
                            TimeLineObject cqu = YT.cqu();
                            bau bau = aoVar.index < cqu.xfI.wbK.size() ? (bau) cqu.xfI.wbK.get(aoVar.index) : new bau();
                            if (i == 1) {
                                lY = b.lY(716);
                            } else {
                                lY = b.lZ(716);
                            }
                            lY.tx(i.j(YT)).mb(YT.field_type).cS(YT.DI(32)).tx(YT.crc()).tx(bau.Id).mb(aoVar.index).mb(cqu.xfI.wbK.size());
                            lY.ajK();
                            if (i == 1) {
                                lY = b.lY(744);
                            } else {
                                lY = b.lZ(744);
                            }
                            lY.tx(i.j(YT)).mb(YT.field_type).cS(YT.DI(32)).tx(YT.crc());
                            lY.b(intent, "intent_key_StatisticsOplog");
                            Bundle bundle = new Bundle();
                            bundle.putInt("stat_scene", 3);
                            bundle.putString("stat_msg_id", "sns_" + i.jV(YT.field_snsId));
                            bundle.putString("stat_send_msg_user", YT.field_userName);
                            intent.putExtra("_stat_obj", bundle);
                        } else {
                            ab.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] info is null!");
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
                        intent.putExtra("k_is_from_sns_main_timeline", aoVar.rps);
                        intent.putExtra("img_gallery_left", iArr[0]);
                        intent.putExtra("img_gallery_top", iArr[1]);
                        intent.putExtra("img_gallery_width", width);
                        intent.putExtra("img_gallery_height", height);
                        intent.setClass(this.czX, SnsBrowseUI.class);
                        this.czX.startActivity(intent);
                        this.czX.overridePendingTransition(0, 0);
                    } else {
                        ab.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] initDataMediaList, localId:%s position:%s", str, Integer.valueOf(i3));
                        AppMethodBeat.o(38964);
                        return;
                    }
                }
                ab.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] isSDCardAvailable:false");
                AppMethodBeat.o(38964);
                return;
            }
            ab.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] initDataMediaList, localId:%s position:%s", str, Integer.valueOf(i3));
            AppMethodBeat.o(38964);
            return;
        }
        AppMethodBeat.o(38964);
    }

    private boolean dj(String str, int i) {
        AppMethodBeat.i(38965);
        n YT = h.YT(str);
        if (YT == null) {
            ab.e("MicroMsg.SnsImageDialogShowerMgr", "[initDataMediaList] snsinfo is null! localId:%s index:%ss", str, Integer.valueOf(i));
            AppMethodBeat.o(38965);
            return false;
        }
        TimeLineObject cqu = YT.cqu();
        if (cqu.xfI == null) {
            ab.e("MicroMsg.SnsImageDialogShowerMgr", "[initDataMediaList] timeline.ContentObj is null!");
            AppMethodBeat.o(38965);
            return false;
        } else if (cqu.xfI.wbK.size() == 0) {
            ab.e("MicroMsg.SnsImageDialogShowerMgr", "[initDataMediaList] timeline.ContentObj.MediaObjList.size() == 0");
            AppMethodBeat.o(38965);
            return false;
        } else {
            this.list.clear();
            Iterator it = cqu.xfI.wbK.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                bau bau = (bau) it.next();
                this.list.add(bau);
                if (i != i2 || af.cnC().B(bau)) {
                    i2++;
                } else {
                    ab.e("MicroMsg.SnsImageDialogShowerMgr", "[initDataMediaList] is not exists");
                    AppMethodBeat.o(38965);
                    return false;
                }
            }
            AppMethodBeat.o(38965);
            return true;
        }
    }
}
