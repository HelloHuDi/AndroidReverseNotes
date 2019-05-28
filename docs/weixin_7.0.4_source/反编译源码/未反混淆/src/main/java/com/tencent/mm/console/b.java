package com.tencent.mm.console;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Debug.MemoryInfo;
import android.os.Looper;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.internal.ImagesContract;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.console.a.a.a;
import com.tencent.mm.console.a.c;
import com.tencent.mm.console.a.d;
import com.tencent.mm.console.a.e;
import com.tencent.mm.console.a.f;
import com.tencent.mm.console.a.g;
import com.tencent.mm.console.a.h;
import com.tencent.mm.console.a.i;
import com.tencent.mm.console.a.j;
import com.tencent.mm.console.a.k;
import com.tencent.mm.console.a.l;
import com.tencent.mm.console.a.m;
import com.tencent.mm.console.a.n;
import com.tencent.mm.g.a.bf;
import com.tencent.mm.g.a.bm;
import com.tencent.mm.g.a.ci;
import com.tencent.mm.g.a.cn;
import com.tencent.mm.g.a.co;
import com.tencent.mm.g.a.cp;
import com.tencent.mm.g.a.cq;
import com.tencent.mm.g.a.gu;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.g.a.mz;
import com.tencent.mm.g.a.qz;
import com.tencent.mm.g.a.rc;
import com.tencent.mm.g.a.rn;
import com.tencent.mm.g.a.rt;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.g.a.vv;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.ao;
import com.tencent.mm.model.av;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.modelstat.WatchDogPushReceiver;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.SpellMap;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.mm.plugin.appbrand.jsapi.v;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearSendUI;
import com.tencent.mm.plugin.sns.ui.aq;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.protocal.protobuf.bdi;
import com.tencent.mm.protocal.protobuf.bdj;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.protocal.z;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bs;
import com.tencent.mm.storage.w;
import com.tencent.mm.storage.y;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.ChattingUIFragment;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.sqlitelint.util.SQLiteLintUtil;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.wcdb.database.SQLiteGlobal;
import com.tencent.xweb.WebView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.Thread.State;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import junit.framework.Assert;

public final class b {
    private static final HashSet<String> ewd;

    static /* synthetic */ boolean D(Context context, String str) {
        AppMethodBeat.i(16105);
        boolean C = C(context, str);
        AppMethodBeat.o(16105);
        return C;
    }

    static {
        boolean z = true;
        AppMethodBeat.i(16106);
        d.init();
        i.init();
        j.init();
        g.init();
        e.init();
        f.init();
        com.tencent.mm.console.a.b.init();
        c.init();
        m.init();
        h.init();
        k.init();
        n.init();
        l.init();
        try {
            Class.forName("com.tencent.mm.console.a.b.a");
        } catch (Throwable th) {
            ab.printErrStackTrace("MicroMsg.CommandProcessor", th, "", new Object[0]);
        }
        com.tencent.mm.pluginsdk.cmd.b.a(new a(), "//fsd");
        com.tencent.mm.pluginsdk.cmd.b.a(new com.tencent.mm.console.a.a.b(), "//hcsetting");
        com.tencent.mm.pluginsdk.cmd.b.a(new com.tencent.mm.console.a.a(), "//clearrecent");
        HashSet hashSet = new HashSet();
        ewd = hashSet;
        hashSet.add("//uplog");
        ewd.add("//pullxlog");
        ewd.add("//upcrash");
        ewd.add("//getfpkey");
        ewd.add("//voipdebug");
        ewd.add("//setkey");
        ewd.add("//wxcamera");
        ewd.add("//deletetbs");
        ewd.add("//setNfcOpenUrl");
        if (ewd.size() != 9) {
            z = false;
        }
        Assert.assertTrue(z);
        AppMethodBeat.o(16106);
    }

    private static int kK(String str) {
        AppMethodBeat.i(16097);
        if (!str.startsWith("//") || str.length() <= 2) {
            AppMethodBeat.o(16097);
            return 0;
        }
        int indexOf = str.indexOf(" ");
        if (indexOf == -1) {
            indexOf = str.length();
        }
        try {
            indexOf = bo.getInt(str.substring(2, indexOf), 0);
            int i = com.tencent.mm.protocal.d.vxo % 256;
            if (i == 0 || indexOf < i || indexOf % i != 0) {
                AppMethodBeat.o(16097);
                return 0;
            }
            int i2 = indexOf / i;
            AppMethodBeat.o(16097);
            return i2;
        } catch (Exception e) {
            AppMethodBeat.o(16097);
            return 0;
        }
    }

    private static String kL(String str) {
        AppMethodBeat.i(16098);
        int indexOf = str.indexOf(" ");
        String str2;
        if (indexOf < 0) {
            str2 = "";
            AppMethodBeat.o(16098);
            return str2;
        }
        str2 = str.substring(indexOf).trim();
        AppMethodBeat.o(16098);
        return str2;
    }

    private static boolean kM(String str) {
        AppMethodBeat.i(16099);
        Iterator it = ewd.iterator();
        while (it.hasNext()) {
            if (str.startsWith((String) it.next())) {
                AppMethodBeat.o(16099);
                return true;
            }
        }
        AppMethodBeat.o(16099);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:362:0x101b  */
    /* JADX WARNING: Removed duplicated region for block: B:360:0x0fe1  */
    /* JADX WARNING: Removed duplicated region for block: B:360:0x0fe1  */
    /* JADX WARNING: Removed duplicated region for block: B:362:0x101b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean i(final Context context, final String str, String str2) {
        AppMethodBeat.i(16100);
        String[] split;
        StringBuilder stringBuilder;
        View textView;
        int dimensionPixelSize;
        SharedPreferences sharedPreferences;
        Editor edit;
        if (!str.startsWith("//")) {
            AppMethodBeat.o(16100);
            return false;
        } else if (1 < ab.getLogLevel() && !kM(str)) {
            ab.i("MicroMsg.CommandProcessor", "summer processed log level[%s], need open debug ret false", Integer.valueOf(ab.getLogLevel()));
            AppMethodBeat.o(16100);
            return false;
        } else if (com.tencent.mm.pluginsdk.cmd.b.B(context, str, str2)) {
            AppMethodBeat.o(16100);
            return true;
        } else if (str.startsWith("//clearWXSNSDB")) {
            com.tencent.mm.sdk.b.a.xxA.m(new qz());
            AppMethodBeat.o(16100);
            return true;
        } else if (str.startsWith("//verifytokenerror")) {
            ae.gjr = true;
            AppMethodBeat.o(16100);
            return true;
        } else if (str.startsWith("//testLqt")) {
            split = str.split(" ");
            if (split.length == 2) {
                if (bo.getInt(split[1], 0) == 1) {
                    ae.gjw = true;
                } else {
                    ae.gjw = false;
                }
            }
            AppMethodBeat.o(16100);
            return true;
        } else if (str.startsWith("//resetbackupdata")) {
            aw.ZK();
            com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_BACKUP_PC_BACKUPING_BOOLEAN, Boolean.FALSE);
            aw.ZK();
            com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_BACKUP_PC_RECOVERING_BOOLEAN, Boolean.FALSE);
            aw.ZK();
            com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_BACKUP_PC_MERGERING_BOOLEAN, Boolean.FALSE);
            aw.ZK();
            com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_BACKUP_MOVE_BACKUPING_BOOLEAN, Boolean.FALSE);
            aw.ZK();
            com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_BACKUP_MOVE_RECOVERING_BOOLEAN, Boolean.FALSE);
            aw.ZK();
            com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_BACKUP_MOVE_MERGERING_BOOLEAN, Boolean.FALSE);
            aw.ZK().Yq().drx();
            aw.ZK().Yr().drx();
            aw.ZK().Yp().drx();
            Toast.makeText(ah.getContext(), "backup data has been reset!", 1).show();
            AppMethodBeat.o(16100);
            return true;
        } else if (str.startsWith("//threadpool replace")) {
            if (str.startsWith("//threadpool replace false")) {
                ah.doB().edit().putBoolean("REPLACE_WORKER_BOOLEAN", false).commit();
            } else if (str.startsWith("//threadpool replace true")) {
                ah.doB().edit().putBoolean("REPLACE_WORKER_BOOLEAN", true).commit();
            }
            AppMethodBeat.o(16100);
            return true;
        } else if (str.equalsIgnoreCase("//ftsmsbiz")) {
            bdj cVo = ai.cVo();
            stringBuilder = new StringBuilder();
            Iterator it = cVo.jBw.iterator();
            while (it.hasNext()) {
                bdi bdi = (bdi) it.next();
                stringBuilder.append(String.format("%s | %.2f | %s", new Object[]{s.mJ(bdi.vHl), Double.valueOf(bdi.wHm), com.tencent.mm.pluginsdk.f.h.formatTime(SQLiteLintUtil.YYYY_MM_DD_HH_mm, bdi.wHn / 1000)}));
                stringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX);
            }
            textView = new TextView(context);
            textView.setText(stringBuilder.toString());
            textView.setGravity(19);
            textView.setTextSize(1, 10.0f);
            textView.setLayoutParams(new LayoutParams(-1, -2));
            textView.setTextColor(-16711936);
            textView.setTypeface(Typeface.MONOSPACE);
            dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.l5);
            textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            com.tencent.mm.ui.base.h.a(context, null, textView, null);
            AppMethodBeat.o(16100);
            return true;
        } else if (str.startsWith("//cleanww")) {
            ((com.tencent.mm.openim.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.openim.a.b.class)).anw();
            AppMethodBeat.o(16100);
            return true;
        } else if (str.startsWith("//setgamejs")) {
            split = str.split(" ");
            if (split.length == 2) {
                if (split[1] == null || split[1].isEmpty() || split[1].endsWith("/")) {
                    t.makeText(context, "param set error, please don't end with /", 0).show();
                } else {
                    sharedPreferences = ah.getContext().getSharedPreferences("app_brand_global_sp", 0);
                    if (sharedPreferences != null) {
                        edit = sharedPreferences.edit();
                        edit.remove("app_brand_game_js_path");
                        edit.commit();
                        if (!split[1].equalsIgnoreCase(BuildConfig.COMMAND)) {
                            edit.putString("app_brand_game_js_path", split[1]);
                            edit.commit();
                        }
                    }
                }
            }
            AppMethodBeat.o(16100);
            return true;
        } else {
            if (com.tencent.mm.sdk.a.b.dnO()) {
                if (str.startsWith("//launchapp clear")) {
                    com.tencent.mm.kernel.g.RP().Ry().set(ac.a.USERINFO_LAUNCH_APP_NOT_ASK_PKG_STRING, (Object) "");
                    AppMethodBeat.o(16100);
                    return true;
                } else if (str.startsWith("//setsupportwxcode")) {
                    com.tencent.mm.kernel.g.RP().Ry().set(ac.a.USERINFO_SET_SUPPORT_WX_CODE_BOOLEAN, Boolean.TRUE);
                    AppMethodBeat.o(16100);
                    return true;
                } else if (str.startsWith("//setnotsupportwxcode")) {
                    com.tencent.mm.kernel.g.RP().Ry().set(ac.a.USERINFO_SET_SUPPORT_WX_CODE_BOOLEAN, Boolean.FALSE);
                    AppMethodBeat.o(16100);
                    return true;
                } else if (str.startsWith("//resetsupportwxcode")) {
                    com.tencent.mm.kernel.g.RP().Ry().set(ac.a.USERINFO_SET_SUPPORT_WX_CODE_BOOLEAN, null);
                    AppMethodBeat.o(16100);
                    return true;
                }
            }
            Intent intent;
            if (str.startsWith("//testsightwidget")) {
                intent = new Intent();
                intent.putExtra("KSightPath", "/mnt/sdcard/tencent/tempvideo4.mp4");
                intent.putExtra("KSightThumbPath", "");
                intent.putExtra("sight_md5", com.tencent.mm.vfs.e.atg("/mnt/sdcard/tencent/tempvideo4.mp4"));
                intent.putExtra("KSnsPostManu", true);
                intent.putExtra("KTouchCameraTime", bo.anT());
                intent.putExtra("Ksnsupload_type", 14);
                com.tencent.mm.bp.d.b(context, "sns", ".ui.SnsUploadUI", intent);
                AppMethodBeat.o(16100);
                return true;
            } else if (str.startsWith("//openremitbank")) {
                com.tencent.mm.kernel.g.RP().Ry().set(ac.a.USERINFO_WALLET_BANK_REMIT_OPEN_INT_SYNC, Integer.valueOf(1));
                AppMethodBeat.o(16100);
                return true;
            } else if (str.startsWith("//chatroomdebug ")) {
                if (str.substring(str.indexOf(" ") + 1).equalsIgnoreCase("true")) {
                    ((com.tencent.mm.plugin.chatroom.a.c) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.chatroom.a.c.class)).fN(true);
                } else {
                    ((com.tencent.mm.plugin.chatroom.a.c) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.chatroom.a.c.class)).fN(false);
                }
                AppMethodBeat.o(16100);
                return true;
            } else if (str.startsWith("//angerbag")) {
                com.tencent.mm.kernel.g.RP().Ry().set(ac.a.USERINFO_WEBVIEW_BAG_TEST_INFO_STRING_SYNC, ((String) com.tencent.mm.kernel.g.RP().Ry().get(ac.a.USERINFO_WEBVIEW_BAG_TEST_INFO_STRING_SYNC, AppEventsConstants.EVENT_PARAM_VALUE_NO)).equals(AppEventsConstants.EVENT_PARAM_VALUE_NO) ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
                AppMethodBeat.o(16100);
                return true;
            } else if (str.startsWith("//clearbag")) {
                com.tencent.mm.kernel.g.RP().Ry().set(ac.a.USERINFO_WEBVIEW_BAG_INFO_STRING_SYNC, (Object) "");
                AppMethodBeat.o(16100);
                return true;
            } else if (str.startsWith("//closeremitbank")) {
                com.tencent.mm.kernel.g.RP().Ry().set(ac.a.USERINFO_WALLET_BANK_REMIT_OPEN_INT_SYNC, Integer.valueOf(0));
                AppMethodBeat.o(16100);
                return true;
            } else {
                if (str.startsWith("//ftstemplatetest")) {
                    bf bfVar = new bf();
                    bfVar.cus.cut = 27;
                    bfVar.cus.cut = 1;
                    bfVar.cus.filePath = "/sdcard/fts_template.zip";
                    com.tencent.mm.sdk.b.a.xxA.m(bfVar);
                }
                String str3;
                String[] split2;
                Intent intent2;
                String[] split3;
                int intValue;
                final String gA;
                if (str.startsWith("//sightforward")) {
                    intent = new Intent();
                    intent.setClassName(context, "com.tencent.mm.ui.transmit.SightForwardUI");
                    context.startActivity(intent);
                    AppMethodBeat.o(16100);
                    return true;
                } else if (str.startsWith("//remit")) {
                    com.tencent.mm.bp.d.b(context, "remittance", ".ui.RemittanceBusiUI", new Intent());
                    AppMethodBeat.o(16100);
                    return true;
                } else if (str.startsWith("//fixtools")) {
                    intent = new Intent();
                    intent.setClassName(context, "com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUI");
                    intent.putExtra("entry_fix_tools", 2);
                    context.startActivity(intent);
                    AppMethodBeat.o(16100);
                    return true;
                } else if (str.startsWith("//uplog")) {
                    intent = new Intent();
                    intent.setClassName(context, "com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUplogUI");
                    intent.putExtra("entry_fix_tools_uplog", 5);
                    MMWizardActivity.J(context, intent);
                    AppMethodBeat.o(16100);
                    return true;
                } else if (str.startsWith("//pullxlog")) {
                    ab.moveLogsFromCacheDirToLogDir();
                    Toast.makeText(context, "move success", 0).show();
                    AppMethodBeat.o(16100);
                    return true;
                } else if (str.startsWith("//upcrash")) {
                    str3 = "weixin";
                    if (aw.RK()) {
                        str3 = r.Yz();
                    }
                    split2 = str.split(" ");
                    dimensionPixelSize = 0;
                    if (split2 != null) {
                        if (split2.length > 1) {
                            dimensionPixelSize = bo.getInt(split2[1], 0);
                        }
                        if (split2.length > 2) {
                            str3 = split2[2];
                        }
                    }
                    aw.Rg().d(new bk(new bk.a() {
                        public final void a(com.tencent.mm.network.e eVar) {
                            AppMethodBeat.i(16072);
                            aw.Rg().a(3, str3, dimensionPixelSize, aw.RK());
                            AppMethodBeat.o(16072);
                        }
                    }));
                    AppMethodBeat.o(16100);
                    return true;
                } else if (str.startsWith("//fixError0831")) {
                    ab.i("MicroMsg.CommandProcessor", "fixError0831");
                    com.tencent.mm.sdk.b.a.xxA.m(new bm());
                    AppMethodBeat.o(16100);
                    return true;
                } else if (str.startsWith("//resetbankremit")) {
                    com.tencent.mm.kernel.g.RP().Ry().set(ac.a.USERINFO_WALLET_BANK_REMIT_HAS_SHOWN_RED_DOT_INT_SYNC, Integer.valueOf(0));
                    AppMethodBeat.o(16100);
                    return true;
                } else if (str.startsWith("//busiluck ")) {
                    str3 = "weixin://openNativeUrl/weixinHB/startreceivebizhbrequest?sendid=".concat(String.valueOf(str.replace("//busiluck ", "")));
                    intent2 = new Intent();
                    intent2.putExtra("key_way", 5);
                    intent2.putExtra("key_native_url", str3);
                    com.tencent.mm.bp.d.b(context, "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", intent2);
                    AppMethodBeat.o(16100);
                    return true;
                } else if (str.startsWith("//testsoter")) {
                    intent = new Intent();
                    intent.setClassName(ah.getPackageName(), "com.tencent.mm.plugin.soter.ui.SoterTestUI");
                    context.startActivity(intent);
                    AppMethodBeat.o(16100);
                    return true;
                } else if (str.startsWith("//facevideo")) {
                    split = str.split(" ");
                    if (split.length == 3) {
                        av.fly.ak("imgType", split[1]);
                        av.fly.ak("depth", split[2]);
                    }
                    AppMethodBeat.o(16100);
                    return true;
                } else if (str.startsWith("//alpha")) {
                    split = str.split(" ");
                    if (split.length == 2) {
                        av.fly.ak("alpha_duration", split[1]);
                    }
                    AppMethodBeat.o(16100);
                    return true;
                } else if (str.startsWith("//forceNotifyError")) {
                    split3 = str.split(" ");
                    if (split3.length == 2) {
                        ((com.tencent.mm.plugin.forcenotify.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.forcenotify.a.b.class)).hx(split3[1].equalsIgnoreCase("true"));
                    }
                    AppMethodBeat.o(16100);
                    return true;
                } else if (str.startsWith("//rectwidth")) {
                    split = str.split(" ");
                    if (split.length == 2) {
                        av.fly.ak("rect_width", split[1]);
                    }
                    AppMethodBeat.o(16100);
                    return true;
                } else if (str.startsWith("//newyearsw ")) {
                    aw.ZK();
                    intValue = ((Integer) com.tencent.mm.model.c.Ry().get(ac.a.USERINFO_LUCKY_MONEY_NEWYEAR_LOCAL_SWITCH_INT, Integer.valueOf(0))).intValue() ^ 1;
                    aw.ZK();
                    com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_LUCKY_MONEY_NEWYEAR_LOCAL_SWITCH_INT, Integer.valueOf(intValue));
                    AppMethodBeat.o(16100);
                    return true;
                } else if (str.startsWith("//commitxlog")) {
                    aw.Rg().a(1, "", 0, false);
                    ab.dot();
                    AppMethodBeat.o(16100);
                    return true;
                } else if (str.startsWith("//open neattextview")) {
                    com.tencent.mm.kernel.g.RP().Ry().set(ac.a.USERINFO_CELLTEXTVIEW_CONFIG_BOOLEAN_SYNC, Boolean.TRUE);
                    AppMethodBeat.o(16100);
                    return true;
                } else if (str.startsWith("//close neattextview")) {
                    com.tencent.mm.kernel.g.RP().Ry().set(ac.a.USERINFO_CELLTEXTVIEW_CONFIG_BOOLEAN_SYNC, Boolean.FALSE);
                    AppMethodBeat.o(16100);
                    return true;
                } else if (str.startsWith("//unprint specialtext")) {
                    MMNeat7extView.zMr = false;
                    AppMethodBeat.o(16100);
                    return true;
                } else if (str.startsWith("//print specialtext")) {
                    MMNeat7extView.zMr = true;
                    AppMethodBeat.o(16100);
                    return true;
                } else if (str.startsWith("//netstatus")) {
                    gA = at.gA(ah.getContext());
                    com.tencent.mm.ui.base.h.d(context, gA, "netstatus", context.getString(R.string.f5p), context.getString(R.string.atb), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(16088);
                            ((ClipboardManager) context.getSystemService("clipboard")).setText(gA);
                            AppMethodBeat.o(16088);
                        }
                    }, null);
                    AppMethodBeat.o(16100);
                    return true;
                } else {
                    long j;
                    if (str.startsWith("//scaninterval ")) {
                        j = -1;
                        try {
                            j = bo.getLong(str.split(" ")[1], -1);
                        } catch (Exception e) {
                        }
                        if (j > 0) {
                            aw.ZK();
                            com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_WECHAT_FILE_SCAN_INTERVAL_LONG, Long.valueOf(j));
                            ab.i("MicroMsg.CommandProcessor", "summerclean reset scaninterval[%d]", Long.valueOf(j));
                            AppMethodBeat.o(16100);
                            return true;
                        }
                    }
                    if (str.startsWith("//scanwait ")) {
                        j = -1;
                        try {
                            j = bo.getLong(str.split(" ")[1], -1);
                        } catch (Exception e2) {
                        }
                        if (j > 0) {
                            aw.ZK();
                            com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_WECHAT_FILE_SCAN_WAIT_TIME_LONG, Long.valueOf(j));
                            ab.i("MicroMsg.CommandProcessor", "summerclean reset scanwait[%d]", Long.valueOf(j));
                            AppMethodBeat.o(16100);
                            return true;
                        }
                    }
                    SharedPreferences doB;
                    boolean z;
                    boolean booleanValue;
                    View textView2;
                    ad aoO;
                    if (str.equalsIgnoreCase("//delayquery")) {
                        ae.gju = !ae.gju;
                        AppMethodBeat.o(16100);
                        return true;
                    } else if (str.startsWith("//newinit -hard")) {
                        com.tencent.mm.kernel.g.RQ();
                        com.tencent.mm.kernel.g.RP().Ry().set(15, Integer.valueOf(0));
                        AppMethodBeat.o(16100);
                        return true;
                    } else if (str.startsWith("//websearch-widget-draw ")) {
                        split3 = str.split("\\s+");
                        if (split3.length == 2) {
                            ((com.tencent.mm.plugin.websearch.api.n) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.websearch.api.n.class)).HM(bo.ank(split3[1].trim()));
                        }
                        AppMethodBeat.o(16100);
                        return true;
                    } else if (str.startsWith("//opensearchpreload ")) {
                        split = str.split("\\s+");
                        if (split.length == 2) {
                            if ("1".equals(split[1].trim())) {
                                aj.cVp().nE(true);
                            } else if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(split[1].trim())) {
                                aj.cVp().nE(false);
                            }
                        }
                        AppMethodBeat.o(16100);
                        return true;
                    } else if (str.startsWith("//closesearchhtmlpreload ")) {
                        split = str.split("\\s+");
                        if (split.length == 2) {
                            if ("1".equals(split[1].trim())) {
                                aa.cVb();
                            } else if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(split[1].trim())) {
                                aa.cVb();
                            }
                        }
                        AppMethodBeat.o(16100);
                        return true;
                    } else if (str.equalsIgnoreCase("//swipe")) {
                        doB = ah.doB();
                        doB.edit().putBoolean("settings_support_swipe", !doB.getBoolean("settings_support_swipe", true)).commit();
                        AppMethodBeat.o(16100);
                        return true;
                    } else if (str.equalsIgnoreCase("//multiwebview")) {
                        doB = LauncherUI.getInstance().getSharedPreferences(ah.doA(), 0);
                        z = doB.getBoolean("settings_multi_webview", false);
                        if (z) {
                            doB.edit().putBoolean("settings_multi_webview", !z).commit();
                        }
                        AppMethodBeat.o(16100);
                        return true;
                    } else if (str.equalsIgnoreCase("//sightinfo")) {
                        aw.ZK();
                        booleanValue = ((Boolean) com.tencent.mm.model.c.Ry().get(344065, Boolean.FALSE)).booleanValue();
                        aw.ZK();
                        com.tencent.mm.model.c.Ry().set(344065, Boolean.valueOf(!booleanValue));
                        aw.ZK();
                        com.tencent.mm.model.c.Ry().dsb();
                        AppMethodBeat.o(16100);
                        return true;
                    } else if (str.startsWith("//sighttest")) {
                        intValue = bo.ank(str.replace("//sighttest ", ""));
                        aw.ZK();
                        com.tencent.mm.model.c.Ry().set(344066, Integer.valueOf(intValue));
                        aw.ZK();
                        com.tencent.mm.model.c.Ry().dsb();
                        AppMethodBeat.o(16100);
                        return true;
                    } else if (str.startsWith("//wxcamera")) {
                        ab.i("MicroMsg.CommandProcessor", "set param %d", Integer.valueOf(bo.ank(str.replace("//wxcamera ", ""))));
                        aw.ZK();
                        com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_LOCAL_SIGHT_SETTING_PRESET_INT_SYNC, Integer.valueOf(intValue));
                        AppMethodBeat.o(16100);
                        return true;
                    } else if (str.startsWith("//printcrash")) {
                        str3 = str.replace("//printcrash ", "");
                        textView2 = new TextView(context);
                        textView2.setText(jb(bo.getInt(str3, 0)));
                        textView2.setGravity(19);
                        textView2.setTextSize(1, 8.0f);
                        textView2.setLayoutParams(new LayoutParams(-1, -2));
                        textView2.setTextColor(-16711936);
                        textView2.setTypeface(Typeface.MONOSPACE);
                        intValue = context.getResources().getDimensionPixelSize(R.dimen.nj);
                        textView2.setPadding(intValue, intValue, intValue, intValue);
                        textView2.setMovementMethod(ScrollingMovementMethod.getInstance());
                        com.tencent.mm.ui.base.h.a(context, null, textView2, null);
                        AppMethodBeat.o(16100);
                        return true;
                    } else if (str.startsWith("//printleak")) {
                        textView = new TextView(context);
                        textView.setText(com.tencent.mm.compatible.b.g.Le());
                        textView.setGravity(19);
                        textView.setTextSize(1, 8.0f);
                        textView.setLayoutParams(new LayoutParams(-1, -2));
                        textView.setTextColor(-16711936);
                        textView.setTypeface(Typeface.MONOSPACE);
                        dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.nj);
                        textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
                        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
                        com.tencent.mm.ui.base.h.a(context, null, textView, null);
                        AppMethodBeat.o(16100);
                        return true;
                    } else if (str.startsWith("//resetmapcnt")) {
                        aw.ZK();
                        com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_TENCENT_MAP_COUNT_INT, Integer.valueOf(0));
                        AppMethodBeat.o(16100);
                        return true;
                    } else if (str.equals("//testrsa")) {
                        z.O("010001", "E338E5DAD46B331E3071FAFD4C0F84C7C7965DBBE64C6F8CC0F7CF04DC640C1F84A2014431A48D65F2B2F172BA9BE6F5A049BF52C78C14B0965E20F0D80D85A9180EBABB913D49821D28BFD9601DF52A4F3230AECAD96D23415F5E94D51A87CAA7630C5F3CB70345BAF572A4F61A134A2265AFD8FADDFE0222BD9ABF7DBEB7444D031454E8F21820BBC725E6857F765660E987FADEBCF6B3A15355C4CD3752A7B544D1D7E037AF4F9725BE37681A84C9E1DC431B3065294EAD53E913BAF16D46714B013EA077191E6CA08ABA6D70E9CA792D898D692E3168D6341369976657CD5E1504B9E2458F107225176734D11621AD36D7FFA26C573D6612455B09105C41", 106);
                        AppMethodBeat.o(16100);
                        return true;
                    } else if (str.equals("//testrsabad")) {
                        z.O("010001", "F338E5DAD46B331E3071FAFD4C0F84C7C7965DBBE64C6F8CC0F7CF04DC640C1F84A2014431A48D65F2B2F172BA9BE6F5A049BF52C78C14B0965E20F0D80D85A9180EBABB913D49821D28BFD9601DF52A4F3230AECAD96D23415F5E94D51A87CAA7630C5F3CB70345BAF572A4F61A134A2265AFD8FADDFE0222BD9ABF7DBEB7444D031454E8F21820BBC725E6857F765660E987FADEBCF6B3A15355C4CD3752A7B544D1D7E037AF4F9725BE37681A84C9E1DC431B3065294EAD53E913BAF16D46714B013EA077191E6CA08ABA6D70E9CA792D898D692E3168D6341369976657CD5E1504B9E2458F107225176734D11621AD36D7FFA26C573D6612455B09105C41", 106);
                        AppMethodBeat.o(16100);
                        return true;
                    } else if (str.equals("//walletofflinetest")) {
                        aw.ZK();
                        com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_ADDRESS_HAS_SHOW_WALLETOFFLINE_DIALOG_BOOLEAN_SYNC, Boolean.FALSE);
                        AppMethodBeat.o(16100);
                        return false;
                    } else if (str.startsWith("//makemsgdata ")) {
                        intValue = bo.getInt(str.split(" ")[1], 0);
                        aw.ZK();
                        com.tencent.mm.model.c.XO().P(ChattingUIFragment.xIj, (long) intValue);
                        AppMethodBeat.o(16100);
                        return true;
                    } else if (str.startsWith("//pullappservice")) {
                        an.dhQ().fM(ah.getContext());
                        AppMethodBeat.o(16100);
                        return true;
                    } else if (str.startsWith("//boundaryconfig")) {
                        ab.i("MicroMsg.CommandProcessor", "boundaryconfig SessionTextMsg:%d", Integer.valueOf(bo.getInt(com.tencent.mm.m.g.Nu().getValue("InputLimitSessionTextMsg"), 0)));
                        ab.i("MicroMsg.CommandProcessor", "boundaryconfig SNSObjectText:%d", Integer.valueOf(bo.getInt(com.tencent.mm.m.g.Nu().getValue("InputLimitSNSObjectText"), 0)));
                        ab.i("MicroMsg.CommandProcessor", "boundaryconfig SnsCommentMaxSize:%d", Integer.valueOf(bo.getInt(com.tencent.mm.m.g.Nu().getValue("SnsCommentMaxSize"), 0)));
                        ab.i("MicroMsg.CommandProcessor", "boundaryconfig FavText:%d", Integer.valueOf(bo.getInt(com.tencent.mm.m.g.Nu().getValue("InputLimitFavText"), 0)));
                        ab.i("MicroMsg.CommandProcessor", "boundaryconfig EmotionBufSize:%d", Integer.valueOf(bo.getInt(com.tencent.mm.m.g.Nu().getValue("InputLimitSendEmotionBufSize"), 0)));
                        ab.i("MicroMsg.CommandProcessor", "boundaryconfig EmotionWidth:%d", Integer.valueOf(bo.getInt(com.tencent.mm.m.g.Nu().getValue("InputLimitSendEmotionWidth"), 0)));
                        ab.i("MicroMsg.CommandProcessor", "boundaryconfig FavImageSize:%d", Integer.valueOf(bo.getInt(com.tencent.mm.m.g.Nu().getValue("InputLimitFavImageSize"), 0)));
                        ab.i("MicroMsg.CommandProcessor", "boundaryconfig FavVoiceLength:%d", Integer.valueOf(bo.getInt(com.tencent.mm.m.g.Nu().getValue("InputLimitFavVoiceLength"), 0)));
                        ab.i("MicroMsg.CommandProcessor", "boundaryconfig ShortVideoAutoDownloadBufSize:%d", Integer.valueOf(bo.getInt(com.tencent.mm.m.g.Nu().getValue("InputLimitSessionShortVideoBufSize"), 0)));
                        ab.i("MicroMsg.CommandProcessor", "boundaryconfig VideoSize:%d", Integer.valueOf(bo.getInt(com.tencent.mm.m.g.Nu().getValue("InputLimitVideoSize"), 0)));
                        ab.i("MicroMsg.CommandProcessor", "boundaryconfig FileSize:%d", Integer.valueOf(bo.getInt(com.tencent.mm.m.g.Nu().getValue("InputLimitFileSize"), 0)));
                        AppMethodBeat.o(16100);
                        return true;
                    } else if (str.startsWith("//cleanapk")) {
                        com.tencent.mm.plugin.clean.c.j.bge();
                        AppMethodBeat.o(16100);
                        return true;
                    } else if (str.startsWith("//whatsnew")) {
                        MMAppMgr.aq((Activity) context);
                        AppMethodBeat.o(16100);
                        return true;
                    } else if (str.startsWith("//profile ")) {
                        aw.ZK();
                        aoO = com.tencent.mm.model.c.XM().aoO(str.replace("//profile ", "").trim());
                        if (!(aoO == null || aoO.Oh() == 0)) {
                            intent2 = new Intent();
                            intent2.putExtra("Contact_User", aoO.getUsername());
                            com.tencent.mm.bp.d.b(context, Scopes.PROFILE, ".ui.ContactInfoUI", intent2);
                        }
                        AppMethodBeat.o(16100);
                        return true;
                    } else if (str.startsWith("//minigameupdate")) {
                        aw.ZK();
                        com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_MINIGAME_SEARCH_LIST_UPDATE_TIME_LONG, Long.valueOf(0));
                        AppMethodBeat.o(16100);
                        return true;
                    } else {
                        if (com.tencent.mm.sdk.a.b.dnO()) {
                            if (str.startsWith("//cs")) {
                                intent = new Intent();
                                intent.putExtra("voipCSBizId", "gh_b35727b00b78");
                                intent.putExtra("voipCSAppId", "wx6e7147e8d764e85d");
                                com.tencent.mm.bp.d.b(ah.getContext(), "voip_cs", ".ui.VoipCSMainUI", intent);
                                AppMethodBeat.o(16100);
                                return true;
                            } else if (str.startsWith("//acs")) {
                                intent = new Intent();
                                intent.putExtra("voipCSBizId", "gh_e8b085bb67e0");
                                intent.putExtra("voipCSAppId", "wx1224160e0adcefd6");
                                com.tencent.mm.bp.d.b(ah.getContext(), "voip_cs", ".ui.VoipCSMainUI", intent);
                                AppMethodBeat.o(16100);
                                return true;
                            } else if (str.startsWith("//wifiset")) {
                                intent = new Intent();
                                intent.putExtra("free_wifi_ssid", "Xiaomi_WENDY");
                                intent.putExtra("free_wifi_passowrd", "WX12345789");
                                com.tencent.mm.bp.d.b(ah.getContext(), "freewifi", ".ui.FreeWifiCopyPwdUI", intent);
                                AppMethodBeat.o(16100);
                                return true;
                            } else if (str.startsWith("//bcs")) {
                                intent = new Intent();
                                intent.putExtra("voipCSBizId", "gh_e8b085bb67e0");
                                intent.putExtra("voipCSAppId", "wx1224160e0adcefd6");
                                intent.putExtra("voipCSAllowBackCamera", "1");
                                intent.putExtra("voipCSShowOther", "1");
                                intent.putExtra("voipCSAvatarUrl", "https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=28737416,3249768666&fm=58");
                                intent.putExtra("voipCSContext", "test");
                                com.tencent.mm.bp.d.b(ah.getContext(), "voip_cs", ".ui.VoipCSMainUI", intent);
                                AppMethodBeat.o(16100);
                                return true;
                            }
                        }
                        String str4;
                        String str5;
                        boolean z2;
                        int tbsSDKVersion;
                        Editor edit2;
                        if (str.startsWith("//getfpkey")) {
                            gA = bs.dut();
                            com.tencent.mm.ui.base.h.d(context, gA, "Fingerprint Key", context.getString(R.string.f5p), context.getString(R.string.atb), new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(16089);
                                    ((ClipboardManager) context.getSystemService("clipboard")).setText(gA);
                                    Toast.makeText(context, R.string.f5q, 0).show();
                                    AppMethodBeat.o(16089);
                                }
                            }, null);
                            AppMethodBeat.o(16100);
                            return true;
                        } else if (str.startsWith("//commitwd")) {
                            WatchDogPushReceiver.akt();
                            AppMethodBeat.o(16100);
                            return true;
                        } else if (str.startsWith("//setsnstestenv")) {
                            String str6;
                            split3 = str.split(" +");
                            str4 = null;
                            if (split3.length > 1) {
                                str6 = split3[1];
                                if (com.tencent.mm.sdk.platformtools.t.isIPv4Address(str6) || com.tencent.mm.sdk.platformtools.t.isIPv6Address(str6)) {
                                    if (split3.length > 2) {
                                        str5 = split3[2];
                                        if (com.tencent.mm.sdk.platformtools.t.isIPv4Address(str5) || com.tencent.mm.sdk.platformtools.t.isIPv6Address(str5)) {
                                            if (split3.length > 3) {
                                                gA = split3[3];
                                                str4 = str5;
                                            } else {
                                                gA = null;
                                                str4 = str5;
                                            }
                                            ae.giS = str6 != null;
                                            ae.giJ = str6;
                                            ae.gjl = str4;
                                            ae.gjm = gA;
                                            com.tencent.mm.al.f.afu().li(5);
                                            Toast.makeText(context, String.format("%s %s %s", new Object[]{ae.giJ, ae.gjl, ae.gjm}), 1).show();
                                            AppMethodBeat.o(16100);
                                            return true;
                                        }
                                    }
                                    gA = null;
                                    if (str6 != null) {
                                    }
                                    ae.giS = str6 != null;
                                    ae.giJ = str6;
                                    ae.gjl = str4;
                                    ae.gjm = gA;
                                    com.tencent.mm.al.f.afu().li(5);
                                    Toast.makeText(context, String.format("%s %s %s", new Object[]{ae.giJ, ae.gjl, ae.gjm}), 1).show();
                                    AppMethodBeat.o(16100);
                                    return true;
                                }
                            }
                            gA = null;
                            str6 = null;
                            if (str6 != null) {
                            }
                            ae.giS = str6 != null;
                            ae.giJ = str6;
                            ae.gjl = str4;
                            ae.gjm = gA;
                            com.tencent.mm.al.f.afu().li(5);
                            Toast.makeText(context, String.format("%s %s %s", new Object[]{ae.giJ, ae.gjl, ae.gjm}), 1).show();
                            AppMethodBeat.o(16100);
                            return true;
                        } else if (str.startsWith("//snsvcodec")) {
                            split = str.split(" +");
                            if (split.length > 1) {
                                str3 = split[1];
                                if ("on".equalsIgnoreCase(str3)) {
                                    jc(1);
                                    ab.i("MicroMsg.CommandProcessor", "snsvcodec val: 1");
                                } else if ("off".equalsIgnoreCase(str3)) {
                                    jc(0);
                                    ab.i("MicroMsg.CommandProcessor", "snsvcodec val: 0");
                                }
                            } else {
                                jc(-1);
                                ab.i("MicroMsg.CommandProcessor", "snsvcodec val: -1");
                            }
                            AppMethodBeat.o(16100);
                            return true;
                        } else if (str.startsWith("//snswxpc")) {
                            split = str.split(" +");
                            if (split.length > 1) {
                                str3 = split[1];
                                if ("on".equalsIgnoreCase(str3)) {
                                    jd(1);
                                    ab.i("MicroMsg.CommandProcessor", "snswxpc val: 1");
                                } else if ("off".equalsIgnoreCase(str3)) {
                                    jd(0);
                                    ab.i("MicroMsg.CommandProcessor", "snswxpc val: 0");
                                }
                            } else {
                                jd(-1);
                                ab.i("MicroMsg.CommandProcessor", "snswxpc val: -1");
                            }
                            AppMethodBeat.o(16100);
                            return true;
                        } else if (str.startsWith("//mmdumpsys")) {
                            com.tencent.mm.sdk.g.d.xDG.execute(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(16091);
                                    new ap(new ap.a() {
                                        /* JADX WARNING: Removed duplicated region for block: B:25:0x00b7  */
                                        /* JADX WARNING: Removed duplicated region for block: B:41:0x0156 A:{SYNTHETIC, Splitter:B:41:0x0156} */
                                        /* JADX WARNING: Removed duplicated region for block: B:20:0x008d A:{SYNTHETIC, Splitter:B:20:0x008d} */
                                        /* JADX WARNING: Removed duplicated region for block: B:25:0x00b7  */
                                        /* Code decompiled incorrectly, please refer to instructions dump. */
                                        public final boolean BI() {
                                            Exception e;
                                            Throwable th;
                                            AppMethodBeat.i(16090);
                                            if (com.tencent.mm.compatible.util.d.iW(23)) {
                                                ab.i("MicroMsg.CommandProcessor", "gcCount: %s", Debug.getRuntimeStats());
                                            } else {
                                                int globalGcInvocationCount = Debug.getGlobalGcInvocationCount();
                                                int threadGcInvocationCount = Debug.getThreadGcInvocationCount();
                                                ab.i("MicroMsg.CommandProcessor", "gcCount: %d %d", Integer.valueOf(globalGcInvocationCount), Integer.valueOf(threadGcInvocationCount));
                                            }
                                            long pss = Debug.getPss();
                                            Debug.getMemoryInfo(new MemoryInfo());
                                            if (com.tencent.mm.compatible.util.d.iW(23)) {
                                                ab.i("MicroMsg.CommandProcessor", "pss: %d, memoryInfo:%s", Long.valueOf(pss), r2.getMemoryStats());
                                            } else {
                                                ab.i("MicroMsg.CommandProcessor", "pss: %d, memoryInfo:%d", Long.valueOf(pss), Integer.valueOf(r2.nativePss));
                                            }
                                            LineNumberReader lineNumberReader;
                                            try {
                                                Process exec = Runtime.getRuntime().exec("top -m 5 -n 1");
                                                lineNumberReader = new LineNumberReader(new InputStreamReader(exec.getInputStream()));
                                                while (true) {
                                                    try {
                                                        String readLine = lineNumberReader.readLine();
                                                        if (readLine == null) {
                                                            break;
                                                        } else if (readLine.length() > 0) {
                                                            ab.i("MicroMsg.CommandProcessor", readLine);
                                                        }
                                                    } catch (Exception e2) {
                                                        e = e2;
                                                        try {
                                                            ab.e("MicroMsg.CommandProcessor", "getRunningAppProcessesByPs fail, ex = %s", e.getMessage());
                                                            if (lineNumberReader != null) {
                                                            }
                                                            ab.i("MicroMsg.CommandProcessor", "thread count:%d", Integer.valueOf(Thread.activeCount()));
                                                            for (Thread thread : Thread.getAllStackTraces().keySet()) {
                                                            }
                                                            AppMethodBeat.o(16090);
                                                            return true;
                                                        } catch (Throwable th2) {
                                                            th = th2;
                                                            if (lineNumberReader != null) {
                                                                try {
                                                                    lineNumberReader.close();
                                                                } catch (Exception e3) {
                                                                    ab.e("MicroMsg.CommandProcessor", "getRunningProcessesByPs finally got ex = %s", e3.getMessage());
                                                                }
                                                            }
                                                            AppMethodBeat.o(16090);
                                                            throw th;
                                                        }
                                                    }
                                                }
                                                exec.waitFor();
                                                exec.destroy();
                                                try {
                                                    lineNumberReader.close();
                                                } catch (Exception e4) {
                                                    ab.e("MicroMsg.CommandProcessor", "getRunningProcessesByPs finally got ex = %s", e4.getMessage());
                                                }
                                            } catch (Exception e5) {
                                                e4 = e5;
                                                lineNumberReader = null;
                                                ab.e("MicroMsg.CommandProcessor", "getRunningAppProcessesByPs fail, ex = %s", e4.getMessage());
                                                if (lineNumberReader != null) {
                                                    try {
                                                        lineNumberReader.close();
                                                    } catch (Exception e42) {
                                                        ab.e("MicroMsg.CommandProcessor", "getRunningProcessesByPs finally got ex = %s", e42.getMessage());
                                                    }
                                                }
                                                ab.i("MicroMsg.CommandProcessor", "thread count:%d", Integer.valueOf(Thread.activeCount()));
                                                for (Thread thread2 : Thread.getAllStackTraces().keySet()) {
                                                }
                                                AppMethodBeat.o(16090);
                                                return true;
                                            } catch (Throwable th3) {
                                                th = th3;
                                                lineNumberReader = null;
                                                if (lineNumberReader != null) {
                                                }
                                                AppMethodBeat.o(16090);
                                                throw th;
                                            }
                                            ab.i("MicroMsg.CommandProcessor", "thread count:%d", Integer.valueOf(Thread.activeCount()));
                                            for (Thread thread22 : Thread.getAllStackTraces().keySet()) {
                                                if (thread22.getState() == State.RUNNABLE) {
                                                    ab.i("MicroMsg.CommandProcessor", "Running thread: %s\n %s", thread22.getName(), com.tencent.mm.sdk.platformtools.an.stackTraceToString((StackTraceElement[]) r1.get(thread22)));
                                                }
                                            }
                                            AppMethodBeat.o(16090);
                                            return true;
                                        }
                                    }, true).ae(10000, 10000);
                                    AppMethodBeat.o(16091);
                                }
                            });
                            AppMethodBeat.o(16100);
                            return true;
                        } else if (str.startsWith("//remittance reset")) {
                            aw.ZK();
                            com.tencent.mm.model.c.Ry().set(327729, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                            AppMethodBeat.o(16100);
                            return true;
                        } else if (str.startsWith("//wv ")) {
                            str3 = str.replace("//wv ", "");
                            intent2 = new Intent();
                            intent2.putExtra("rawUrl", str3);
                            com.tencent.mm.bp.d.b(context, "webview", ".ui.tools.WebViewUI", intent2);
                            AppMethodBeat.o(16100);
                            return true;
                        } else if (str.startsWith("//wvjsapi ")) {
                            str3 = str.replace("//wvjsapi ", "");
                            intent2 = new Intent();
                            intent2.putExtra("rawUrl", str3);
                            com.tencent.mm.bp.d.b(context, "webview", ".ui.tools.WebViewTestUI", intent2);
                            AppMethodBeat.o(16100);
                            return true;
                        } else if (str.startsWith("//setibeacontabuinopen")) {
                            if (aw.RK()) {
                                aw.ZK();
                                com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_IBEACON_SHAKE_TAB_IS_UIN_RESIDENT_INT, Integer.valueOf(1));
                                AppMethodBeat.o(16100);
                                return true;
                            }
                            AppMethodBeat.o(16100);
                            return false;
                        } else if (str.startsWith("//setibeacontabuinclose")) {
                            if (aw.RK()) {
                                aw.ZK();
                                com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_IBEACON_SHAKE_TAB_IS_UIN_RESIDENT_INT, Integer.valueOf(0));
                                AppMethodBeat.o(16100);
                                return true;
                            }
                            AppMethodBeat.o(16100);
                            return false;
                        } else if (str.startsWith("//setibeaconpushopen")) {
                            if (aw.RK()) {
                                aw.ZK();
                                com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN, Boolean.TRUE);
                                AppMethodBeat.o(16100);
                                return true;
                            }
                            AppMethodBeat.o(16100);
                            return false;
                        } else if (str.startsWith("//setibeaconpushclose")) {
                            if (aw.RK()) {
                                aw.ZK();
                                com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN, Boolean.FALSE);
                                AppMethodBeat.o(16100);
                                return true;
                            }
                            AppMethodBeat.o(16100);
                            return false;
                        } else if (str.startsWith("//ibeacon")) {
                            booleanValue = false;
                            z = false;
                            if (VERSION.SDK_INT >= 18) {
                                booleanValue = true;
                            }
                            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                            if (defaultAdapter != null && defaultAdapter.getState() == 12) {
                                z = true;
                            }
                            boolean hasSystemFeature = context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
                            z2 = booleanValue && z && hasSystemFeature;
                            gA = "isNowSupportedIbeacon:" + z2 + "\n\nisSystemSupported:" + booleanValue + "\nisBlueStateOn:" + z + "\nisSupportedBLE:" + hasSystemFeature + "\nSDK:" + VERSION.SDK_INT + "\nModel:" + Build.BRAND + "-" + q.LS() + "\noperatingSystemInfo:" + q.LW();
                            com.tencent.mm.ui.base.h.d(context, gA, "TestResult", context.getString(R.string.akc), context.getString(R.string.atb), new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(16092);
                                    ((ClipboardManager) context.getSystemService("clipboard")).setText(gA);
                                    AppMethodBeat.o(16092);
                                }
                            }, null);
                            AppMethodBeat.o(16100);
                            return true;
                        } else if (str.startsWith("//gettbs")) {
                            booleanValue = q.etf.euj;
                            sharedPreferences = context.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
                            str4 = sharedPreferences.getString("tbs_download", null);
                            str5 = sharedPreferences.getString("tbs_webview_disable", null);
                            boolean z3 = sharedPreferences.getBoolean("x5_jscore_enabled", false);
                            int installedTbsCoreVersion = WebView.getInstalledTbsCoreVersion(context);
                            tbsSDKVersion = WebView.getTbsSDKVersion(context);
                            String string = sharedPreferences.getString("tbs_webview_min_sdk_version", null);
                            gA = sharedPreferences.getString("tbs_webview_max_sdk_version", null);
                            Toast.makeText(context, String.format("forceSys:%b\ntbs_download:%s\ntbs_disable:%s\ntbs_disable_min_sdk_version:%s\ntbs_disable_max_sdk_version:%s\ntbsCoreVersion:%d\ntbsSdkVersion:%d\nx5JsCoreEnabled:%b", new Object[]{Boolean.valueOf(booleanValue), str4, str5, string, gA, Integer.valueOf(installedTbsCoreVersion), Integer.valueOf(tbsSDKVersion), Boolean.valueOf(z3)}), 1).show();
                            AppMethodBeat.o(16100);
                            return true;
                        } else if (str.startsWith("//deletetbs")) {
                            intent = new Intent();
                            intent.setComponent(new ComponentName(ah.getPackageName(), "com.tencent.mm.booter.MMReceivers$SandBoxProcessReceiver"));
                            context.sendBroadcast(intent);
                            edit2 = context.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
                            edit2.putLong("last_check_ts", 0);
                            edit2.apply();
                            aw.ZK();
                            com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_OVER_SEA_DOWNLOAD_X5_HAS_NOTIFY_BOOLEAN_SYNC, Boolean.FALSE);
                            AppMethodBeat.o(16100);
                            return true;
                        } else if (str.startsWith("//tbsDisableOverScroll")) {
                            edit = context.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
                            try {
                                str3 = str.substring(str.indexOf(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D) + 1);
                            } catch (IndexOutOfBoundsException e3) {
                                str3 = "";
                            }
                            edit.putBoolean("tbs_disable_over_scroll", Boolean.parseBoolean(str3));
                            edit.apply();
                            AppMethodBeat.o(16100);
                            return true;
                        } else if (str.startsWith("//enabletbs")) {
                            edit = context.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
                            str4 = str.replace("//enabletbs ", "");
                            edit.putString("tbs_webview_disable", "1".equals(str4) ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "1");
                            if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str4)) {
                                edit.putString("tbs_webview_min_sdk_version", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                                edit.putString("tbs_webview_max_sdk_version", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                            }
                            edit.apply();
                            AppMethodBeat.o(16100);
                            return true;
                        } else if (str.startsWith("//wvsha1")) {
                            edit = context.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
                            try {
                                str3 = str.substring(str.indexOf(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D) + 1);
                            } catch (IndexOutOfBoundsException e4) {
                                str3 = "";
                            }
                            edit.putBoolean("wvsha1", Boolean.parseBoolean(str3));
                            edit.apply();
                            AppMethodBeat.o(16100);
                            return true;
                        } else {
                            if (str.startsWith("//channelId")) {
                                com.tencent.mm.ui.base.h.J(context, com.tencent.mm.sdk.platformtools.g.cdf, DownloadInfoColumns.CHANNELID);
                            }
                            if (str.startsWith("//traceroute")) {
                                com.tencent.mm.bp.d.H(context, "traceroute", ".ui.NetworkDiagnoseIntroUI");
                                AppMethodBeat.o(16100);
                                return true;
                            } else if (str.startsWith("//testoom")) {
                                for (intValue = 0; intValue < 20; intValue++) {
                                    Bitmap.createBitmap(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 1920, Config.ARGB_8888);
                                }
                                if (com.tencent.mm.compatible.util.d.iW(23)) {
                                    Debug.getMemoryInfo(new MemoryInfo());
                                    ab.i("MicroMsg.CommandProcessor", "testoom %s", Long.valueOf(Runtime.getRuntime().totalMemory()), Long.valueOf(Runtime.getRuntime().freeMemory()));
                                }
                                AppMethodBeat.o(16100);
                                return true;
                            } else {
                                if (str.startsWith("//qzone ")) {
                                    new u(context).ajG(str.replace("//qzone ", ""));
                                }
                                int i;
                                StringBuilder stringBuilder2;
                                if (str.startsWith("//dumpcrash")) {
                                    com.tencent.mm.vfs.e.is(com.tencent.mm.compatible.util.e.eSj + "crash/", com.tencent.mm.compatible.util.e.eSo);
                                    AppMethodBeat.o(16100);
                                    return true;
                                } else if (str.startsWith("//dumpanr")) {
                                    com.tencent.mm.vfs.e.is("/data/anr/", com.tencent.mm.compatible.util.e.eSo);
                                    AppMethodBeat.o(16100);
                                    return true;
                                } else if (str.startsWith("//testanr")) {
                                    try {
                                        Thread.sleep(10000);
                                    } catch (InterruptedException e5) {
                                        ab.printErrStackTrace("MicroMsg.CommandProcessor", e5, "", new Object[0]);
                                    }
                                    AppMethodBeat.o(16100);
                                    return true;
                                } else if (str.startsWith("//opensnsadRightbar")) {
                                    ae.giI = true;
                                    AppMethodBeat.o(16100);
                                    return true;
                                } else if (str.startsWith("//setlocation ")) {
                                    split = str.split(" ");
                                    if (split == null || !com.tencent.mm.sdk.a.b.dnO()) {
                                        AppMethodBeat.o(16100);
                                        return false;
                                    }
                                    ae.ghY = true;
                                    if (split.length > 0) {
                                        ae.lat = bo.getDouble(split[1], 0.0d);
                                    }
                                    if (split.length > 1) {
                                        ae.lng = bo.getDouble(split[2], 0.0d);
                                    }
                                    AppMethodBeat.o(16100);
                                    return true;
                                } else if (str.startsWith("//switchsdcard")) {
                                    Object obj;
                                    ArrayList dpo = bd.dpo();
                                    int size = dpo.size();
                                    ab.i("MicroMsg.CommandProcessor", "switchsdcard sdcard size = ".concat(String.valueOf(size)));
                                    if (!(size <= 0 || dpo.get(0) == null || bo.isNullOrNil(((bd.a) dpo.get(0)).xBt))) {
                                        for (intValue = 0; intValue < size; intValue++) {
                                            ab.i("MicroMsg.CommandProcessor", "switchsdcard list i = " + intValue + " StatMountParse: " + dpo.get(intValue));
                                        }
                                    }
                                    for (i = 0; i < size; i++) {
                                        if (!((bd.a) dpo.get(i)).xBt.equals(com.tencent.mm.compatible.util.e.eSl)) {
                                            obj = ((bd.a) dpo.get(i)).xBt;
                                            break;
                                        }
                                    }
                                    obj = null;
                                    final Activity activity = (Activity) context;
                                    ab.i("MicroMsg.CommandProcessor", "switchsdcard newSdcard: ".concat(String.valueOf(obj)));
                                    if (bo.isNullOrNil(obj)) {
                                        com.tencent.mm.ui.base.h.bO(context, context.getString(R.string.eu3));
                                        AppMethodBeat.o(16100);
                                        return true;
                                    }
                                    com.tencent.mm.ui.base.h.d(context, context.getString(R.string.eu4), "", context.getString(R.string.s6), context.getString(R.string.or), new OnClickListener() {
                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            AppMethodBeat.i(16093);
                                            y yVar = new y(ac.eSj + "SdcardInfo.cfg");
                                            yVar.set(1, obj);
                                            ab.i("MicroMsg.CommandProcessor", "switchsdcard reset to sdcard root: " + yVar.get(1));
                                            com.tencent.mm.sdk.platformtools.aj.amB("welcome_page_show");
                                            com.tencent.mm.kernel.l.m(context, true);
                                            com.tencent.mm.g.a.z zVar = new com.tencent.mm.g.a.z();
                                            zVar.csU.csV = false;
                                            com.tencent.mm.sdk.b.a.xxA.m(zVar);
                                            WorkerProfile.Ca().cfW.BV();
                                            aw.getNotification().IH();
                                            com.tencent.mm.cj.c.atD("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
                                            if (com.tencent.mm.pluginsdk.f.e.vdx != null) {
                                                com.tencent.mm.pluginsdk.f.e.vdx.bd(activity);
                                            }
                                            activity.finish();
                                            AppMethodBeat.o(16093);
                                        }
                                    }, null);
                                    AppMethodBeat.o(16100);
                                    return true;
                                } else if (str.startsWith("//getip")) {
                                    aw.Rg().d(new bk(new bk.a() {
                                        public final void a(com.tencent.mm.network.e eVar) {
                                            AppMethodBeat.i(16094);
                                            if (eVar == null) {
                                                AppMethodBeat.o(16094);
                                                return;
                                            }
                                            int i;
                                            String[] iPsString = eVar.getIPsString(true);
                                            for (i = 0; i < iPsString.length; i++) {
                                                ab.d("MicroMsg.CommandProcessor", "dkip long:%d  %s", Integer.valueOf(i), iPsString[i]);
                                                ab.d("MicroMsg.CommandProcessor", "dkip long:%d %s", Integer.valueOf(i), com.tencent.mm.network.a.c.vd(iPsString[i]).toString());
                                            }
                                            iPsString = eVar.getIPsString(false);
                                            for (i = 0; i < iPsString.length; i++) {
                                                ab.d("MicroMsg.CommandProcessor", "dkip short:%d %s", Integer.valueOf(i), iPsString[i]);
                                                ab.d("MicroMsg.CommandProcessor", "dkip long:%d %s", Integer.valueOf(i), com.tencent.mm.network.a.c.vd(iPsString[i]).toString());
                                            }
                                            AppMethodBeat.o(16094);
                                        }
                                    }));
                                    AppMethodBeat.o(16100);
                                    return true;
                                } else if (str.startsWith("//localjsapi")) {
                                    ab.v("MicroMsg.CommandProcessor", "alvinluo path: %s", "file://" + com.tencent.mm.compatible.util.e.eSn + "test_jsapi.html");
                                    intent2 = new Intent();
                                    intent2.putExtra("rawUrl", str3);
                                    com.tencent.mm.bp.d.b(context, "webview", ".ui.tools.WebViewUI", intent2);
                                    AppMethodBeat.o(16100);
                                    return true;
                                } else if (str.startsWith("//getlocalkey")) {
                                    gA = bs.dus();
                                    com.tencent.mm.ui.base.h.d(context, gA, "Fingerprint Key", context.getString(R.string.f5p), context.getString(R.string.atb), new OnClickListener() {
                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            AppMethodBeat.i(16095);
                                            ((ClipboardManager) context.getSystemService("clipboard")).setText(gA);
                                            Toast.makeText(context, R.string.f5q, 0).show();
                                            AppMethodBeat.o(16095);
                                        }
                                    }, null);
                                    AppMethodBeat.o(16100);
                                    return true;
                                } else if (str.startsWith("//getdevid")) {
                                    gA = q.LM();
                                    com.tencent.mm.ui.base.h.d(context, gA, "devid", context.getString(R.string.akc), context.getString(R.string.atb), new OnClickListener() {
                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            AppMethodBeat.i(16096);
                                            ((ClipboardManager) context.getSystemService("clipboard")).setText(gA);
                                            AppMethodBeat.o(16096);
                                        }
                                    }, null);
                                    AppMethodBeat.o(16100);
                                    return true;
                                } else if (str.startsWith("//testhtml")) {
                                    intent = new Intent();
                                    intent.putExtra("rawUrl", "file:///android_asset/jsapi/reader_test1.html");
                                    com.tencent.mm.bp.d.b(context, "webview", ".ui.tools.WebViewUI", intent);
                                    AppMethodBeat.o(16100);
                                    return true;
                                } else if (str.startsWith("//testlocalhtml ")) {
                                    str3 = str.replace("//testlocalhtml ", "");
                                    intent2 = new Intent();
                                    intent2.putExtra("rawUrl", "file://".concat(String.valueOf(str3)));
                                    intent2.putExtra("neverGetA8Key", true);
                                    com.tencent.mm.bp.d.b(context, "webview", ".ui.tools.WebViewUI", intent2);
                                    AppMethodBeat.o(16100);
                                    return true;
                                } else if (str.startsWith("//setkey")) {
                                    if (bs.apW(str.replace("//setkey", ""))) {
                                        Toast.makeText(context, R.string.f4g, 0).show();
                                    }
                                    AppMethodBeat.o(16100);
                                    return true;
                                } else if (str.startsWith("//checkspell")) {
                                    gA = str.replace("//checkspell ", "");
                                    if (bo.isNullOrNil(gA)) {
                                        AppMethodBeat.o(16100);
                                        return true;
                                    }
                                    stringBuilder2 = new StringBuilder();
                                    for (intValue = 0; intValue < gA.length(); intValue++) {
                                        stringBuilder2.append("[" + gA.charAt(intValue) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + SpellMap.r(gA.charAt(intValue)) + "]");
                                    }
                                    com.tencent.mm.ui.base.h.J(context, stringBuilder2.toString(), "Check Spell");
                                    AppMethodBeat.o(16100);
                                    return true;
                                } else if (str.startsWith("//gallery ")) {
                                    str3 = str.replace("//gallery ", "");
                                    if (bo.isNullOrNil(str3)) {
                                        AppMethodBeat.o(16100);
                                        return true;
                                    }
                                    context.getSharedPreferences(ah.doA(), 0).edit().putString("gallery", str3).commit();
                                    AppMethodBeat.o(16100);
                                    return true;
                                } else if (str.startsWith("//svgtag")) {
                                    str3 = str.replace("//svgtag ", "");
                                    if (str3.equals("on")) {
                                        com.tencent.mm.ca.d.oZ(true);
                                    } else if (str3.equals("off")) {
                                        com.tencent.mm.ca.d.oZ(false);
                                    }
                                    AppMethodBeat.o(16100);
                                    return true;
                                } else if (str.startsWith("//svgcode")) {
                                    try {
                                        str3 = str.replace("//svgcode ", "");
                                        if (!str3.equals("on")) {
                                            str3.equals("off");
                                        }
                                        Class cls = Class.forName("com.tencent.mm.BuildConfig");
                                        Field declaredField = cls.getDeclaredField("SVGCode");
                                        declaredField.setAccessible(true);
                                        booleanValue = declaredField.getBoolean(cls);
                                        try {
                                            Toast.makeText(ah.getContext(), "Using SVG Code : " + booleanValue + " " + com.tencent.mm.svg.b.b.dvK(), 1).show();
                                        } catch (Exception e6) {
                                        }
                                    } catch (ClassNotFoundException e7) {
                                        ab.printErrStackTrace("MicroMsg.CommandProcessor", e7, "", new Object[0]);
                                        booleanValue = false;
                                    } catch (NoSuchFieldException e8) {
                                        ab.printErrStackTrace("MicroMsg.CommandProcessor", e8, "", new Object[0]);
                                        booleanValue = false;
                                    } catch (IllegalAccessException e9) {
                                        ab.printErrStackTrace("MicroMsg.CommandProcessor", e9, "", new Object[0]);
                                        booleanValue = false;
                                    } catch (IllegalArgumentException e10) {
                                        ab.printErrStackTrace("MicroMsg.CommandProcessor", e10, "", new Object[0]);
                                        booleanValue = false;
                                    }
                                    AppMethodBeat.o(16100);
                                    return true;
                                } else if (str.startsWith("//testMbanner")) {
                                    try {
                                        split = str.replace("//testMbanner ", "").split(",");
                                        if (split.length >= 2) {
                                            be.ZV().a(new com.tencent.mm.model.bd(Integer.valueOf(split[0]).intValue(), Integer.valueOf(split[1]).intValue(), null));
                                        }
                                    } catch (Exception e11) {
                                    }
                                    AppMethodBeat.o(16100);
                                    return true;
                                } else {
                                    if (str.startsWith("//testrsa")) {
                                        z.O("010001", "E338E5DAD46B331E3071FAFD4C0F84C7C7965DBBE64C6F8CC0F7CF04DC640C1F84A2014431A48D65F2B2F172BA9BE6F5A049BF52C78C14B0965E20F0D80D85A9180EBABB913D49821D28BFD9601DF52A4F3230AECAD96D23415F5E94D51A87CAA7630C5F3CB70345BAF572A4F61A134A2265AFD8FADDFE0222BD9ABF7DBEB7444D031454E8F21820BBC725E6857F765660E987FADEBCF6B3A15355C4CD3752A7B544D1D7E037AF4F9725BE37681A84C9E1DC431B3065294EAD53E913BAF16D46714B013EA077191E6CA08ABA6D70E9CA792D898D692E3168D6341369976657CD5E1504B9E2458F107225176734D11621AD36D7FFA26C573D6612455B09105C41", 106);
                                    }
                                    if (str.startsWith("//recomT")) {
                                        try {
                                            aw.ZK().Yk().a(str.replace("//recomT ", ""), true, null);
                                        } catch (Exception e12) {
                                        }
                                        AppMethodBeat.o(16100);
                                        return true;
                                    } else if (str.startsWith("//recomF")) {
                                        try {
                                            aw.ZK().Yk().a(str.replace("//recomF ", ""), false, null);
                                        } catch (Exception e13) {
                                        }
                                        AppMethodBeat.o(16100);
                                        return true;
                                    } else if (str.startsWith("//resetwxpayagree")) {
                                        com.tencent.mm.kernel.g.RQ();
                                        com.tencent.mm.kernel.g.RP().Ry().set(ac.a.USERINFO_WALLET_AGREE_PAY_BOOLEAN_SYNC, Boolean.FALSE);
                                        AppMethodBeat.o(16100);
                                        return true;
                                    } else if (str.startsWith("//ffmpeg")) {
                                        try {
                                            intValue = str.indexOf("-r ");
                                            dimensionPixelSize = str.indexOf("-b ");
                                            str3 = str.substring(intValue + 3, dimensionPixelSize);
                                            gA = str.substring(dimensionPixelSize + 3);
                                            float f = bo.getFloat(str3.trim(), 0.0f);
                                            dimensionPixelSize = bo.getInt(gA.trim(), 0);
                                            com.tencent.mm.plugin.sight.base.b.qwZ = dimensionPixelSize;
                                            com.tencent.mm.plugin.sight.base.b.qxa = f;
                                            Toast.makeText(ah.getContext(), "set C2C video encode frame rate " + f + " bitrate " + dimensionPixelSize, 0).show();
                                        } catch (Exception e14) {
                                            Toast.makeText(ah.getContext(), "set C2C video frame rate fail, please ensure your command.", 1).show();
                                        }
                                        AppMethodBeat.o(16100);
                                        return true;
                                    } else if (str.startsWith("//onlinevideo")) {
                                        try {
                                            intValue = bo.getInt(str.replace("//onlinevideo ", ""), 0);
                                            aw.ZK();
                                            com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_ONLINE_VIDEO_INT, Integer.valueOf(intValue));
                                            Toast.makeText(ah.getContext(), intValue > 0 ? "online video" : "offline video", 0).show();
                                        } catch (Exception e15) {
                                            ab.printErrStackTrace("MicroMsg.CommandProcessor", e15, "", new Object[0]);
                                            Toast.makeText(ah.getContext(), "set online video fail, please ensure your command.", 1).show();
                                        }
                                        AppMethodBeat.o(16100);
                                        return true;
                                    } else if (str.startsWith("//hevcinfo")) {
                                        str3 = com.tencent.mm.plugin.n.e.bOU();
                                        gA = ChattingUIFragment.xIj;
                                        bi biVar = new bi();
                                        biVar.ju(gA);
                                        biVar.hO(2);
                                        biVar.setType(1);
                                        biVar.eJ(System.currentTimeMillis());
                                        biVar.setContent(str3);
                                        com.tencent.mm.model.bf.l(biVar);
                                        AppMethodBeat.o(16100);
                                        return true;
                                    } else if (str.startsWith("//presns")) {
                                        com.tencent.mm.sdk.g.d.xDG.p(new Runnable() {
                                            public final void run() {
                                                AppMethodBeat.i(16073);
                                                com.tencent.mm.sdk.b.a.xxA.m(new rn());
                                                AppMethodBeat.o(16073);
                                            }
                                        }, 3000);
                                        Toast.makeText(ah.getContext(), "preload sns", 0).show();
                                        AppMethodBeat.o(16100);
                                        return true;
                                    } else if (str.startsWith("//calcwxdata")) {
                                        aw.ZK();
                                        com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_BACKGROUND_CALC_TIME_LONG, Long.valueOf(0));
                                        Toast.makeText(ah.getContext(), "calc wx data success", 0).show();
                                        AppMethodBeat.o(16100);
                                        return true;
                                    } else if (str.startsWith("//checkspace")) {
                                        try {
                                            intValue = bo.getInt(str.replace("//checkspace ", ""), 0);
                                            com.tencent.mm.g.a.be beVar = new com.tencent.mm.g.a.be();
                                            beVar.cuq.cur = intValue;
                                            com.tencent.mm.sdk.b.a.xxA.m(beVar);
                                            Toast.makeText(ah.getContext(), "check space code ".concat(String.valueOf(intValue)), 0).show();
                                        } catch (Exception e152) {
                                            ab.printErrStackTrace("MicroMsg.CommandProcessor", e152, "", new Object[0]);
                                            Toast.makeText(ah.getContext(), "check space code fail, please ensure your command.", 1).show();
                                        }
                                        AppMethodBeat.o(16100);
                                        return true;
                                    } else {
                                        if (str.startsWith("//showkv") && com.tencent.mm.sdk.a.b.dnO()) {
                                            try {
                                                intent2 = new Intent();
                                                intent2.addFlags(134217728);
                                                intent2.addFlags(SQLiteGlobal.journalSizeLimit);
                                                ((com.tencent.mm.plugin.kitchen.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.kitchen.a.a.class)).w(context, intent2);
                                                AppMethodBeat.o(16100);
                                                return true;
                                            } catch (Exception e1522) {
                                                ab.e("MicroMsg.CommandProcessor", "showkv error [%s]", e1522.toString());
                                            }
                                        }
                                        vv vvVar;
                                        hb hbVar;
                                        final ArrayList dpo2;
                                        if (str.startsWith("//showexpt") && com.tencent.mm.sdk.a.b.dnO()) {
                                            ((com.tencent.mm.plugin.expt.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.expt.a.a.class)).t(context, new Intent());
                                            AppMethodBeat.o(16100);
                                            return true;
                                        } else if (str.startsWith("//showroomexpt") && com.tencent.mm.sdk.a.b.dnO()) {
                                            ((com.tencent.mm.plugin.expt.roomexpt.d) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.expt.roomexpt.d.class)).v(context, new Intent());
                                            AppMethodBeat.o(16100);
                                            return true;
                                        } else if (str.startsWith("//upfacemodel")) {
                                            aw.Rg().d(new com.tencent.mm.pluginsdk.g.a.a.m(42));
                                            AppMethodBeat.o(16100);
                                            return true;
                                        } else if (str.startsWith("//facett")) {
                                            aw.ZK();
                                            com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_FACE_SHOW_TUTORIAL_BOOLEAN_SYNC, Boolean.FALSE);
                                            AppMethodBeat.o(16100);
                                            return true;
                                        } else if (str.startsWith("//startstory")) {
                                            ae.gjz = true;
                                            AppMethodBeat.o(16100);
                                            return true;
                                        } else if (str.startsWith("//switchpaytype")) {
                                            split = str.split(" ");
                                            if (split == null || split.length < 2) {
                                                AppMethodBeat.o(16100);
                                                return false;
                                            }
                                            try {
                                                intValue = bo.getInt(split[1], 0);
                                                aw.ZK();
                                                com.tencent.mm.model.c.Ry().set(339975, Integer.valueOf(intValue));
                                                AppMethodBeat.o(16100);
                                                return true;
                                            } catch (Exception e16) {
                                                ab.e("MicroMsg.CommandProcessor", "hy: switch wallet type error");
                                                AppMethodBeat.o(16100);
                                                return false;
                                            }
                                        } else if (str.startsWith("//setNfcOpenUrl ")) {
                                            str3 = str.replace("//setNfcOpenUrl ", "");
                                            edit = ah.doC().edit();
                                            if (str3.equalsIgnoreCase(BuildConfig.COMMAND)) {
                                                str3 = "";
                                            }
                                            edit.putString("nfc_open_url", str3);
                                            edit.commit();
                                            AppMethodBeat.o(16100);
                                            return true;
                                        } else if (str.startsWith("//setMBV8Debug ")) {
                                            str3 = str.replace("//setMBV8Debug ", "");
                                            edit = ah.doC().edit();
                                            if (str3.equalsIgnoreCase("true")) {
                                                edit.putBoolean("appbrandgame_open_v8debug", true);
                                            } else {
                                                edit.putBoolean("appbrandgame_open_v8debug", false);
                                            }
                                            edit.commit();
                                            AppMethodBeat.o(16100);
                                            return true;
                                        } else if (str.startsWith("//setWcwss ")) {
                                            str3 = str.replace("//setWcwss ", "");
                                            edit = ah.doC().edit();
                                            if (str3.equalsIgnoreCase(BuildConfig.COMMAND)) {
                                                str3 = "";
                                            }
                                            edit.putString("appbrandgame_open_wcwss", str3);
                                            edit.commit();
                                            AppMethodBeat.o(16100);
                                            return true;
                                        } else if (str.startsWith("//gamecb ")) {
                                            str3 = str.replace("//gamecb ", "").trim();
                                            edit = ah.doC().edit();
                                            intValue = bo.ank(str3);
                                            edit.putInt("appbrandgame_use_commandbuffer", intValue);
                                            Context context2 = ah.getContext();
                                            StringBuilder stringBuilder3 = new StringBuilder("小游戏 CommandBuffer ");
                                            str3 = intValue == 0 ? "关闭" : intValue == -1 ? "默认" : "开启";
                                            Toast.makeText(context2, stringBuilder3.append(str3).toString(), 1).show();
                                            edit.commit();
                                            AppMethodBeat.o(16100);
                                            return true;
                                        } else if (str.startsWith("//setAppBrandActionBar ")) {
                                            str3 = str.replace("//setAppBrandActionBar ", "");
                                            edit = ah.doC().edit();
                                            if (str3.equalsIgnoreCase("new")) {
                                                edit.putBoolean("appbrand_new_actionbar", true);
                                            } else {
                                                edit.putBoolean("appbrand_new_actionbar", false);
                                            }
                                            edit.commit();
                                            AppMethodBeat.o(16100);
                                            return true;
                                        } else if (str.startsWith("//snskvtest ")) {
                                            str3 = str.replace("//snskvtest", "").trim();
                                            if (str3.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                                                ae.gje = false;
                                            } else if (str3.equals("1")) {
                                                ae.gje = true;
                                            }
                                            AppMethodBeat.o(16100);
                                            return true;
                                        } else if (str.startsWith("//emoji ")) {
                                            ((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Jo(str.replace("//emoji ", ""));
                                            AppMethodBeat.o(16100);
                                            return true;
                                        } else if (str.startsWith("//share ")) {
                                            intValue = Integer.valueOf(str.replace("//share ", "")).intValue();
                                            aw.ZK();
                                            com.tencent.mm.model.c.Ry().set(229635, Integer.valueOf(intValue));
                                            AppMethodBeat.o(16100);
                                            return true;
                                        } else if (str.startsWith("//dumpappinfoblob ")) {
                                            com.tencent.mm.pluginsdk.model.app.f aiJ = am.bYJ().aiJ(str.replace("//dumpappinfoblob ", ""));
                                            com.tencent.mm.ui.base.h.J(context, aiJ.Hn() + IOUtils.LINE_SEPARATOR_UNIX + aiJ.Ho() + IOUtils.LINE_SEPARATOR_UNIX + aiJ.Hp(), "");
                                            AppMethodBeat.o(16100);
                                            return true;
                                        } else if (str.startsWith("//googleauth ")) {
                                            str3 = str.replace("//googleauth ", "");
                                            if (!TextUtils.isEmpty(str3)) {
                                                if ("webview".equals(str3)) {
                                                    context.getSharedPreferences(ah.doA(), 0).edit().putBoolean("googleauth", true).commit();
                                                } else if (ImagesContract.LOCAL.equals(str3)) {
                                                    context.getSharedPreferences(ah.doA(), 0).edit().putBoolean("googleauth", false).commit();
                                                }
                                            }
                                            AppMethodBeat.o(16100);
                                            return true;
                                        } else if (str.startsWith("//clrgamecache")) {
                                            com.tencent.mm.plugin.game.a.a bDb = com.tencent.mm.plugin.game.a.a.a.bDb();
                                            if (bDb != null) {
                                                bDb.dV(context);
                                            }
                                            AppMethodBeat.o(16100);
                                            return true;
                                        } else if (str.startsWith("//clearwepkg")) {
                                            vvVar = new vv();
                                            vvVar.cSX.cuy = 6;
                                            gA = str.replace("//clearwepkg ", "").trim();
                                            if (!(bo.isNullOrNil(gA) || gA.equals("//clearwepkg"))) {
                                                vvVar.cSX.cSY = gA;
                                            }
                                            com.tencent.mm.sdk.b.a.xxA.m(vvVar);
                                            AppMethodBeat.o(16100);
                                            return true;
                                        } else if (str.startsWith("//disableWePkg")) {
                                            vvVar = new vv();
                                            vvVar.cSX.cuy = 7;
                                            com.tencent.mm.sdk.b.a.xxA.m(vvVar);
                                            AppMethodBeat.o(16100);
                                            return true;
                                        } else if (str.startsWith("//updateGameConfig")) {
                                            gu guVar = new gu();
                                            guVar.cBw.Cn = 5;
                                            com.tencent.mm.sdk.b.a.xxA.m(guVar);
                                            AppMethodBeat.o(16100);
                                            return true;
                                        } else if (str.startsWith("//clrgsd")) {
                                            hbVar = new hb();
                                            hbVar.cBM.cuy = 3;
                                            gA = str.replace("//clrgsd ", "").trim();
                                            if (!(bo.isNullOrNil(gA) || gA.equals("//clrgsd"))) {
                                                hbVar.cBM.csB = gA;
                                            }
                                            com.tencent.mm.sdk.b.a.xxA.m(hbVar);
                                            AppMethodBeat.o(16100);
                                            return true;
                                        } else if (str.startsWith("//delDownload")) {
                                            hbVar = new hb();
                                            hbVar.cBM.cuy = 4;
                                            gA = str.replace("//delDownload ", "").trim();
                                            if (!(bo.isNullOrNil(gA) || gA.equals("//delDownload"))) {
                                                hbVar.cBM.csB = gA;
                                                com.tencent.mm.sdk.b.a.xxA.m(hbVar);
                                            }
                                            AppMethodBeat.o(16100);
                                            return true;
                                        } else if (str.startsWith("//googlemap")) {
                                            ae.giH = true;
                                            AppMethodBeat.o(16100);
                                            return true;
                                        } else if (str.startsWith("//sosomap")) {
                                            ae.giH = false;
                                            AppMethodBeat.o(16100);
                                            return true;
                                        } else if (str.startsWith("//opentrace")) {
                                            com.tencent.mm.ui.applet.d dVar = new com.tencent.mm.ui.applet.d();
                                            com.tencent.mm.ui.applet.d.hI(ah.getContext());
                                            AppMethodBeat.o(16100);
                                            return true;
                                        } else if (str.startsWith("//updateConversation")) {
                                            ab.i("MicroMsg.CommandProcessor", "update all conversation start");
                                            aw.ZK();
                                            for (String str32 : com.tencent.mm.model.c.XR().dsO()) {
                                                aw.ZK();
                                                bi fa = com.tencent.mm.model.c.XO().fa(str32, " and not ( type = 10000 and isSend != 2 ) ");
                                                aw.ZK();
                                                com.tencent.mm.model.c.XR().aq(fa);
                                            }
                                            ab.i("MicroMsg.CommandProcessor", "update all conversation end");
                                            AppMethodBeat.o(16100);
                                            return true;
                                        } else if (str.startsWith("//setshakecarddata")) {
                                            p.a.dgQ().cjO();
                                            AppMethodBeat.o(16100);
                                            return true;
                                        } else if (str.startsWith("//clearshakecarddata")) {
                                            p.a.dgQ().cjP();
                                            AppMethodBeat.o(16100);
                                            return true;
                                        } else if (str.startsWith("//pageSize")) {
                                            Context context3 = ah.getContext();
                                            stringBuilder = new StringBuilder("pageSize is ");
                                            aw.ZK();
                                            Toast.makeText(context3, stringBuilder.append(com.tencent.mm.model.c.Ru().getPageSize()).toString(), 1).show();
                                            AppMethodBeat.o(16100);
                                            return true;
                                        } else if (str.startsWith("//resetDBStatus")) {
                                            aw.ZK();
                                            com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(com.tencent.mm.model.c.Rw());
                                            try {
                                                stringBuilder = new StringBuilder();
                                                aw.ZK();
                                                com.tencent.mm.vfs.e.y(stringBuilder.append(com.tencent.mm.model.c.Rt()).append(bVar.getName().replace(".db", ".db.backup")).toString(), bVar.getPath());
                                                ab.i("MicroMsg.CommandProcessor", "backupPath db path is %s", gA);
                                                com.tencent.mm.vfs.e.aQ(bVar.getPath(), bVar.getAbsolutePath() + "err" + System.currentTimeMillis());
                                                Toast.makeText(ah.getContext(), "db状态已重置,请重启微信", 1).show();
                                            } catch (Exception e15222) {
                                                ab.w("MicroMsg.CommandProcessor", "delete failed: " + e15222.getMessage());
                                            }
                                            AppMethodBeat.o(16100);
                                            return true;
                                        } else if (str.startsWith("//makesnsdata ")) {
                                            p.d.dgR().jR((long) bo.getInt(str.replace("//makesnsdata ", ""), 0));
                                            AppMethodBeat.o(16100);
                                            return true;
                                        } else if (str.startsWith("//setsnsupload ")) {
                                            ae.giR = bo.getInt(str.replace("//setsnsupload ", ""), 0);
                                            AppMethodBeat.o(16100);
                                            return true;
                                        } else if (str.startsWith("//logsnstable")) {
                                            com.tencent.mm.sdk.b.a.xxA.m(new cp());
                                            AppMethodBeat.o(16100);
                                            return true;
                                        } else if (str.startsWith("//resetsnstip")) {
                                            aw.ZK();
                                            com.tencent.mm.model.c.Ry().set(327776, Integer.valueOf(0));
                                            AppMethodBeat.o(16100);
                                            return true;
                                        } else if (str.startsWith("//checkcount")) {
                                            aw.ZK();
                                            intValue = com.tencent.mm.model.c.XO().oA(ChattingUIFragment.xIj);
                                            aw.ZK();
                                            Toast.makeText(context, "current count :" + intValue + " countAuto :" + com.tencent.mm.model.c.XO().Rp(ChattingUIFragment.xIj), 1).show();
                                            AppMethodBeat.o(16100);
                                            return true;
                                        } else if (str.startsWith("//changeframe ")) {
                                            ah.getContext().getSharedPreferences("preferences_animation", 0).edit().putFloat("frameInterval", Float.valueOf(str.replace("//changeframe ", "")).floatValue()).commit();
                                            AppMethodBeat.o(16100);
                                            return true;
                                        } else if (str.startsWith("//opendumpview")) {
                                            com.tencent.mm.ui.applet.c cVar = new com.tencent.mm.ui.applet.c();
                                            com.tencent.mm.ui.applet.c.hH(ah.getContext());
                                            AppMethodBeat.o(16100);
                                            return true;
                                        } else if (str.startsWith("//dumpmemory")) {
                                            System.gc();
                                            System.gc();
                                            com.tencent.mm.cf.b.dvT();
                                            AppMethodBeat.o(16100);
                                            return true;
                                        } else if (str.startsWith("//dumpsnsfile")) {
                                            com.tencent.mm.sdk.b.a.xxA.m(new rc());
                                            AppMethodBeat.o(16100);
                                            return true;
                                        } else if (str.startsWith("//coverage")) {
                                            com.tencent.mm.plugin.report.b.f.VZ(str.trim().substring(10));
                                            AppMethodBeat.o(16100);
                                            return true;
                                        } else if (str.startsWith("//dumpthreadpool")) {
                                            com.tencent.mm.sdk.g.d.xDG.dqb();
                                            AppMethodBeat.o(16100);
                                            return true;
                                        } else if (str.startsWith("//testverifypsw ")) {
                                            str32 = str.replace("//testverifypsw ", "").trim();
                                            if (str32.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                                                ae.gjg = false;
                                            } else if (str32.equals("1")) {
                                                ae.gjg = true;
                                            }
                                            ab.d("MicroMsg.CommandProcessor", "summerdktext testverifypsw msg[%s], testVerifyPsw[%b]", str, Boolean.valueOf(ae.gjg));
                                            AppMethodBeat.o(16100);
                                            return true;
                                        } else if (str.startsWith("//pickpoi")) {
                                            intent = new Intent();
                                            intent.putExtra("map_view_type", 8);
                                            com.tencent.mm.bp.d.b(context, com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION, ".ui.RedirectUI", intent);
                                            AppMethodBeat.o(16100);
                                            return true;
                                        } else if (str.startsWith("//configlist")) {
                                            if (str.matches("^//configlist set ([\\S]*)=([\\S]*)$")) {
                                                List bd = com.tencent.mm.platformtools.ah.bd(str, "^//configlist set ([\\S]*)=([\\S]*)$");
                                                if (bd != null && bd.size() == 2) {
                                                    com.tencent.mm.m.g.Nu().put((String) bd.get(0), (String) bd.get(1));
                                                    com.tencent.mm.sdk.b.a.xxA.m(new cq());
                                                }
                                            } else if (str.matches("^//configlist get ([\\S]*)$")) {
                                                List bd2 = com.tencent.mm.platformtools.ah.bd(str, "^//configlist get ([\\S]*)$");
                                                if (bd2 != null && bd2.size() == 1) {
                                                    str32 = (String) bd2.get(0);
                                                    Toast.makeText(context, str32 + "=" + com.tencent.mm.m.g.Nu().getValue(str32), 0).show();
                                                }
                                            } else {
                                                aw.ZK();
                                                str32 = (String) com.tencent.mm.model.c.Ry().get(278530, (Object) "");
                                                aw.ZK();
                                                gA = (String) com.tencent.mm.model.c.Ry().get(278529, (Object) "");
                                                str4 = com.tencent.mm.compatible.util.e.eSn + "dynacfg.xml";
                                                bo.z(str4, (str32 + gA).getBytes());
                                                Toast.makeText(context, "output dynacfg xml to ".concat(String.valueOf(str4)), 0).show();
                                            }
                                            AppMethodBeat.o(16100);
                                            return true;
                                        } else if (str.startsWith("//security")) {
                                            try {
                                                aw.ZK().Yl().a(str.replace("//security ", ""), true, null);
                                            } catch (Exception e17) {
                                            }
                                            AppMethodBeat.o(16100);
                                            return true;
                                        } else if (str.startsWith("//updatepackage")) {
                                            try {
                                                aw.Rg().d(new com.tencent.mm.ba.k(bo.getInt(str.replace("//updatepackage ", "").trim(), 0)));
                                            } catch (Exception e18) {
                                            }
                                            AppMethodBeat.o(16100);
                                            return true;
                                        } else if (str.startsWith("//copypackage")) {
                                            ab.i("MicroMsg.CommandProcessor", "summercmd copypackage msg:%s", str);
                                            dpo2 = bd.dpo();
                                            tbsSDKVersion = dpo2.size();
                                            ab.i("MicroMsg.CommandProcessor", "summercmd copypackage size:%d", Integer.valueOf(tbsSDKVersion));
                                            if (tbsSDKVersion < 2) {
                                                com.tencent.mm.ui.base.h.bO(context, context.getString(R.string.b37));
                                            } else {
                                                com.tencent.mm.ui.base.h.d(context, context.getString(R.string.b39), "", context.getString(R.string.s6), context.getString(R.string.or), new OnClickListener() {
                                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                                        AppMethodBeat.i(16077);
                                                        com.tencent.mm.sdk.g.d.post(new Runnable() {
                                                            public final void run() {
                                                                AppMethodBeat.i(16076);
                                                                try {
                                                                    String str = com.tencent.mm.compatible.util.e.eSl;
                                                                    aw.ZK();
                                                                    String Yd = com.tencent.mm.model.c.Yd();
                                                                    aw.ZK();
                                                                    String XH = com.tencent.mm.model.c.XH();
                                                                    ab.i("MicroMsg.CommandProcessor", "summercmd copypackage size:%d, root:%s, pkgFullPath:%s, sysPath:%s, pkgPath:%s", Integer.valueOf(tbsSDKVersion), str, Yd, XH, Yd.substring(str.length()));
                                                                    for (int i = 0; i < tbsSDKVersion; i++) {
                                                                        XH = ((bd.a) dpo2.get(i)).xBt;
                                                                        if (!(bo.isNullOrNil(XH) || str.contains(XH))) {
                                                                            com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(XH + r5);
                                                                            if (bVar.exists() && bVar.isDirectory()) {
                                                                                ab.i("MicroMsg.CommandProcessor", "summercmd copypackage done pkgFullPath:%s, old:%s, ret:%b", Yd, com.tencent.mm.vfs.j.w(bVar.dMD()), Boolean.valueOf(com.tencent.mm.vfs.e.is(com.tencent.mm.vfs.j.w(bVar.dMD()), Yd)));
                                                                                if (com.tencent.mm.vfs.e.is(com.tencent.mm.vfs.j.w(bVar.dMD()), Yd)) {
                                                                                    new ak(Looper.getMainLooper()).post(new Runnable() {
                                                                                        public final void run() {
                                                                                            AppMethodBeat.i(16074);
                                                                                            com.tencent.mm.ui.base.h.bQ(context, context.getString(R.string.b38));
                                                                                            AppMethodBeat.o(16074);
                                                                                        }
                                                                                    });
                                                                                    AppMethodBeat.o(16076);
                                                                                    return;
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                    new ak(Looper.getMainLooper()).post(new Runnable() {
                                                                        public final void run() {
                                                                            AppMethodBeat.i(16075);
                                                                            com.tencent.mm.ui.base.h.bQ(context, context.getString(R.string.b37));
                                                                            AppMethodBeat.o(16075);
                                                                        }
                                                                    });
                                                                    AppMethodBeat.o(16076);
                                                                } catch (Exception e) {
                                                                    ab.w("MicroMsg.CommandProcessor", "summercmd copypackage e:%s", e.getMessage());
                                                                    AppMethodBeat.o(16076);
                                                                }
                                                            }
                                                        }, "copypackage");
                                                        AppMethodBeat.o(16077);
                                                    }
                                                }, null);
                                            }
                                            AppMethodBeat.o(16100);
                                            return true;
                                        } else if (str.startsWith("//copy -n ")) {
                                            ab.i("MicroMsg.CommandProcessor", "summercmd copy -n msg:%s ", str);
                                            dpo2 = bd.dpo();
                                            tbsSDKVersion = dpo2.size();
                                            ab.i("MicroMsg.CommandProcessor", "summercmd copy -n size:%d", Integer.valueOf(tbsSDKVersion));
                                            if (tbsSDKVersion < 2) {
                                                com.tencent.mm.ui.base.h.bO(context, context.getString(R.string.b37));
                                            } else {
                                                com.tencent.mm.ui.base.h.d(context, context.getString(R.string.b39), "", context.getString(R.string.s6), context.getString(R.string.or), new OnClickListener() {
                                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                                        AppMethodBeat.i(16081);
                                                        com.tencent.mm.sdk.g.d.post(new Runnable() {
                                                            public final void run() {
                                                                AppMethodBeat.i(16080);
                                                                try {
                                                                    String substring = str.substring(10);
                                                                    String str = com.tencent.mm.compatible.util.e.eSl;
                                                                    aw.ZK();
                                                                    String str2 = com.tencent.mm.model.c.getAccPath() + substring;
                                                                    ab.i("MicroMsg.CommandProcessor", "summercmd copy -n subDir:%s, root:%s, accPath:%s destPath:%s, subPath:%s", substring, str, r1, str2, str2.substring(str.length()));
                                                                    for (int i = 0; i < tbsSDKVersion; i++) {
                                                                        substring = ((bd.a) dpo2.get(i)).xBt;
                                                                        if (!(bo.isNullOrNil(substring) || str.contains(substring))) {
                                                                            com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(substring + r5);
                                                                            if (bVar.exists() && bVar.isDirectory()) {
                                                                                com.tencent.mm.vfs.b bVar2 = new com.tencent.mm.vfs.b(str2);
                                                                                if (!bVar2.exists()) {
                                                                                    bVar2.mkdirs();
                                                                                }
                                                                                ab.i("MicroMsg.CommandProcessor", "summercmd copy -n done new:%s, old:%s, ret:%b", com.tencent.mm.vfs.j.w(bVar2.dMD()), com.tencent.mm.vfs.j.w(bVar.dMD()), Boolean.valueOf(com.tencent.mm.vfs.e.is(com.tencent.mm.vfs.j.w(bVar.dMD()), com.tencent.mm.vfs.j.w(bVar2.dMD()))));
                                                                                if (com.tencent.mm.vfs.e.is(com.tencent.mm.vfs.j.w(bVar.dMD()), com.tencent.mm.vfs.j.w(bVar2.dMD()))) {
                                                                                    new ak(Looper.getMainLooper()).post(new Runnable() {
                                                                                        public final void run() {
                                                                                            AppMethodBeat.i(16078);
                                                                                            com.tencent.mm.ui.base.h.bQ(context, context.getString(R.string.b38));
                                                                                            AppMethodBeat.o(16078);
                                                                                        }
                                                                                    });
                                                                                    AppMethodBeat.o(16080);
                                                                                    return;
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                    new ak(Looper.getMainLooper()).post(new Runnable() {
                                                                        public final void run() {
                                                                            AppMethodBeat.i(16079);
                                                                            com.tencent.mm.ui.base.h.bQ(context, context.getString(R.string.b37));
                                                                            AppMethodBeat.o(16079);
                                                                        }
                                                                    });
                                                                    AppMethodBeat.o(16080);
                                                                } catch (Exception e) {
                                                                    ab.w("MicroMsg.CommandProcessor", "summercmd copy -n e:%s", e.getMessage());
                                                                    AppMethodBeat.o(16080);
                                                                }
                                                            }
                                                        }, "copy -n");
                                                        AppMethodBeat.o(16081);
                                                    }
                                                }, null);
                                            }
                                            AppMethodBeat.o(16100);
                                            return true;
                                        } else if (str.startsWith("//deletepackage")) {
                                            try {
                                                str32 = str.replace("//deletepackage ", "");
                                                ci ciVar = new ci();
                                                ciVar.cvy.cvz = bo.getInt(str32, 0);
                                                com.tencent.mm.sdk.b.a.xxA.m(ciVar);
                                            } catch (Exception e19) {
                                            }
                                            AppMethodBeat.o(16100);
                                            return true;
                                        } else if (str.startsWith("//audiowritetofile")) {
                                            q.etd.eql = true;
                                            AppMethodBeat.o(16100);
                                            return true;
                                        } else if (str.startsWith("//bankcard")) {
                                            intent = new Intent();
                                            intent.putExtra("BaseScanUI_select_scan_mode", 7);
                                            intent.putExtra("bank_card_owner", "test");
                                            if (!(com.tencent.mm.plugin.voip.e.bI(context) || com.tencent.mm.bg.e.bH(context))) {
                                                com.tencent.mm.bp.d.b((Activity) context, "scanner", ".ui.BaseScanUI", intent);
                                            }
                                            AppMethodBeat.o(16100);
                                            return true;
                                        } else {
                                            if (str.startsWith("//banner")) {
                                                Map z4 = br.z("<sysmsg type=\"banner\"><mainframebanner type=\"11\"><showtype>1</showtype></mainframebanner></sysmsg>", "sysmsg");
                                                str32 = (String) z4.get(".sysmsg.mainframebanner.$type");
                                                gA = (String) z4.get(".sysmsg.mainframebanner.showtype");
                                                str4 = (String) z4.get(".sysmsg.mainframebanner.data");
                                                ab.d("MicroMsg.CommandProcessor", "type:%s showType:%s data:%s", str32, gA, str4);
                                            }
                                            if (str.startsWith("//gamemsg")) {
                                                mz mzVar = new mz();
                                                mzVar.cIX.content = str;
                                                com.tencent.mm.sdk.b.a.xxA.m(mzVar);
                                                AppMethodBeat.o(16100);
                                                return true;
                                            } else if (str.startsWith("//shortcut#")) {
                                                vq vqVar = new vq();
                                                vqVar.cSC.cSD = str;
                                                com.tencent.mm.sdk.b.a.xxA.m(vqVar);
                                                AppMethodBeat.o(16100);
                                                return true;
                                            } else if (str.startsWith("//gallerytype")) {
                                                com.tencent.mm.ui.chatting.p.yJd = !com.tencent.mm.ui.chatting.p.yJd;
                                                AppMethodBeat.o(16100);
                                                return true;
                                            } else {
                                                context.getString(R.string.f7w);
                                                Object replace;
                                                if (str.startsWith("//fullexit")) {
                                                    com.tencent.mm.sdk.platformtools.aj.amB("show_whatsnew");
                                                    com.tencent.mm.kernel.l.m(context, true);
                                                    MMAppMgr.bd(context);
                                                    aw.hold();
                                                    com.tencent.mm.kernel.g.RQ().lL("");
                                                    MMAppMgr.aAd();
                                                    AppMethodBeat.o(16100);
                                                    return true;
                                                } else if (str.startsWith("//cleardldb")) {
                                                    aw.ZK();
                                                    com.tencent.mm.model.c.XS().bit();
                                                    AppMethodBeat.o(16100);
                                                    return true;
                                                } else if (str.startsWith("//setcardlayouttestdata")) {
                                                    replace = str.replace("//setcardlayouttestdata ", "");
                                                    aw.ZK();
                                                    com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_CARDLAYOUT_TESTDATA_STRING, replace);
                                                    AppMethodBeat.o(16100);
                                                    return true;
                                                } else if (str.startsWith("//delchatroomsysmsg")) {
                                                    str32 = str.replace("//delchatroomsysmsg ", "");
                                                    dimensionPixelSize = str32.indexOf(" ");
                                                    str4 = str32.substring(0, dimensionPixelSize);
                                                    str32 = str32.substring(dimensionPixelSize);
                                                    if (bo.isNullOrNil(str4)) {
                                                        AppMethodBeat.o(16100);
                                                        return false;
                                                    } else if (str32.startsWith("<")) {
                                                        bi biVar2 = new bi();
                                                        biVar2.eJ(System.currentTimeMillis());
                                                        biVar2.setType(10002);
                                                        biVar2.setContent(str32);
                                                        biVar2.hO(0);
                                                        biVar2.ju(str4);
                                                        com.tencent.mm.model.bf.l(biVar2);
                                                        AppMethodBeat.o(16100);
                                                        return true;
                                                    } else {
                                                        AppMethodBeat.o(16100);
                                                        return false;
                                                    }
                                                } else {
                                                    if (str.startsWith("//resetcrseq")) {
                                                        split = str.split(" ");
                                                        try {
                                                            long j2 = bo.getLong(split[1], -1);
                                                            long j3 = bo.getLong(split[2], -1);
                                                            long j4 = bo.getLong(split[3], -1);
                                                            intValue = bo.getInt(split[4], -1);
                                                            if (j2 > 0) {
                                                                gA = j2 + "@chatroom";
                                                                aw.ZK();
                                                                com.tencent.mm.storage.ak aoZ = com.tencent.mm.model.c.XR().aoZ(gA);
                                                                if (aoZ != null) {
                                                                    ab.i("MicroMsg.CommandProcessor", "summerbadcr resetcrseq [%s] before [%d, %d, %d] [%d, %d, %d]", aoZ.getUsername(), Long.valueOf(aoZ.Hz()), Long.valueOf(aoZ.Hx()), Integer.valueOf(aoZ.Hy()), Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(intValue));
                                                                    if (j3 > -1) {
                                                                        aoZ.eG(j3);
                                                                    }
                                                                    if (j4 > -1) {
                                                                        aoZ.eF(j4);
                                                                    }
                                                                    if (intValue >= 0) {
                                                                        aoZ.hT(intValue);
                                                                    }
                                                                    aw.ZK();
                                                                    intValue = com.tencent.mm.model.c.XR().a(aoZ, aoZ.getUsername(), false);
                                                                    ab.i("MicroMsg.CommandProcessor", "summerbadcr resetcrseq [%s] done [%d, %d, %d] ret:%d", aoZ.getUsername(), Long.valueOf(aoZ.Hz()), Long.valueOf(aoZ.Hx()), Integer.valueOf(aoZ.Hy()), Integer.valueOf(intValue));
                                                                    AppMethodBeat.o(16100);
                                                                    return true;
                                                                }
                                                            }
                                                        } catch (Exception e152222) {
                                                            ab.printErrStackTrace("MicroMsg.CommandProcessor", e152222, "summerbadcr resetcrseq", new Object[0]);
                                                        }
                                                    }
                                                    if (str.startsWith("//printchatroominfo")) {
                                                        str32 = ChattingUIFragment.xIj;
                                                        if (com.tencent.mm.model.t.kH(str32)) {
                                                            aw.ZK();
                                                            final com.tencent.mm.storage.u oa = com.tencent.mm.model.c.XV().oa(str32);
                                                            if (oa == null) {
                                                                ab.e("MicroMsg.CommandProcessor", "summercrinfo chatroomId[%s], member is null", str32);
                                                                AppMethodBeat.o(16100);
                                                                return false;
                                                            }
                                                            com.tencent.mm.sdk.g.d.xDG.execute(new Runnable() {
                                                                public final void run() {
                                                                    AppMethodBeat.i(16082);
                                                                    int drT = oa.drT();
                                                                    int i = oa.field_chatroomdataflag;
                                                                    int drV = oa.drV();
                                                                    com.tencent.mm.storage.u uVar = oa;
                                                                    if (uVar.b(uVar.xIo)) {
                                                                        uVar.drS();
                                                                    }
                                                                    int i2 = uVar.xIo.status;
                                                                    int drW = oa.drW();
                                                                    uVar = oa;
                                                                    if (uVar.b(uVar.xIo)) {
                                                                        uVar.drS();
                                                                    }
                                                                    String str = uVar.xIo.eox;
                                                                    List afg = oa.afg();
                                                                    aw.ZK();
                                                                    bi fa = com.tencent.mm.model.c.XO().fa(str32, " and msgSeq != 0 and flag & 2 != 0");
                                                                    boolean z = fa != null && fa.field_msgId > 0;
                                                                    aw.ZK();
                                                                    ab.i("MicroMsg.CommandProcessor", "summercrinfo chatroomId[%s], version[%d], flag[%d], type[%d], status[%d], get[%b], msgCount[%d], maxCount[%d], upgrader[%s], membersize[%d]", str32, Integer.valueOf(drT), Integer.valueOf(i), Integer.valueOf(drV), Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(com.tencent.mm.model.c.XO().Rp(str32)), Integer.valueOf(drW), str, Integer.valueOf(afg.size()));
                                                                    StringBuilder stringBuilder = new StringBuilder();
                                                                    stringBuilder.append("---chatroominfo---\nid:").append(str32).append("\nver:").append(drT).append("\nflag:").append(i).append("\ntype:").append(drV).append("\nstatus:").append(i2).append("\nget:").append(z).append("\nmsgCount:").append(r8).append("\nmaxCount:").append(drW).append("\nupgrader:").append(str).append("\nmembersize:").append(afg.size()).append("\nisSilence:").append(((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOm().QL(str32)).append("\nsillenceBlock:").append(((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOm().QO(str32).toString());
                                                                    int i3 = -1;
                                                                    try {
                                                                        i3 = bo.getInt(str.split(" ")[1], 0);
                                                                    } catch (Exception e) {
                                                                    }
                                                                    if (i3 == -1) {
                                                                        i3 = afg.size();
                                                                    }
                                                                    if (i3 > afg.size()) {
                                                                        i3 = afg.size();
                                                                    }
                                                                    if (i3 > 10) {
                                                                        i = 10;
                                                                    } else {
                                                                        i = i3;
                                                                    }
                                                                    if (i > 0) {
                                                                        stringBuilder.append("\nmember:");
                                                                    }
                                                                    for (drT = 0; drT < i; drT++) {
                                                                        stringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX).append((String) afg.get(drT));
                                                                    }
                                                                    fa = new bi();
                                                                    fa.ju(str32);
                                                                    fa.hO(2);
                                                                    fa.setType(1);
                                                                    fa.eJ(System.currentTimeMillis());
                                                                    fa.setContent(stringBuilder.toString());
                                                                    com.tencent.mm.model.bf.l(fa);
                                                                    AppMethodBeat.o(16082);
                                                                }
                                                            });
                                                            AppMethodBeat.o(16100);
                                                            return true;
                                                        }
                                                        AppMethodBeat.o(16100);
                                                        return false;
                                                    } else if (str.startsWith("//clean chatroomblock")) {
                                                        gA = ChattingUIFragment.xIj;
                                                        com.tencent.mm.plugin.messenger.foundation.a.a.b bOm = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOm();
                                                        if (str.equals("//clean chatroomblock hard")) {
                                                            Toast.makeText(ah.getContext(), "clean block hard! ret:".concat(String.valueOf(bOm.QF(gA))), 1).show();
                                                            AppMethodBeat.o(16100);
                                                            return true;
                                                        } else if (str.equals("//clean chatroomblock all")) {
                                                            Toast.makeText(ah.getContext(), "delete table! ret:".concat(String.valueOf(bOm.bOu())), 1).show();
                                                            AppMethodBeat.o(16100);
                                                            return true;
                                                        } else {
                                                            w QN = bOm.QN(gA);
                                                            QN.field_lastLocalSeq = QN.field_lastPushSeq;
                                                            QN.field_lastLocalCreateTime = QN.field_lastPushCreateTime;
                                                            if (QN.field_seqBlockInfo != null) {
                                                                QN.field_seqBlockInfo.eoG.clear();
                                                            }
                                                            j = bOm.b(QN);
                                                            ab.i("MicroMsg.CommandProcessor", "[chatroomblock] ret:".concat(String.valueOf(j)));
                                                            Toast.makeText(ah.getContext(), "clean chatroomblock! ret:".concat(String.valueOf(j)), 1).show();
                                                            AppMethodBeat.o(16100);
                                                            return true;
                                                        }
                                                    } else if (str.equals("//testupdate")) {
                                                        replace = "";
                                                        try {
                                                            replace = bo.convertStreamToString(context.getAssets().open("aplha_update_info.xml"));
                                                        } catch (IOException e20) {
                                                            ab.printErrStackTrace("MicroMsg.CommandProcessor", e20, "", new Object[0]);
                                                        }
                                                        aw.ZK();
                                                        com.tencent.mm.model.c.Ry().set(352273, replace);
                                                        aw.ZK();
                                                        com.tencent.mm.model.c.Ry().set(352274, Long.valueOf(System.currentTimeMillis()));
                                                        new com.tencent.mm.pluginsdk.model.app.a(replace).dhv();
                                                        AppMethodBeat.o(16100);
                                                        return true;
                                                    } else if (str.equals("//checkUpdate0") || str.equals("//checkUpdate1")) {
                                                        com.tencent.mm.plugin.p.d.bQU().jd(str.equals("//checkUpdate1"));
                                                        com.tencent.mm.plugin.p.d.oEm = true;
                                                        AppMethodBeat.o(16100);
                                                        return true;
                                                    } else if (str.equals("//debugsnstimelinestat")) {
                                                        ae.giZ = !ae.giZ;
                                                        Toast.makeText(ah.getContext(), "debugSnsTimelineStat: " + ae.giZ, 0).show();
                                                        AppMethodBeat.o(16100);
                                                        return true;
                                                    } else if (str.startsWith("//abtestmsg") && com.tencent.mm.sdk.a.b.dnO()) {
                                                        com.tencent.mm.model.c.a.a pb = com.tencent.mm.model.c.a.pb(str.replace("//abtestmsg", ""));
                                                        com.tencent.mm.model.c.c.abi().s(pb.items, 0);
                                                        com.tencent.mm.model.c.c.abj().s(pb.foD, 1);
                                                        AppMethodBeat.o(16100);
                                                        return true;
                                                    } else if (str.startsWith("//triggergetabtest")) {
                                                        aw.ZK();
                                                        com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_ABTEST_LAST_UPDATE_TIME_LONG, Long.valueOf(1));
                                                        AppMethodBeat.o(16100);
                                                        return true;
                                                    } else if (str.startsWith("//vad")) {
                                                        doB = ah.doB();
                                                        if (doB == null) {
                                                            AppMethodBeat.o(16100);
                                                            return false;
                                                        } else if (str.startsWith("//vad get")) {
                                                            com.tencent.mm.ui.base.h.J(context, com.tencent.mm.modelvoiceaddr.a.c.amz(), "VAD PARAMS").show();
                                                            AppMethodBeat.o(16100);
                                                            return true;
                                                        } else {
                                                            edit2 = doB.edit();
                                                            if (str.startsWith("//vad sd")) {
                                                                edit2.putInt("s_delay_time", Integer.valueOf(str.substring(9).trim()).intValue());
                                                            }
                                                            if (str.startsWith("//vad st")) {
                                                                edit2.putInt("sil_time", Integer.valueOf(str.substring(9).trim()).intValue());
                                                            }
                                                            if (str.startsWith("//vad snr")) {
                                                                edit2.putFloat("s_n_ration", Float.valueOf(str.substring(10).trim()).floatValue());
                                                            }
                                                            if (str.startsWith("//vad sw")) {
                                                                edit2.putInt("s_window", Integer.valueOf(str.substring(9).trim()).intValue());
                                                            }
                                                            if (str.startsWith("//vad sl")) {
                                                                edit2.putInt("s_length", Integer.valueOf(str.substring(9).trim()).intValue());
                                                            }
                                                            edit2.apply();
                                                            AppMethodBeat.o(16100);
                                                            return true;
                                                        }
                                                    } else if (str.startsWith("//dumpabtestrecords")) {
                                                        if (2 < ab.getLogLevel()) {
                                                            AppMethodBeat.o(16100);
                                                            return false;
                                                        }
                                                        CharSequence drt;
                                                        if (str.contains("info")) {
                                                            drt = com.tencent.mm.model.c.c.abj().drt();
                                                        } else {
                                                            drt = com.tencent.mm.model.c.c.abi().drt();
                                                        }
                                                        textView2 = new TextView(context);
                                                        textView2.setText(drt);
                                                        textView2.setGravity(8388627);
                                                        textView2.setTextSize(1, 10.0f);
                                                        textView2.setLayoutParams(new LayoutParams(-1, -2));
                                                        textView2.setTextColor(-16744704);
                                                        textView2.setTypeface(Typeface.MONOSPACE);
                                                        textView2.setMovementMethod(new ScrollingMovementMethod());
                                                        intValue = context.getResources().getDimensionPixelSize(R.dimen.l5);
                                                        textView2.setPadding(intValue, intValue, intValue, intValue);
                                                        com.tencent.mm.ui.base.h.a(context, null, textView2, null);
                                                        AppMethodBeat.o(16100);
                                                        return true;
                                                    } else if (str.startsWith("//triggerWebViewCookiesCleanup")) {
                                                        aw.ZK();
                                                        com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_WEBVIEW_CLEAR_HOST_COOKIES_INTERVAL_LONG, Long.valueOf(0));
                                                        AppMethodBeat.o(16100);
                                                        return true;
                                                    } else if (str.startsWith("//cleanwebcache")) {
                                                        com.tencent.mm.sdk.b.a.xxA.m(new com.tencent.mm.g.a.bo());
                                                        AppMethodBeat.o(16100);
                                                        return true;
                                                    } else if (str.startsWith("//triggerWebViewCacheCleanup")) {
                                                        com.tencent.mm.cj.c.atD("com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
                                                        AppMethodBeat.o(16100);
                                                        return true;
                                                    } else if (str.startsWith("//dumpsnsabtest")) {
                                                        com.tencent.mm.sdk.b.a.xxA.m(new cn());
                                                        AppMethodBeat.o(16100);
                                                        return true;
                                                    } else if (str.startsWith("//dumpsilkvoicefile")) {
                                                        ae.gjd = true;
                                                        AppMethodBeat.o(16100);
                                                        return true;
                                                    } else if (str.startsWith("//fucktit")) {
                                                        aw.ZK();
                                                        com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_SUBMENU_SHOW_TIT_BOOLEAN, Boolean.TRUE);
                                                        AppMethodBeat.o(16100);
                                                        return true;
                                                    } else if (str.startsWith("//clog ")) {
                                                        com.tencent.mm.plugin.report.service.h.pYm.fP(str.substring(7), "test cLog " + System.currentTimeMillis());
                                                        AppMethodBeat.o(16100);
                                                        return true;
                                                    } else if (str.startsWith("//testformsg") && com.tencent.mm.sdk.a.b.dnO()) {
                                                        str32 = str.substring(12).trim();
                                                        ab.i("MicroMsg.CommandProcessor", "MMCore.getSysCmdMsgExtension() " + aw.getSysCmdMsgExtension());
                                                        cm cmVar = new cm();
                                                        cmVar.vED = com.tencent.mm.platformtools.aa.vy(str32);
                                                        cmVar.vEB = com.tencent.mm.platformtools.aa.vy("weixin");
                                                        cmVar.vEC = com.tencent.mm.platformtools.aa.vy(r.Yz());
                                                        cmVar.vEF = com.tencent.mm.platformtools.aa.vz("test");
                                                        cmVar.nao = 10002;
                                                        aw.getSysCmdMsgExtension().b(new com.tencent.mm.ai.e.a(cmVar, false, false, false));
                                                        AppMethodBeat.o(16100);
                                                        return true;
                                                    } else if (str.startsWith("//canwebviewcachedownload")) {
                                                        booleanValue = bo.getInt(bo.nullAsNil(str.substring(25)).trim(), 1) > 0;
                                                        aw.ZK();
                                                        com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_SET_CAN_WEBVIEW_CACHE_DOWNLOAD_BOOLEAN, Boolean.valueOf(booleanValue));
                                                        AppMethodBeat.o(16100);
                                                        return true;
                                                    } else if (str.startsWith("//canwebviewcacheprepushdownload")) {
                                                        booleanValue = bo.getInt(bo.nullAsNil(str.substring(32)).trim(), 1) > 0;
                                                        aw.ZK();
                                                        com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_SET_CAN_WEBVIEW_CACHE_PRE_PUSH_DOWNLOAD_BOOLEAN, Boolean.valueOf(booleanValue));
                                                        AppMethodBeat.o(16100);
                                                        return true;
                                                    } else if (str.startsWith("//resetsnslukcy")) {
                                                        aw.ZK();
                                                        com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLLUCKYCTRLHASSHOW_BOOLEAN_SYNC, Boolean.FALSE);
                                                        aw.ZK();
                                                        com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLLUCKYCOUNT_INT_SYNC, Integer.valueOf(0));
                                                        aw.ZK();
                                                        com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLLUCKYCOUNT2_INT_SYNC, Integer.valueOf(0));
                                                        com.tencent.mm.sdk.b.a.xxA.m(new rt());
                                                        AppMethodBeat.o(16100);
                                                        return true;
                                                    } else if (str.startsWith("//enablempsp")) {
                                                        ar.a.pi(false);
                                                        Toast.makeText(context, "设置成功，请重启微信！", 0).show();
                                                        AppMethodBeat.o(16100);
                                                        return true;
                                                    } else if (str.startsWith("//disablempsp")) {
                                                        ar.a.pi(true);
                                                        Toast.makeText(context, "设置成功，请重启微信！", 0).show();
                                                        AppMethodBeat.o(16100);
                                                        return true;
                                                    } else if (str.startsWith("//soterpay")) {
                                                        com.tencent.mm.bp.d.H(context, FingerprintManagerProxy.FINGERPRINT_SERVICE, ".ui.SoterPayTestUI");
                                                        AppMethodBeat.o(16100);
                                                        return true;
                                                    } else if (str.startsWith(context.getString(R.string.f5f))) {
                                                        ae.gjk = !ae.gjk;
                                                        Toast.makeText(ah.getContext(), String.format("showVoipDebugLog:%b", new Object[]{Boolean.valueOf(ae.gjk)}), 0).show();
                                                        AppMethodBeat.o(16100);
                                                        return true;
                                                    } else if (str.startsWith("//getdltaskinfo")) {
                                                        str32 = str.replace("//getdltaskinfo ", "");
                                                        try {
                                                            if (com.tencent.mm.plugin.downloader.model.c.hv(bo.getLong(str32, 0)) != null) {
                                                                ab.i("getdltaskinfo", "%d, %s, %s, %s", Long.valueOf(com.tencent.mm.plugin.downloader.model.c.hv(bo.getLong(str32, 0)).field_downloadId), com.tencent.mm.plugin.downloader.model.c.hv(bo.getLong(str32, 0)).field_downloadUrl, com.tencent.mm.plugin.downloader.model.c.hv(bo.getLong(str32, 0)).field_filePath, com.tencent.mm.plugin.downloader.model.c.hv(bo.getLong(str32, 0)).field_md5);
                                                            } else {
                                                                ab.i("getdltaskinfo", "infoID null");
                                                            }
                                                        } catch (Exception e21) {
                                                            if (com.tencent.mm.plugin.downloader.model.c.Iq(str32) != null) {
                                                                ab.i("getdltaskinfo", "%d, %s, %s, %s", Long.valueOf(com.tencent.mm.plugin.downloader.model.c.Iq(str32).field_downloadId), com.tencent.mm.plugin.downloader.model.c.Iq(str32).field_downloadUrl, com.tencent.mm.plugin.downloader.model.c.Iq(str32).field_filePath, com.tencent.mm.plugin.downloader.model.c.Iq(str32).field_md5);
                                                            } else {
                                                                ab.i("getdltaskinfo", "infoURL null");
                                                            }
                                                        }
                                                        AppMethodBeat.o(16100);
                                                        return true;
                                                    } else if (str.startsWith("//testscan ")) {
                                                        split = str.split(" ");
                                                        ae.gjj = bo.getFloat(split[1], 0.0f);
                                                        ae.gji = bo.getFloat(split[2], 0.0f);
                                                        Toast.makeText(ah.getContext(), "mode auto:" + ae.gjj + ",mode continuous:" + ae.gji, 1).show();
                                                        AppMethodBeat.o(16100);
                                                        return true;
                                                    } else if (str.startsWith("//switchrecordmode")) {
                                                        sharedPreferences = ah.doB();
                                                        z2 = sharedPreferences.getBoolean("settings_voicerecorder_mode", false);
                                                        sharedPreferences.edit().putBoolean("settings_voicerecorder_mode", !z2).commit();
                                                        if (z2) {
                                                            Toast.makeText(ah.getContext(), "Turn off silk record", 1).show();
                                                        } else {
                                                            Toast.makeText(ah.getContext(), "Turn on silk record", 1).show();
                                                        }
                                                        AppMethodBeat.o(16100);
                                                        return true;
                                                    } else if (str.startsWith("//indoorsensorconfig ")) {
                                                        com.tencent.mm.modelstat.e.akf().tI(str.replace("//indoorsensorconfig ", ""));
                                                        AppMethodBeat.o(16100);
                                                        return true;
                                                    } else if (str.startsWith("//testindoorsensor ")) {
                                                        String[] split4 = str.replace("//testindoorsensor ", "").split(",");
                                                        com.tencent.mm.modelstat.e.akf().a(12345, false, split4[0].equals("1"), bo.getFloat(split4[1], 0.0f), bo.getFloat(split4[2], 0.0f), 12);
                                                        AppMethodBeat.o(16100);
                                                        return true;
                                                    } else if (str.startsWith("//facedebug")) {
                                                        AppMethodBeat.o(16100);
                                                        return true;
                                                    } else if (str.startsWith("//rstfacett")) {
                                                        AppMethodBeat.o(16100);
                                                        return true;
                                                    } else if (str.startsWith("//switchjsc")) {
                                                        str32 = str.replace("//switchjsc ", "");
                                                        sharedPreferences = ah.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
                                                        if ("clear".equals(str32)) {
                                                            sharedPreferences.edit().remove("switch_x5_jscore").apply();
                                                        } else if ("true".equals(str32)) {
                                                            sharedPreferences.edit().putBoolean("switch_x5_jscore", true).apply();
                                                        } else if ("false".equals(str32)) {
                                                            sharedPreferences.edit().putBoolean("switch_x5_jscore", false).apply();
                                                        }
                                                        AppMethodBeat.o(16100);
                                                        return true;
                                                    } else if (str.startsWith("//rfcdn")) {
                                                        try {
                                                            com.tencent.mm.al.f.afy().keep_OnRequestDoGetCdnDnsInfo(888);
                                                        } catch (Exception e1522222) {
                                                            ab.e("MicroMsg.CommandProcessor", "rfcdn :%s", bo.l(e1522222));
                                                        }
                                                        AppMethodBeat.o(16100);
                                                        return true;
                                                    } else {
                                                        if (str.startsWith("//testcrscroll ")) {
                                                            split = str.split(" ");
                                                            if (split != null && split.length > 1) {
                                                                com.tencent.mm.ui.chatting.c.ak.yRY = bo.getInt(split[1], 0);
                                                                ab.i("MicroMsg.CommandProcessor", "summerbadcr testscroll new BADCR_SCROLL_DELAY[%d]", Integer.valueOf(com.tencent.mm.ui.chatting.c.ak.yRY));
                                                                AppMethodBeat.o(16100);
                                                                return true;
                                                            }
                                                        }
                                                        if (str.startsWith("//switchx5jscore")) {
                                                            doB = ah.doB();
                                                            doB.edit().putBoolean("switch_x5_jscore", !doB.getBoolean("switch_x5_jscore", true)).apply();
                                                            AppMethodBeat.o(16100);
                                                            return true;
                                                        } else if (str.startsWith("//removeaudioplayer")) {
                                                            split = str.split(" ");
                                                            if (split.length >= 2) {
                                                                intValue = bo.getInt(split[1], 3);
                                                                if (intValue >= 2 && intValue <= 9) {
                                                                    aw.ZK();
                                                                    com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_MUSIC_RREMOVE_PLAYING_AUDIO_PLAYER_GROUP_COUNT_INT_SYNC, Integer.valueOf(intValue));
                                                                }
                                                            }
                                                            AppMethodBeat.o(16100);
                                                            return true;
                                                        } else if (str.startsWith("//showaudiotoast")) {
                                                            split = str.split(" ");
                                                            if (split.length >= 2) {
                                                                intValue = bo.getInt(split[1], 0);
                                                                aw.ZK();
                                                                com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_MUSIC_SHOW_AUDIO_TOAST_BOOLEAN_SYNC, Boolean.valueOf(intValue == 1));
                                                            }
                                                            AppMethodBeat.o(16100);
                                                            return true;
                                                        } else if (str.startsWith("//openmixaudio")) {
                                                            split = str.split(" ");
                                                            if (split.length >= 2) {
                                                                intValue = bo.getInt(split[1], 0);
                                                                aw.ZK();
                                                                com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_MUSIC_OPEN_MIX_AUDIO_BOOLEAN_SYNC, Boolean.valueOf(intValue == 1));
                                                            }
                                                            AppMethodBeat.o(16100);
                                                            return true;
                                                        } else if (str.startsWith("//switchmusicplayer")) {
                                                            ab.i("MicroMsg.CommandProcessor", "msg:%s", str);
                                                            split2 = str.split(" ");
                                                            if (split2.length > 2) {
                                                                Object obj2;
                                                                if (bo.getInt(split2[1], 0) == 0) {
                                                                    obj2 = null;
                                                                } else {
                                                                    dimensionPixelSize = 1;
                                                                }
                                                                int i2 = bo.getInt(split2[2], -1);
                                                                aw.ZK();
                                                                i = ((Integer) com.tencent.mm.model.c.Ry().get(ac.a.USERINFO_MUSIC_PLAYER_SWITCH_FLAG_INT_SYNC, Integer.valueOf(0))).intValue();
                                                                replace = 1;
                                                                if (i2 == -1) {
                                                                    if (obj2 != null) {
                                                                        dimensionPixelSize = 255;
                                                                    } else {
                                                                        dimensionPixelSize = 0;
                                                                    }
                                                                } else if (i2 == 0) {
                                                                    if (obj2 != null) {
                                                                        dimensionPixelSize = i | 1;
                                                                    } else {
                                                                        dimensionPixelSize = i & -2;
                                                                    }
                                                                } else if (i2 == 1) {
                                                                    if (obj2 != null) {
                                                                        dimensionPixelSize = i | 2;
                                                                    } else {
                                                                        dimensionPixelSize = i & -3;
                                                                    }
                                                                } else if (i2 == 4) {
                                                                    if (obj2 != null) {
                                                                        dimensionPixelSize = i | 4;
                                                                    } else {
                                                                        dimensionPixelSize = i & -5;
                                                                    }
                                                                } else if (i2 == 6) {
                                                                    if (obj2 != null) {
                                                                        dimensionPixelSize = i | 16;
                                                                    } else {
                                                                        dimensionPixelSize = i & -17;
                                                                    }
                                                                } else if (i2 == 7) {
                                                                    if (obj2 != null) {
                                                                        dimensionPixelSize = i | 32;
                                                                    } else {
                                                                        dimensionPixelSize = i & -33;
                                                                    }
                                                                } else if (i2 == 8) {
                                                                    if (obj2 != null) {
                                                                        dimensionPixelSize = i | 64;
                                                                    } else {
                                                                        dimensionPixelSize = i & -65;
                                                                    }
                                                                } else if (i2 != 9) {
                                                                    replace = null;
                                                                    dimensionPixelSize = i;
                                                                } else if (obj2 != null) {
                                                                    dimensionPixelSize = i | 128;
                                                                } else {
                                                                    dimensionPixelSize = i & -129;
                                                                }
                                                                if (replace != null) {
                                                                    aw.ZK();
                                                                    com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_MUSIC_PLAYER_SWITCH_FLAG_INT_SYNC, Integer.valueOf(dimensionPixelSize));
                                                                }
                                                            }
                                                            AppMethodBeat.o(16100);
                                                            return true;
                                                        } else if (str.startsWith("//testdefaultrsa")) {
                                                            ab.i("MicroMsg.CommandProcessor", "summercert testdefaultrsa");
                                                            split = str.split(" ");
                                                            booleanValue = split != null && split.length > 1;
                                                            z.O("", "", 0);
                                                            com.tencent.mm.network.e Rk = com.tencent.mm.kernel.g.RO().Rg().Rk();
                                                            if (Rk == null) {
                                                                ab.w("MicroMsg.CommandProcessor", "summercert testdefaultrsa push not alive");
                                                                AppMethodBeat.o(16100);
                                                                return false;
                                                            }
                                                            new com.tencent.mm.modelsimple.q("", "", "", 0).ajl().a(Rk, new com.tencent.mm.ai.f() {
                                                                public final void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
                                                                    AppMethodBeat.i(16086);
                                                                    ab.i("MicroMsg.CommandProcessor", "summercert testdefaultrsa NetSceneManualAuth onSceneEnd [%d, %d, %s]", Integer.valueOf(i), Integer.valueOf(i2), str);
                                                                    if (i != 4 || i2 == ZipJNI.UNZ_PARAMERROR || booleanValue) {
                                                                        new com.tencent.mm.modelsimple.i().a(com.tencent.mm.kernel.g.RO().eJo.ftA, new com.tencent.mm.ai.f() {
                                                                            public final void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
                                                                                AppMethodBeat.i(16085);
                                                                                ab.i("MicroMsg.CommandProcessor", "summercert testdefaultrsa  NetSceneGetCert onSceneEnd [%d, %d, %s]", Integer.valueOf(i), Integer.valueOf(i2), str);
                                                                                if (i == 4 && i2 == ZipJNI.UNZ_PARAMERROR) {
                                                                                    al.d(new Runnable() {
                                                                                        public final void run() {
                                                                                            AppMethodBeat.i(16084);
                                                                                            b.D(context, "RSA(base) fatal err, must recheck!!!");
                                                                                            AppMethodBeat.o(16084);
                                                                                        }
                                                                                    });
                                                                                    AppMethodBeat.o(16085);
                                                                                    return;
                                                                                }
                                                                                Toast.makeText(context, "DefaultRSA check pass", 0).show();
                                                                                b.D(context, "");
                                                                                AppMethodBeat.o(16085);
                                                                            }
                                                                        });
                                                                        AppMethodBeat.o(16086);
                                                                        return;
                                                                    }
                                                                    al.d(new Runnable() {
                                                                        public final void run() {
                                                                            AppMethodBeat.i(16083);
                                                                            b.D(context, "RSA(req) fatal err, must recheck!!!");
                                                                            AppMethodBeat.o(16083);
                                                                        }
                                                                    });
                                                                    AppMethodBeat.o(16086);
                                                                }
                                                            });
                                                            AppMethodBeat.o(16100);
                                                            return true;
                                                        } else if (str.startsWith("//dumpdefaultrsa")) {
                                                            booleanValue = C(context, "");
                                                            AppMethodBeat.o(16100);
                                                            return booleanValue;
                                                        } else if (str.startsWith("//hardwareinfo")) {
                                                            ((com.tencent.mm.plugin.hardwareopt.a.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.hardwareopt.a.a.a.class)).hX(true);
                                                            AppMethodBeat.o(16100);
                                                            return true;
                                                        } else if (str.startsWith("//showStringName")) {
                                                            doB = ah.doB();
                                                            doB.edit().putBoolean("ShowStringName", !doB.getBoolean("ShowStringName", false)).commit();
                                                            AppMethodBeat.o(16100);
                                                            return true;
                                                        } else if (str.startsWith("//mmphotoedit")) {
                                                            com.tencent.mm.bp.d.b(context, "mmsight", ".ui.TestVideoEditUI", new Intent());
                                                            AppMethodBeat.o(16100);
                                                            return true;
                                                        } else if (str.startsWith("//msgDelay")) {
                                                            com.tencent.mm.ui.conversation.a.n.ic(context);
                                                            AppMethodBeat.o(16100);
                                                            return true;
                                                        } else if (str.startsWith("//cpDelayedMsg")) {
                                                            com.tencent.mm.ui.conversation.a.n.id(context);
                                                            AppMethodBeat.o(16100);
                                                            return true;
                                                        } else if (str.startsWith("//testhce")) {
                                                            com.tencent.mm.bp.d.H(context, "nfc", ".ui.HceTestUI");
                                                            AppMethodBeat.o(16100);
                                                            return true;
                                                        } else if (str.startsWith("//debugbigimg")) {
                                                            split = str.split(" ");
                                                            if (split.length == 2) {
                                                                if (split[1].equals("1")) {
                                                                    ah.doB().edit().putBoolean("debug_big_img", true).apply();
                                                                } else {
                                                                    ah.doB().edit().putBoolean("debug_big_img", false).apply();
                                                                }
                                                            }
                                                            AppMethodBeat.o(16100);
                                                            return true;
                                                        } else if (str.startsWith("//testservice ")) {
                                                            str32 = str.replace("//testservice ", "");
                                                            edit = context.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
                                                            str4 = "forceTrigger";
                                                            booleanValue = str32 != null && str32.equals("1");
                                                            edit.putBoolean(str4, booleanValue).commit();
                                                            AppMethodBeat.o(16100);
                                                            return true;
                                                        } else if (str.startsWith("//openDetect")) {
                                                            ah.getContext().getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.h.Mu()).edit().putBoolean("msg_delay_close_detect", false).apply();
                                                            AppMethodBeat.o(16100);
                                                            return true;
                                                        } else if (str.startsWith("//closeDetect")) {
                                                            ah.getContext().getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.h.Mu()).edit().putBoolean("msg_delay_close_detect", true).apply();
                                                            AppMethodBeat.o(16100);
                                                            return true;
                                                        } else if (str.startsWith("//snsimage")) {
                                                            try {
                                                                intValue = bo.getInt(str.replace("//snsimage ", ""), 0);
                                                                com.tencent.mm.al.f.afx().lh(intValue);
                                                                Toast.makeText(ah.getContext(), intValue > 0 ? "tcp sns image download" : "http sns image download", 0).show();
                                                            } catch (Exception e15222222) {
                                                                ab.printErrStackTrace("MicroMsg.CommandProcessor", e15222222, "", new Object[0]);
                                                                Toast.makeText(ah.getContext(), "set snsimage fail, please ensure your command.", 1).show();
                                                            }
                                                            AppMethodBeat.o(16100);
                                                            return true;
                                                        } else if (str.startsWith("//groupdownload")) {
                                                            try {
                                                                intValue = bo.getInt(str.replace("//groupdownload ", ""), 0);
                                                                aq.ruA = intValue;
                                                                Toast.makeText(ah.getContext(), 1 == intValue ? "enable" : "disable", 0).show();
                                                            } catch (Exception e152222222) {
                                                                ab.printErrStackTrace("MicroMsg.CommandProcessor", e152222222, "", new Object[0]);
                                                                Toast.makeText(ah.getContext(), "set groupdownload fail, please ensure your command.", 1).show();
                                                            }
                                                            AppMethodBeat.o(16100);
                                                            return true;
                                                        } else if (str.startsWith("//resetWeishi")) {
                                                            com.tencent.mm.kernel.g.RP().Ry().set(ac.a.USERINFO_WEISHI_EXPOSE_COUNT_INT_SYNC, Integer.valueOf(0));
                                                            AppMethodBeat.o(16100);
                                                            return true;
                                                        } else if (str.startsWith("//clearWxWebCacheAndCookie")) {
                                                            intent = new Intent();
                                                            intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
                                                            intent.putExtra("tools_clean_webview_cache_ignore_cookie", true);
                                                            com.tencent.mm.cj.c.aZ(intent);
                                                            AppMethodBeat.o(16100);
                                                            return true;
                                                        } else if (str.startsWith("//destroyPreloadGameWebCore")) {
                                                            com.tencent.mm.plugin.game.luggage.d.destroy();
                                                            AppMethodBeat.o(16100);
                                                            return true;
                                                        } else {
                                                            if (str.startsWith("//ecdhml ")) {
                                                                try {
                                                                    intValue = bo.getInt(str.replace("//ecdhml ", ""), 0);
                                                                    if (intValue > 0 && intValue < 5) {
                                                                        sharedPreferences = ah.getContext().getSharedPreferences("auth_info_key_prefs", com.tencent.mm.compatible.util.h.Mu());
                                                                        if (intValue < 3) {
                                                                            sharedPreferences.edit().putBoolean("auth_info_prefs_use_new_ecdh", intValue == 1).commit();
                                                                            z = sharedPreferences.getBoolean("auth_info_prefs_use_new_ecdh", true);
                                                                            t.makeText(context, "reset ecdh mode " + (com.tencent.mm.protocal.f.vxx ? "enable" : "disable") + " to " + (z ? "enable" : "disable"), 0).show();
                                                                            ab.i("MicroMsg.CommandProcessor", "summerauths reset ecdh ".concat(String.valueOf(z)));
                                                                        } else {
                                                                            sharedPreferences.edit().putBoolean("auth_info_prefs_use_net_ml_cert", intValue == 3).commit();
                                                                            z = sharedPreferences.getBoolean("auth_info_prefs_use_new_ecdh", false);
                                                                            stringBuilder2 = new StringBuilder("reset ecdh ml mode ").append(com.tencent.mm.protocal.f.vxy ? "enable" : "disable").append(" to ");
                                                                            if (z) {
                                                                                str32 = "enable";
                                                                            } else {
                                                                                str32 = "disable";
                                                                            }
                                                                            t.makeText(context, stringBuilder2.append(str32).toString(), 0).show();
                                                                            ab.i("MicroMsg.CommandProcessor", "summerauths reset ecdh ml".concat(String.valueOf(z)));
                                                                        }
                                                                        AppMethodBeat.o(16100);
                                                                        return true;
                                                                    }
                                                                } catch (Exception e22) {
                                                                }
                                                            }
                                                            if (str.startsWith("//storyPostThreshold ")) {
                                                                intValue = 0;
                                                                try {
                                                                    intValue = Integer.valueOf(str.substring(21)).intValue();
                                                                } catch (NumberFormatException e23) {
                                                                    ab.b("MicroMsg.CommandProcessor", "NumberFormatException", new Object[0]);
                                                                }
                                                                com.tencent.mm.kernel.g.RP().Ry().set(ac.a.USERINFO_STORY_ONE_DAY_POST_COUNT_INT_SYNC, Integer.valueOf(intValue));
                                                                AppMethodBeat.o(16100);
                                                                return true;
                                                            } else if (str.startsWith("//newyearhb")) {
                                                                LuckyMoneyNewYearSendUI.ogj = 1;
                                                                try {
                                                                    LuckyMoneyNewYearSendUI.mState = Integer.valueOf(str.substring(11)).intValue();
                                                                } catch (NumberFormatException e24) {
                                                                }
                                                                AppMethodBeat.o(16100);
                                                                return true;
                                                            } else if (str.startsWith("//hbemojisw")) {
                                                                aw.ZK();
                                                                intValue = ((Integer) com.tencent.mm.model.c.Ry().get(ac.a.USERINFO_LUCKY_MONEY_HONGBAO_LOCAL_SWITCH_INT, Integer.valueOf(0))).intValue() ^ 1;
                                                                aw.ZK();
                                                                com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_LUCKY_MONEY_HONGBAO_LOCAL_SWITCH_INT, Integer.valueOf(intValue));
                                                                AppMethodBeat.o(16100);
                                                                return true;
                                                            } else if (str.startsWith("//addbywework")) {
                                                                aw.ZK();
                                                                intValue = ((Integer) com.tencent.mm.model.c.Ry().get(ac.a.USERINFO_ADD_CONTACT_BY_WEWORK_SWITCH_INT, Integer.valueOf(0))).intValue() ^ 1;
                                                                aw.ZK();
                                                                com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_ADD_CONTACT_BY_WEWORK_SWITCH_INT, Integer.valueOf(intValue));
                                                                AppMethodBeat.o(16100);
                                                                return true;
                                                            } else if (str.startsWith("//enableDyBg ")) {
                                                                split = str.split(" ");
                                                                if (split.length == 2) {
                                                                    if (split[1].equals("1")) {
                                                                        ah.doB().edit().putBoolean("enable_dynamic_bg", true).apply();
                                                                    } else {
                                                                        ah.doB().edit().putBoolean("enable_dynamic_bg", false).apply();
                                                                    }
                                                                }
                                                                AppMethodBeat.o(16100);
                                                                return true;
                                                            } else if (str.startsWith("//setbgfps ")) {
                                                                split = str.split(" ");
                                                                if (split.length == 2) {
                                                                    intValue = Integer.valueOf(split[1]).intValue();
                                                                    if (intValue > 0 && intValue <= 50) {
                                                                        ah.doB().edit().putInt("dynamic_bg_fps", intValue).apply();
                                                                    }
                                                                }
                                                                AppMethodBeat.o(16100);
                                                                return true;
                                                            } else if (str.startsWith("//offvoicesw")) {
                                                                com.tencent.mm.plugin.collect.model.voice.a.kCR = !com.tencent.mm.plugin.collect.model.voice.a.kCR;
                                                                ab.d("MicroMsg.CommandProcessor", "F2fRcvVoiceOffLineLogic.OFF_LINE:%s", Boolean.valueOf(com.tencent.mm.plugin.collect.model.voice.a.kCR));
                                                                AppMethodBeat.o(16100);
                                                                return true;
                                                            } else if (str.startsWith("//setoffvoicespeed")) {
                                                                try {
                                                                    com.tencent.mm.plugin.collect.model.voice.a.bgJ().setSpeed(bo.getFloat(str.substring(18), com.tencent.mm.plugin.collect.model.voice.a.kCS));
                                                                    ab.d("MicroMsg.CommandProcessor", "F2fRcvVoiceOffLineLogic.OFF_LINE_SPEED:%s", Float.valueOf(com.tencent.mm.plugin.collect.model.voice.a.kCS));
                                                                } catch (NumberFormatException e25) {
                                                                }
                                                                AppMethodBeat.o(16100);
                                                                return true;
                                                            } else if (str.startsWith("//setoffvoicevolume")) {
                                                                try {
                                                                    com.tencent.mm.plugin.collect.model.voice.a.bgJ().setVolume(bo.getFloat(str.substring(19), com.tencent.mm.plugin.collect.model.voice.a.kCT));
                                                                    ab.d("MicroMsg.CommandProcessor", "F2fRcvVoiceOffLineLogic.OFF_LINE_VOLUME:%s", Float.valueOf(com.tencent.mm.plugin.collect.model.voice.a.kCT));
                                                                } catch (NumberFormatException e26) {
                                                                }
                                                                AppMethodBeat.o(16100);
                                                                return true;
                                                            } else {
                                                                ab.d("MicroMsg.CommandProcessor", "processed : in ret:[%d]", Integer.valueOf(kK(str)));
                                                                switch (kK(str)) {
                                                                    case 0:
                                                                        AppMethodBeat.o(16100);
                                                                        return false;
                                                                    case 568:
                                                                        Assert.assertTrue("test errlog", false);
                                                                        AppMethodBeat.o(16100);
                                                                        return true;
                                                                    case 569:
                                                                        aw.ZK().Yj();
                                                                        AppMethodBeat.o(16100);
                                                                        return true;
                                                                    case 570:
                                                                        if (bs.apW(kL(str))) {
                                                                            Toast.makeText(context, R.string.f4g, 0).show();
                                                                        }
                                                                        AppMethodBeat.o(16100);
                                                                        return true;
                                                                    case 571:
                                                                        replace = kL(str);
                                                                        aw.ZK();
                                                                        com.tencent.mm.model.c.Ry().set(8195, replace);
                                                                        AppMethodBeat.o(16100);
                                                                        return true;
                                                                    case 572:
                                                                        com.tencent.mm.sdk.platformtools.g.cdh = Integer.valueOf(kL(str)).intValue();
                                                                        AppMethodBeat.o(16100);
                                                                        return true;
                                                                    case 574:
                                                                        StringBuilder append = new StringBuilder().append(q.LK());
                                                                        aw.ZK();
                                                                        com.tencent.mm.ui.base.h.J(context, com.tencent.mm.a.g.x(append.append(com.tencent.mm.model.c.QF()).toString().getBytes()), "md5");
                                                                        AppMethodBeat.o(16100);
                                                                        return true;
                                                                    case com.tencent.mm.plugin.appbrand.jsapi.k.ad.CTRL_INDEX /*579*/:
                                                                        ao.a.Zu().ai(kL(str), "");
                                                                        AppMethodBeat.o(16100);
                                                                        return true;
                                                                    case 580:
                                                                        aw.Rg().d(new bk(new bk.a() {
                                                                            public final void a(com.tencent.mm.network.e eVar) {
                                                                                AppMethodBeat.i(16087);
                                                                                if (eVar == null) {
                                                                                    AppMethodBeat.o(16087);
                                                                                    return;
                                                                                }
                                                                                com.tencent.mm.network.c adg = eVar.adg();
                                                                                byte[] bArr = new byte[0];
                                                                                byte[] bArr2 = new byte[0];
                                                                                byte[] bArr3 = new byte[0];
                                                                                aw.ZK();
                                                                                adg.a(bArr, bArr2, bArr3, com.tencent.mm.model.c.QF());
                                                                                AppMethodBeat.o(16087);
                                                                            }
                                                                        }));
                                                                        AppMethodBeat.o(16100);
                                                                        return true;
                                                                    case 581:
                                                                        am.bYI().aiH(kL(str));
                                                                        AppMethodBeat.o(16100);
                                                                        return true;
                                                                    case com.tencent.mm.plugin.appbrand.jsapi.k.r.CTRL_INDEX /*582*/:
                                                                        str32 = kL(str);
                                                                        aw.ZK();
                                                                        aoO = com.tencent.mm.model.c.XM().aoO(str32);
                                                                        if (aoO == null || aoO.Oh() == 0) {
                                                                            AppMethodBeat.o(16100);
                                                                            return false;
                                                                        }
                                                                        aoO.NB();
                                                                        com.tencent.mm.model.t.u(aoO);
                                                                        AppMethodBeat.o(16100);
                                                                        return true;
                                                                    case 583:
                                                                        aw.ZK();
                                                                        AppMethodBeat.o(16100);
                                                                        return true;
                                                                    case com.tencent.mm.plugin.appbrand.jsapi.k.ae.CTRL_INDEX /*584*/:
                                                                    case com.tencent.mm.plugin.appbrand.game.e.a.CTRL_INDEX /*585*/:
                                                                        bh.oG(kL(str));
                                                                        AppMethodBeat.o(16100);
                                                                        return true;
                                                                    case 586:
                                                                        split = str.split(" ");
                                                                        if (split != null && split.length == 3) {
                                                                            com.tencent.mm.modelmulti.q.cu(bo.getInt(split[1], 0), bo.getInt(split[2], 0));
                                                                        }
                                                                        AppMethodBeat.o(16100);
                                                                        return true;
                                                                    case 587:
                                                                        com.tencent.mm.sdk.b.a.xxA.m(new co());
                                                                        AppMethodBeat.o(16100);
                                                                        return true;
                                                                    case 588:
                                                                        com.tencent.mm.vfs.e.tf("/sdcard/tencent/MicroMsg/back");
                                                                        aw.ZK();
                                                                        com.tencent.mm.vfs.e.is(com.tencent.mm.model.c.Rt(), "/sdcard/tencent/MicroMsg/back");
                                                                        AppMethodBeat.o(16100);
                                                                        return true;
                                                                    case v.CTRL_INDEX /*590*/:
                                                                        AppMethodBeat.o(16100);
                                                                        return true;
                                                                    case 591:
                                                                        try {
                                                                            split = str.split(" ");
                                                                            if (split != null && split.length > 1) {
                                                                                aw.ZK().Ym().n(br.z(split[0], "sysmsg"));
                                                                            }
                                                                        } catch (Exception e1522222222) {
                                                                            ab.printErrStackTrace("MicroMsg.CommandProcessor", e1522222222, "hy: error occured in commandProcessor", new Object[0]);
                                                                        }
                                                                        AppMethodBeat.o(16100);
                                                                        return true;
                                                                    default:
                                                                        AppMethodBeat.o(16100);
                                                                        return false;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static boolean C(Context context, String str) {
        AppMethodBeat.i(16101);
        StringBuffer stringBuffer = new StringBuffer();
        if (!bo.isNullOrNil(str)) {
            stringBuffer.append(str + "\n\n");
        }
        stringBuffer.append("Default RSA Info:\n");
        stringBuffer.append("ClientVersion: " + com.tencent.mm.sdk.platformtools.f.CLIENT_VERSION + IOUtils.LINE_SEPARATOR_UNIX);
        stringBuffer.append("BASE_RSA_PUBLIC_VERSION = 183\n");
        stringBuffer.append("BASE_RSA_PUBLIC_KEYN = AF64B69AA6F14D838E22F72BBAD6DCDBDC7B2262617C553968EFC0CF2E73FD1714597F9E6BDF1661113B2DC82FDB77286E35822A187380640F5C107DF86CF35FFA3811BDD7012C4C41F5803F644DEE7CF3F037F0BE239A2FBE99F4E002C636759B65BDE41ECF15E594CE28793623FEE039B0E6D3C14131B8AE7BE8C01DF4D03D31C6DCDC228A9A35F74FF4DBB51F8A4E57490965D1074871CE3DB450966A444CF1BE85005D5089752C13D074DAE0172E2BAD3717357A6B49E7A156A6A4EDCFB1BA70C6073431AD0BE0FBBC3C53DCF746663733298385EB5105CA17796A62DAF110380061B1ECF21E686F7467D4327EE6393D2F666C973EA4651AEC32FEC52885 len(512)\n");
        stringBuffer.append("BASE_RSA_PUBLIC_KEYE = 010001\n\n");
        stringBuffer.append("REQ_RSA_PUBLIC_VERSION = 184\n");
        stringBuffer.append("REQ_RSA_PUBLIC_KEYN = BB5FB9017F1CA20257A0384C7C87F568F618FA2697A7C12821FCEC3C97BA2509576944A67D4B4FA5A4B9FB4DB9DDB687FE3354B607E1FD0DE58E39F05B772F5E4976A6E83F6BE1DDD5F0D02A237B6CF5DD957B76EF9BF29B523EFA1041A87D3469590F473C9EC4B448034A3EC0C4B221B960F346FDCDA3BBF3CD984FBBDE97FAFE26FC317E4ACC653688F407E5BE93D41DE8981C113069A21329119F65578E0614957AFE0E0CF52A4A38A85CFD163424945C28CD181A3BEB198DF54303ED070C90419F1C31703C93448F1B381623EE6AED759A21865B5F612EBC9FD367AC4AD781D0E99DD4D7E68664989AF71E9A9342A38277018AA8672A465C8225CACD2CB9 len(512)\n");
        stringBuffer.append("REQ_RSA_PUBLIC_KEYE = 010001\n");
        ab.i("MicroMsg.CommandProcessor", "summercert dumpdefaultrsa " + stringBuffer.toString());
        if (com.tencent.mm.sdk.a.b.dnO()) {
            View textView = new TextView(context);
            textView.setText(stringBuffer.toString());
            textView.setGravity(19);
            textView.setTextSize(1, 10.0f);
            textView.setLayoutParams(new LayoutParams(-1, -2));
            textView.setTextColor(-16711936);
            textView.setTypeface(Typeface.MONOSPACE);
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.nj);
            textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            textView.setMovementMethod(ScrollingMovementMethod.getInstance());
            com.tencent.mm.ui.base.h.a(context, null, textView, null);
            if (z.dmz()) {
                Toast.makeText(context, "dump file:" + com.tencent.mm.compatible.util.e.eSn + "DefaultRSA.java", 1).show();
            }
            AppMethodBeat.o(16101);
            return true;
        }
        AppMethodBeat.o(16101);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00fa A:{SYNTHETIC, Splitter:B:31:0x00fa} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00e8 A:{SYNTHETIC, Splitter:B:22:0x00e8} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static StringBuilder jb(int i) {
        Throwable e;
        AppMethodBeat.i(16102);
        Date date = new Date(bo.anU() - (((long) i) * 86400000));
        String str = com.tencent.mm.compatible.util.e.eSo + "crash_" + new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(date) + ".txt";
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2;
        if (com.tencent.mm.vfs.e.ct(str)) {
            stringBuilder2 = new StringBuilder(" day -" + i + " no crash.");
            AppMethodBeat.o(16102);
            return stringBuilder2;
        }
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new com.tencent.mm.vfs.g(str));
            try {
                if (bo.isNullOrNil(bufferedReader.readLine())) {
                    bufferedReader.close();
                    stringBuilder2 = new StringBuilder("read day -" + i + "file failed");
                    try {
                        bufferedReader.close();
                    } catch (Exception e2) {
                    }
                    AppMethodBeat.o(16102);
                    return stringBuilder2;
                }
                while (true) {
                    str = bufferedReader.readLine();
                    if (str != null) {
                        stringBuilder.append(new String(Base64.decode(str.split("error_")[1], 0)).split("#accinfo.uin=")[1]);
                        stringBuilder.append("\n_____________________________________\n");
                    } else {
                        try {
                            break;
                        } catch (Exception e3) {
                        }
                    }
                }
                bufferedReader.close();
                AppMethodBeat.o(16102);
                return stringBuilder;
            } catch (Exception e4) {
                e = e4;
                try {
                    ab.printErrStackTrace("MicroMsg.CommandProcessor", e, "", new Object[0]);
                    if (bufferedReader != null) {
                    }
                    AppMethodBeat.o(16102);
                    return stringBuilder;
                } catch (Throwable th) {
                    e = th;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e5) {
                        }
                    }
                    AppMethodBeat.o(16102);
                    throw e;
                }
            }
        } catch (Exception e6) {
            e = e6;
            bufferedReader = null;
            ab.printErrStackTrace("MicroMsg.CommandProcessor", e, "", new Object[0]);
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e7) {
                }
            }
            AppMethodBeat.o(16102);
            return stringBuilder;
        } catch (Throwable th2) {
            e = th2;
            bufferedReader = null;
            if (bufferedReader != null) {
            }
            AppMethodBeat.o(16102);
            throw e;
        }
    }

    private static void jc(int i) {
        AppMethodBeat.i(16103);
        SharedPreferences s = ar.s(ah.getContext(), "sp_sns_dynswitch_stg", 4);
        switch (i) {
            case -1:
                s.edit().remove("st_sw_use_vcodec_img").commit();
                AppMethodBeat.o(16103);
                return;
            case 0:
                s.edit().putBoolean("st_sw_use_vcodec_img", false).commit();
                AppMethodBeat.o(16103);
                return;
            case 1:
                s.edit().putBoolean("st_sw_use_vcodec_img", true).commit();
                AppMethodBeat.o(16103);
                return;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Bad op parameter: ".concat(String.valueOf(i)));
                AppMethodBeat.o(16103);
                throw illegalArgumentException;
        }
    }

    private static void jd(int i) {
        AppMethodBeat.i(16104);
        SharedPreferences s = ar.s(ah.getContext(), "sp_sns_dynswitch_stg", 4);
        switch (i) {
            case -1:
                s.edit().remove("st_sw_use_wxpc_img").commit();
                AppMethodBeat.o(16104);
                return;
            case 0:
                s.edit().putBoolean("st_sw_use_wxpc_img", false).commit();
                AppMethodBeat.o(16104);
                return;
            case 1:
                s.edit().putBoolean("st_sw_use_wxpc_img", true).commit();
                AppMethodBeat.o(16104);
                return;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Bad op parameter: ".concat(String.valueOf(i)));
                AppMethodBeat.o(16104);
                throw illegalArgumentException;
        }
    }
}
