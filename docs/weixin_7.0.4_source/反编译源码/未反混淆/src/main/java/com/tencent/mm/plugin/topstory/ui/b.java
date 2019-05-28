package com.tencent.mm.plugin.topstory.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.g.a.te;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.PluginTopStory;
import com.tencent.mm.plugin.topstory.ui.debug.TopStoryDebugUI;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.protocal.protobuf.cht;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.vfs.e;

public final class b implements a {
    public boolean sBj;
    public boolean sBk;
    public boolean sBl;

    public final boolean a(Context context, String[] strArr, String str) {
        AppMethodBeat.i(1528);
        if (ab.getLogLevel() > 1) {
            AppMethodBeat.o(1528);
            return false;
        } else if (strArr.length < 2) {
            AppMethodBeat.o(1528);
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
                    g.RP().Ry().set(ac.a.USERINFO_TOP_STORY_RED_DOT_RESULT_STRING, (Object) "");
                    break;
                case 1:
                    te teVar = new te();
                    teVar.cPr.actionType = 2;
                    com.tencent.mm.sdk.b.a.xxA.m(teVar);
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
                                ((PluginTopStory) g.M(PluginTopStory.class)).getRedDotMgr().a(cht);
                                break;
                            }
                            ((PluginTopStory) g.M(PluginTopStory.class)).getRedDotMgr().m("111111", "{\"globalId\":\"assistant_my_colike\"}", System.currentTimeMillis() / 1000);
                            break;
                        }
                        ((PluginTopStory) g.M(PluginTopStory.class)).getRedDotMgr().b(cht);
                        break;
                    }
                    ((PluginTopStory) g.M(PluginTopStory.class)).getRedDotMgr();
                    com.tencent.mm.plugin.topstory.b.abx("testmsgid000");
                    break;
                case 6:
                    ((PluginTopStory) g.M(PluginTopStory.class)).getRedDotMgr().Fx(1);
                    ((PluginTopStory) g.M(PluginTopStory.class)).getRedDotMgr().Fx(7);
                    ((PluginTopStory) g.M(PluginTopStory.class)).getRedDotMgr().Fx(8);
                    g.RP().Ry().set(ac.a.USERINFO_TOP_STORY_REDDOT_TIMESTAMP_LONG, Long.valueOf(0));
                    g.RP().Ry().set(ac.a.USERINFO_TOP_STORY_CMTREDDOT_TIMESTAMP_LONG, Long.valueOf(0));
                    g.RP().Ry().set(ac.a.USERINFO_TOP_STORY_CMTREDDOT_SEQ_INT, Integer.valueOf(0));
                    break;
                case 7:
                    g.RP().Ry().set(ac.a.USERINFO_TOP_STORY_LAST_REPORT_H5VERSION_TIME_LONG, Long.valueOf(0));
                    g.RP().Ry().dsb();
                    break;
                case 8:
                    cEW = ((PluginTopStory) g.M(PluginTopStory.class)).getRedDotMgr().cEW();
                    if (cEW == null) {
                        Context context3 = ah.getContext();
                        StringBuilder stringBuilder = new StringBuilder("no cmtrdts:");
                        ((PluginTopStory) g.M(PluginTopStory.class)).getRedDotMgr();
                        t.makeText(context3, stringBuilder.append(com.tencent.mm.plugin.topstory.b.cEZ()).toString(), 0).show();
                        break;
                    }
                    context2 = ah.getContext();
                    append = new StringBuilder("count:").append(((PluginTopStory) g.M(PluginTopStory.class)).getRedDotMgr().cEU()).append("cmt: ");
                    ((PluginTopStory) g.M(PluginTopStory.class)).getRedDotMgr();
                    StringBuilder append2 = append.append(com.tencent.mm.plugin.topstory.b.d(cEW)).append("ts:");
                    ((PluginTopStory) g.M(PluginTopStory.class)).getRedDotMgr();
                    t.makeText(context2, append2.append(com.tencent.mm.plugin.topstory.b.cEZ()).toString(), 0).show();
                    break;
                case 9:
                    cEW = ((PluginTopStory) g.M(PluginTopStory.class)).getRedDotMgr().sAm;
                    if (cEW == null) {
                        t.makeText(ah.getContext(), "no cntrd", 0).show();
                        break;
                    }
                    context2 = ah.getContext();
                    append = new StringBuilder("cnt: ");
                    ((PluginTopStory) g.M(PluginTopStory.class)).getRedDotMgr();
                    t.makeText(context2, append.append(com.tencent.mm.plugin.topstory.b.d(cEW)).toString(), 0).show();
                    break;
                case 10:
                    try {
                        String cy = e.cy(com.tencent.mm.compatible.util.e.eSn + "topstory/trace.info");
                        View textView = new TextView(context);
                        textView.setText(cy);
                        textView.setGravity(19);
                        textView.setTextSize(1, 10.0f);
                        textView.setLayoutParams(new LayoutParams(-1, -2));
                        textView.setTextColor(-16711936);
                        textView.setTypeface(Typeface.MONOSPACE);
                        i = context.getResources().getDimensionPixelSize(R.dimen.l5);
                        textView.setPadding(i, i, i, i);
                        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
                        h.a(context, null, textView, null);
                        break;
                    } catch (Exception e2) {
                        break;
                    }
                case 11:
                    e.N(aa.HQ(1).aLD(), true);
                    Process.killProcess(Process.myPid());
                    break;
                case 12:
                    ah.getContext().startActivity(new Intent(ah.getContext(), TopStoryDebugUI.class));
                    break;
                case 13:
                    g.RP().Ry().set(ac.a.USERINFO_TOP_STORY_FS_SCROLL_TIPS_INT, Integer.valueOf(0));
                    g.RP().Ry().set(ac.a.USERINFO_TOP_STORY_SHORT_VIDEO_FS_SCROLL_TIPS_INT, Integer.valueOf(0));
                    break;
                case 14:
                    g.RP().Ry().set(ac.a.USERINFO_TOP_STORY_VIDEO_EDUCATION_INT, Integer.valueOf(0));
                    g.RP().Ry().dsb();
                    break;
            }
            AppMethodBeat.o(1528);
            return true;
        }
    }
}
