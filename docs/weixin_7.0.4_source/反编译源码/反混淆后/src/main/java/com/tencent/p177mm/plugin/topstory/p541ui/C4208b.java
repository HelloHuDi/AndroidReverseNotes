package com.tencent.p177mm.plugin.topstory.p541ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Process;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p231a.C9477te;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.topstory.C35295b;
import com.tencent.p177mm.plugin.topstory.PluginTopStory;
import com.tencent.p177mm.plugin.topstory.p541ui.debug.TopStoryDebugUI;
import com.tencent.p177mm.plugin.websearch.api.C46400aa;
import com.tencent.p177mm.pluginsdk.cmd.C44041a;
import com.tencent.p177mm.protocal.protobuf.cht;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.plugin.topstory.ui.b */
public final class C4208b implements C44041a {
    public boolean sBj;
    public boolean sBk;
    public boolean sBl;

    /* renamed from: a */
    public final boolean mo7165a(Context context, String[] strArr, String str) {
        AppMethodBeat.m2504i(1528);
        if (C4990ab.getLogLevel() > 1) {
            AppMethodBeat.m2505o(1528);
            return false;
        } else if (strArr.length < 2) {
            AppMethodBeat.m2505o(1528);
            return true;
        } else {
            String str2 = strArr[1];
            int i = -1;
            switch (str2.hashCode()) {
                case 3173:
                    if (str2.equals("ch")) {
                        i = 0;
                        break;
                    }
                    break;
                case 3183:
                    if (str2.equals("cr")) {
                        i = 4;
                        break;
                    }
                    break;
                case 3185:
                    if (str2.equals(UserDataStore.CITY)) {
                        i = 11;
                        break;
                    }
                    break;
                case 3186:
                    if (str2.equals("cu")) {
                        i = 1;
                        break;
                    }
                    break;
                case 3212:
                    if (str2.equals("dp")) {
                        i = 12;
                        break;
                    }
                    break;
                case 3489:
                    if (str2.equals("mn")) {
                        i = 3;
                        break;
                    }
                    break;
                case 3634:
                    if (str2.equals("rd")) {
                        i = 5;
                        break;
                    }
                    break;
                case 3681:
                    if (str2.equals(UserDataStore.STATE)) {
                        i = 2;
                        break;
                    }
                    break;
                case 98820:
                    if (str2.equals("cst")) {
                        i = 13;
                        break;
                    }
                    break;
                case 3056749:
                    if (str2.equals("clrv")) {
                        i = 7;
                        break;
                    }
                    break;
                case 3237038:
                    if (str2.equals("info")) {
                        i = 10;
                        break;
                    }
                    break;
                case 3495451:
                    if (str2.equals("rdcl")) {
                        i = 6;
                        break;
                    }
                    break;
                case 94746285:
                    if (str2.equals("cledu")) {
                        i = 14;
                        break;
                    }
                    break;
                case 94790908:
                    if (str2.equals("cmtrd")) {
                        i = 8;
                        break;
                    }
                    break;
                case 94820699:
                    if (str2.equals("cntrd")) {
                        i = 9;
                        break;
                    }
                    break;
            }
            cht cEW;
            Context context2;
            StringBuilder append;
            switch (i) {
                case 0:
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_TOP_STORY_RED_DOT_RESULT_STRING, (Object) "");
                    break;
                case 1:
                    C9477te c9477te = new C9477te();
                    c9477te.cPr.actionType = 2;
                    C4879a.xxA.mo10055m(c9477te);
                    break;
                case 2:
                    this.sBj = true;
                    break;
                case 3:
                    this.sBk = true;
                    break;
                case 4:
                    this.sBl = true;
                    break;
                case 5:
                    cht cht = new cht();
                    cht.cJb = System.currentTimeMillis();
                    cht.text = "测试测试";
                    try {
                        cht.uaU = Integer.valueOf(strArr[2]).intValue();
                        cht.type = Integer.valueOf(strArr[3]).intValue();
                    } catch (Exception e) {
                        cht.uaU = 2;
                        cht.type = 1;
                    }
                    cht.xgB = System.currentTimeMillis();
                    cht.fRS = 300;
                    cht.xgz = System.currentTimeMillis() / 1000;
                    cht.uaW = 1;
                    if (cht.type != 8) {
                        if (cht.type != 7) {
                            if (cht.type != 10) {
                                ((PluginTopStory) C1720g.m3530M(PluginTopStory.class)).getRedDotMgr().mo56016a(cht);
                                break;
                            }
                            ((PluginTopStory) C1720g.m3530M(PluginTopStory.class)).getRedDotMgr().mo56039m("111111", "{\"globalId\":\"assistant_my_colike\"}", System.currentTimeMillis() / 1000);
                            break;
                        }
                        ((PluginTopStory) C1720g.m3530M(PluginTopStory.class)).getRedDotMgr().mo56018b(cht);
                        break;
                    }
                    ((PluginTopStory) C1720g.m3530M(PluginTopStory.class)).getRedDotMgr();
                    C35295b.abx("testmsgid000");
                    break;
                case 6:
                    ((PluginTopStory) C1720g.m3530M(PluginTopStory.class)).getRedDotMgr().mo56012Fx(1);
                    ((PluginTopStory) C1720g.m3530M(PluginTopStory.class)).getRedDotMgr().mo56012Fx(7);
                    ((PluginTopStory) C1720g.m3530M(PluginTopStory.class)).getRedDotMgr().mo56012Fx(8);
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_TOP_STORY_REDDOT_TIMESTAMP_LONG, Long.valueOf(0));
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_TOP_STORY_CMTREDDOT_TIMESTAMP_LONG, Long.valueOf(0));
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_TOP_STORY_CMTREDDOT_SEQ_INT, Integer.valueOf(0));
                    break;
                case 7:
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_TOP_STORY_LAST_REPORT_H5VERSION_TIME_LONG, Long.valueOf(0));
                    C1720g.m3536RP().mo5239Ry().dsb();
                    break;
                case 8:
                    cEW = ((PluginTopStory) C1720g.m3530M(PluginTopStory.class)).getRedDotMgr().cEW();
                    if (cEW == null) {
                        Context context3 = C4996ah.getContext();
                        StringBuilder stringBuilder = new StringBuilder("no cmtrdts:");
                        ((PluginTopStory) C1720g.m3530M(PluginTopStory.class)).getRedDotMgr();
                        C23639t.makeText(context3, stringBuilder.append(C35295b.cEZ()).toString(), 0).show();
                        break;
                    }
                    context2 = C4996ah.getContext();
                    append = new StringBuilder("count:").append(((PluginTopStory) C1720g.m3530M(PluginTopStory.class)).getRedDotMgr().cEU()).append("cmt: ");
                    ((PluginTopStory) C1720g.m3530M(PluginTopStory.class)).getRedDotMgr();
                    StringBuilder append2 = append.append(C35295b.m57966d(cEW)).append("ts:");
                    ((PluginTopStory) C1720g.m3530M(PluginTopStory.class)).getRedDotMgr();
                    C23639t.makeText(context2, append2.append(C35295b.cEZ()).toString(), 0).show();
                    break;
                case 9:
                    cEW = ((PluginTopStory) C1720g.m3530M(PluginTopStory.class)).getRedDotMgr().sAm;
                    if (cEW == null) {
                        C23639t.makeText(C4996ah.getContext(), "no cntrd", 0).show();
                        break;
                    }
                    context2 = C4996ah.getContext();
                    append = new StringBuilder("cnt: ");
                    ((PluginTopStory) C1720g.m3530M(PluginTopStory.class)).getRedDotMgr();
                    C23639t.makeText(context2, append.append(C35295b.m57966d(cEW)).toString(), 0).show();
                    break;
                case 10:
                    try {
                        String cy = C5730e.m8631cy(C6457e.eSn + "topstory/trace.info");
                        View textView = new TextView(context);
                        textView.setText(cy);
                        textView.setGravity(19);
                        textView.setTextSize(1, 10.0f);
                        textView.setLayoutParams(new LayoutParams(-1, -2));
                        textView.setTextColor(-16711936);
                        textView.setTypeface(Typeface.MONOSPACE);
                        i = context.getResources().getDimensionPixelSize(C25738R.dimen.f9948l5);
                        textView.setPadding(i, i, i, i);
                        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
                        C30379h.m48435a(context, null, textView, null);
                        break;
                    } catch (Exception e2) {
                        break;
                    }
                case 11:
                    C5730e.m8618N(C46400aa.m87300HQ(1).aLD(), true);
                    Process.killProcess(Process.myPid());
                    break;
                case 12:
                    C4996ah.getContext().startActivity(new Intent(C4996ah.getContext(), TopStoryDebugUI.class));
                    break;
                case 13:
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_TOP_STORY_FS_SCROLL_TIPS_INT, Integer.valueOf(0));
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_TOP_STORY_SHORT_VIDEO_FS_SCROLL_TIPS_INT, Integer.valueOf(0));
                    break;
                case 14:
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_TOP_STORY_VIDEO_EDUCATION_INT, Integer.valueOf(0));
                    C1720g.m3536RP().mo5239Ry().dsb();
                    break;
            }
            AppMethodBeat.m2505o(1528);
            return true;
        }
    }
}
