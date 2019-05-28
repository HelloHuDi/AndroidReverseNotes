package com.tencent.mm.storage.emotion;

import android.database.Cursor;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.g;
import com.tencent.mm.protocal.protobuf.aia;
import com.tencent.mm.protocal.protobuf.aic;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;

public final class h extends j<g> implements com.tencent.mm.cd.g.a {
    public static final String[] fnj = new String[]{j.a(g.ccO, "EmotionDesignerInfo")};
    public e bSd;

    public enum a {
        DesignerSimpleInfo(0),
        PersonalDesigner(1),
        DesignerEmojiList(2);
        
        public int value;

        static {
            AppMethodBeat.o(62852);
        }

        private a(int i) {
            this.value = i;
        }
    }

    static {
        AppMethodBeat.i(62855);
        AppMethodBeat.o(62855);
    }

    public h(e eVar) {
        super(eVar, g.ccO, "EmotionDesignerInfo", null);
        this.bSd = eVar;
    }

    public final int a(g gVar) {
        this.bSd = gVar;
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final aic aqn(String str) {
        Throwable e;
        AppMethodBeat.i(62853);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.emoji.EmotionDesignerInfo", "getDesignerSimpleInfoResponseByID failed. Designer ID is null.");
            AppMethodBeat.o(62853);
            return null;
        }
        aic aic;
        Cursor a;
        try {
            a = this.bSd.a("EmotionDesignerInfo", new String[]{b.CONTENT}, "designerIDAndType=? ", new String[]{str + a.DesignerSimpleInfo.value}, null, null, null, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        aic = new aic();
                        aic.parseFrom(a.getBlob(0));
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.o(62853);
                        return aic;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        ab.e("MicroMsg.emoji.EmotionDesignerInfo", "exception:%s", bo.l(e));
                        if (a != null) {
                            a.close();
                            aic = null;
                        } else {
                            aic = null;
                        }
                        AppMethodBeat.o(62853);
                        return aic;
                    } catch (Throwable th) {
                        e = th;
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.o(62853);
                        throw e;
                    }
                }
            }
            aic = null;
            if (a != null) {
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
        } catch (Throwable th2) {
            e = th2;
            a = null;
            if (a != null) {
            }
            AppMethodBeat.o(62853);
            throw e;
        }
        AppMethodBeat.o(62853);
        return aic;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final aia aqo(String str) {
        Throwable e;
        AppMethodBeat.i(62854);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.emoji.EmotionDesignerInfo", "getDesignerEmojiListResponseByUIN failed. Designer UIN is null.");
            AppMethodBeat.o(62854);
            return null;
        }
        aia aia;
        Cursor a;
        try {
            a = this.bSd.a("EmotionDesignerInfo", new String[]{b.CONTENT}, "designerIDAndType=? ", new String[]{str + a.DesignerEmojiList.value}, null, null, null, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        aia = new aia();
                        aia.parseFrom(a.getBlob(0));
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.o(62854);
                        return aia;
                    }
                } catch (IOException e2) {
                    e = e2;
                    try {
                        ab.e("MicroMsg.emoji.EmotionDesignerInfo", "exception:%s", bo.l(e));
                        if (a != null) {
                            a.close();
                            aia = null;
                        } else {
                            aia = null;
                        }
                        AppMethodBeat.o(62854);
                        return aia;
                    } catch (Throwable th) {
                        e = th;
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.o(62854);
                        throw e;
                    }
                }
            }
            aia = null;
            if (a != null) {
            }
        } catch (IOException e3) {
            e = e3;
            a = null;
        } catch (Throwable th2) {
            e = th2;
            a = null;
            if (a != null) {
            }
            AppMethodBeat.o(62854);
            throw e;
        }
        AppMethodBeat.o(62854);
        return aia;
    }
}
