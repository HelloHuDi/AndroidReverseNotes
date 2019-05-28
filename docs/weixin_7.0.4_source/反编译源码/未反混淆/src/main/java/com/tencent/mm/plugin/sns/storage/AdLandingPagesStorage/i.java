package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.c.c;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.smtt.sdk.WebView;
import com.tencent.ttpic.wav.WavFileHeader;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public final class i {
    public static int rem = 750;
    public static int ren = 10;
    private static Set<a> reo = null;

    static class a {
        int rep;
        int req;
        int rer;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (aVar.rep == this.rep && aVar.req == this.req && aVar.rer == this.rer) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return (this.rep + this.req) + this.rer;
        }

        public final String toString() {
            AppMethodBeat.i(37732);
            String str = "[nodeType=" + this.rep + ",compType=" + this.req + ",subCompType=" + this.rer + "]";
            AppMethodBeat.o(37732);
            return str;
        }
    }

    public static boolean Dz(int i) {
        if (i == 101 || i == 103 || i == 104 || i == 105) {
            return true;
        }
        return false;
    }

    public static boolean DA(int i) {
        if (i == 101) {
            return true;
        }
        return false;
    }

    public static boolean DB(int i) {
        if (i == 103) {
            return true;
        }
        return false;
    }

    public static boolean DC(int i) {
        if (i == 104) {
            return true;
        }
        return false;
    }

    public static boolean DD(int i) {
        if (i == 105) {
            return true;
        }
        return false;
    }

    public static float a(double d, int i, int i2, int i3) {
        AppMethodBeat.i(37733);
        float f;
        if (i == 0) {
            f = (float) d;
            AppMethodBeat.o(37733);
            return f;
        } else if (i2 == 0) {
            f = (float) d;
            AppMethodBeat.o(37733);
            return f;
        } else {
            f = (float) ad.aY((((float) ad.eP(ah.getContext())[0]) * (((float) d) * ((float) i3))) / ((float) i2));
            AppMethodBeat.o(37733);
            return f;
        }
    }

    private static r a(Map<String, String> map, String str, int i, int i2, int i3, int i4) {
        r rVar;
        AppMethodBeat.i(37734);
        int ank = bo.ank((String) map.get(str + ".type"));
        int ank2 = bo.ank((String) map.get(str + ".subType"));
        r uVar;
        double anm;
        double anm2;
        int ank3;
        String str2;
        String str3;
        String str4;
        int i5;
        CharSequence charSequence;
        String charSequence2;
        String nullAsNil;
        int ank4;
        w wVar;
        switch (ank) {
            case 1:
                uVar = new u();
                uVar.qWP = ank;
                uVar.cuu = ank2;
                uVar.qXk = bo.bc((String) map.get(str + ".content"), "");
                uVar.textAlignment = bo.ank((String) map.get(str + ".textAlignment"));
                uVar.oxN = bo.bc((String) map.get(str + ".fontColor"), "");
                uVar.eOg = a(bo.anm((String) map.get(str + ".fontSize")), i, i2, i3);
                uVar.qXl = (bo.ank((String) map.get(new StringBuilder().append(str).append(".showType").toString())) & u.qXf) > 0;
                uVar.qXm = (bo.ank((String) map.get(new StringBuilder().append(str).append(".showType").toString())) & u.qXg) > 0;
                uVar.qXn = (bo.ank((String) map.get(new StringBuilder().append(str).append(".showType").toString())) & u.qXh) > 0;
                uVar.maxLines = bo.ank((String) map.get(str + ".maxLines"));
                uVar.qWp = bo.ank((String) map.get(str + ".fontType"));
                uVar.qXo = bo.ann((String) map.get(str + ".lineSpace"));
                rVar = uVar;
                break;
            case 21:
                r bVar;
                if (ank2 == 2) {
                    bVar = new b();
                    bVar.csB = (String) map.get(str + ".appid");
                    bVar.qVZ = (String) map.get(str + ".appPageUrlAndroid");
                    bVar.channelId = (String) map.get(str + ".channelId");
                    bVar.Iw = (String) map.get(str + ".pkg");
                    bVar.qVO = bo.ank((String) map.get(str + ".platform"));
                    bVar.qVP = (String) map.get(str + ".warningAndroid");
                    bVar.qVQ = (String) map.get(str + ".btnBgColorTheme");
                    bVar.qVS = (String) map.get(str + ".btnBgColorThemePressed");
                    bVar.qVR = (String) map.get(str + ".btnBgColorThemeDisable");
                    bVar.qVT = (String) map.get(str + ".btnBorderColorTheme");
                    bVar.qVV = (String) map.get(str + ".btnBorderColorThemePressed");
                    bVar.qVU = (String) map.get(str + ".btnBorderColorThemeDisable");
                    bVar.qVW = (String) map.get(str + ".fontColor");
                    bVar.qVY = (String) map.get(str + ".fontColorPressed");
                    bVar.qVX = (String) map.get(str + ".fontColorDisable");
                    uVar = bVar;
                } else if (ank2 == 4) {
                    bVar = new e();
                    bVar.kcM = bo.bc((String) map.get(str + ".cardTpId"), "");
                    bVar.kdB = bo.bc((String) map.get(str + ".cardExt"), "");
                    uVar = bVar;
                } else if (ank2 == 7) {
                    bVar = new j();
                    bVar.qWf = bo.bc((String) map.get(str + ".jumpCanvasId"), "");
                    bVar.qWg = bo.bc((String) map.get(str + ".jumpCanvasExt"), "");
                    bVar.qWh = bo.ank((String) map.get(str + ".jumpCanvasNoStore"));
                    bVar.qWi = bo.ank((String) map.get(str + ".btnCanvasEnterType"));
                    bVar.qWj = bo.ank((String) map.get(str + ".btnCanvasSource"));
                    uVar = bVar;
                } else if (ank2 == 8) {
                    bVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i();
                    bVar.username = (String) map.get(str + ".weappUserName");
                    bVar.cOh = (String) map.get(str + ".weappPath");
                    uVar = bVar;
                } else if (ank2 == 9) {
                    anm = bo.anm((String) map.get(str + ".location.$x"));
                    anm2 = bo.anm((String) map.get(str + ".location.$y"));
                    ank3 = bo.ank((String) map.get(str + ".location.$scale"));
                    str2 = (String) map.get(str + ".location.$label");
                    str3 = (String) map.get(str + ".location.$poiname");
                    if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
                        AppMethodBeat.o(37734);
                        return null;
                    }
                    uVar = new f(new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f.a(anm, anm2, ank3, str2, str3));
                } else if (ank2 == 10) {
                    str4 = str + ".phoneNumList.phoneNum";
                    ArrayList arrayList = new ArrayList();
                    i5 = 0;
                    while (true) {
                        if (i5 == 0) {
                            charSequence2 = (String) map.get(str4);
                        } else {
                            charSequence2 = (String) map.get(str4 + i5);
                        }
                        if (!TextUtils.isEmpty(charSequence2)) {
                            arrayList.add(charSequence2);
                            i5++;
                        } else if (arrayList.isEmpty()) {
                            AppMethodBeat.o(37734);
                            return null;
                        } else {
                            uVar = new h(arrayList);
                        }
                    }
                } else {
                    uVar = new k();
                }
                uVar.qWP = ank;
                uVar.cuu = ank2;
                uVar.title = bo.bc((String) map.get(str + ".btnTitle"), "");
                uVar.qWk = bo.ank((String) map.get(str + ".btnType"));
                uVar.qWl = bo.bc((String) map.get(str + ".btnJumpUrl"), "");
                uVar.qWm = bo.bc((String) map.get(str + ".btnJumpApp"), "");
                uVar.qWn = bo.bc((String) map.get(str + ".fontColor"), "");
                uVar.fontSize = a(bo.anm((String) map.get(str + ".fontSize")), i, i2, i3);
                uVar.qWp = bo.ank((String) map.get(str + ".btnFontType"));
                uVar.textAlignment = bo.ank((String) map.get(str + ".btnAlignment"));
                uVar.qWo = a(bo.anm((String) map.get(str + ".borderSize")), i, i2, i3);
                uVar.height = a(bo.anm((String) map.get(str + ".btnHeight")), i, i2, i3);
                uVar.qWq = bo.bc((String) map.get(str + ".btnBgColorTheme"), "");
                uVar.qWr = bo.bc((String) map.get(str + ".btnBorderColorTheme"), "");
                uVar.qWs = bo.bc((String) map.get(str + ".btnBgImgUrl"), "");
                uVar.qWt = bo.ank((String) map.get(str + ".bCanLongPress"));
                uVar.qWu = bo.ank((String) map.get(str + ".bHideActionSheet"));
                uVar.qWv = bo.ank((String) map.get(str + ".hideProductActionHeader"));
                uVar.qWw = bo.ank((String) map.get(str + ".showProductActionCancelButton"));
                uVar.qWy = bo.bc((String) map.get(str + ".productActionTitle"), "");
                uVar.qWx = bo.bc((String) map.get(str + ".productActionBuffer"), "");
                uVar.qWz = bo.bc((String) map.get(str + ".productActionIconUrl"), "");
                if (map.containsKey(str + ".productActionItem.componentItem.type")) {
                    uVar.qWA = a((Map) map, i, i2, i3, i4, str + ".productActionItem.componentItem");
                }
                rVar = uVar;
                break;
            case 41:
                uVar = new n();
                uVar.qWP = ank;
                uVar.cuu = ank2;
                uVar.qWD = bo.bc((String) map.get(str + ".pureImageUrl"), "");
                uVar.qWE = bo.bc((String) map.get(str + ".bgColor"), "");
                if (map.containsKey(str + ".bgColorAlpha") && uVar.qWE.length() > 0) {
                    Map<String, String> map2 = map;
                    uVar.qWE = String.format("#%02x%s", new Object[]{Integer.valueOf((int) (bo.anm((String) map2.get(str + ".bgColorAlpha")) * 255.0d)), uVar.qWE.substring(1)});
                }
                uVar.width = a(bo.anm((String) map.get(str + ".imageWidth")), i, i2, i3);
                uVar.height = a(bo.anm((String) map.get(str + ".imageHeight")), i, i2, i3);
                uVar.qWC = false;
                rVar = uVar;
                break;
            case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                uVar = new m();
                uVar.qWP = ank;
                uVar.cuu = ank2;
                uVar.qWD = bo.bc((String) map.get(str + ".panoramaImageUrl"), "");
                uVar.width = a(bo.anm((String) map.get(str + ".imageWidth")), i, i2, i3);
                uVar.height = a(bo.anm((String) map.get(str + ".imageHeight")), i, i2, i3);
                rVar = uVar;
                break;
            case IMediaObject.TYPE_BUSINESS_CARD /*45*/:
                uVar = new n();
                uVar.qWP = ank;
                uVar.cuu = ank2;
                uVar.qWD = bo.bc((String) map.get(str + ".fullScreenImageUrl"), "");
                uVar.qWC = true;
                rVar = uVar;
                break;
            case PlayerException.EXCEPTION_TYPE_INITLIB /*61*/:
                uVar = new o();
                uVar.qWP = ank;
                uVar.cuu = ank2;
                uVar.qWF = bo.bc((String) map.get(str + ".sightVideoUrl"), "");
                uVar.qWG = bo.bc((String) map.get(str + ".sightThumbUrl"), "");
                uVar.qWH = bo.bc((String) map.get(str + ".streamVideoUrl"), "");
                uVar.qWI = bo.bc((String) map.get(str + ".jumpText"), "");
                uVar.qWf = bo.bc((String) map.get(str + ".jumpCanvasId"), "");
                uVar.qWg = bo.bc((String) map.get(str + ".jumpCanvasExt"), "");
                uVar.qWh = bo.ank((String) map.get(str + ".jumpCanvasNoStore"));
                try {
                    uVar.qWJ = Color.parseColor((String) map.get(str + ".jumpTextColor"));
                } catch (Exception e) {
                    uVar.qWJ = Color.rgb(255, 255, 255);
                }
                try {
                    uVar.qWK = Color.parseColor((String) map.get(str + ".separatorColor"));
                } catch (Exception e2) {
                    uVar.qWK = Color.rgb(255, 255, 255);
                }
                uVar.width = a(bo.anm((String) map.get(str + ".sightDisplayWidth")), i, i2, i3);
                uVar.height = a(bo.anm((String) map.get(str + ".sightDisplayHeight")), i, i2, i3);
                uVar.qWL = bo.ank((String) map.get(str + ".sightDisplayType"));
                nullAsNil = bo.nullAsNil((String) map.get(str + ".floatComponentId"));
                ank4 = bo.ank((String) map.get(str + ".floatStartTime"));
                if (!bo.isNullOrNil(nullAsNil) && ank4 > 0) {
                    wVar = new w();
                    wVar.cHR = nullAsNil;
                    wVar.qXt = ank4;
                    uVar.qWM = wVar;
                }
                rVar = uVar;
                break;
            case 62:
                uVar = new z();
                uVar.qWP = ank;
                uVar.cuu = ank2;
                uVar.qWH = bo.bc((String) map.get(str + ".streamVideoUrl"), "");
                uVar.qXv = bo.bc((String) map.get(str + ".streamVideoThumb"), "");
                uVar.width = a(bo.anm((String) map.get(str + ".streamDisplayWidth")), i, i2, i3);
                uVar.height = a(bo.anm((String) map.get(str + ".streamDisplayHeight")), i, i2, i3);
                uVar.qXw = bo.ank((String) map.get(str + ".streamDisplayType"));
                nullAsNil = bo.nullAsNil((String) map.get(str + ".floatComponentId"));
                ank4 = bo.ank((String) map.get(str + ".floatStartTime"));
                if (!bo.isNullOrNil(nullAsNil) && ank4 > 0) {
                    wVar = new w();
                    wVar.cHR = nullAsNil;
                    wVar.qXt = ank4;
                    uVar.qWM = wVar;
                }
                rVar = uVar;
                break;
            case 81:
                uVar = new y();
                uVar.qWP = ank;
                uVar.cuu = ank2;
                uVar.nmz = bo.bc((String) map.get(str + ".webviewUrl"), "");
                rVar = uVar;
                break;
            case 82:
                uVar = new aa();
                uVar.url = bo.bc((String) map.get(str + ".webviewUrl"), "");
                rVar = uVar;
                break;
            case 102:
                rVar = c(map, str, i, i2, i3, i4);
                break;
            case 121:
            case 122:
                int argb;
                double a = (double) a(bo.anm((String) map.get(str + ".topLineSize")), i, i2, i3);
                double a2 = (double) a(bo.anm((String) map.get(str + ".bottomLineSize")), i, i2, i3);
                if (DE(i4)) {
                    argb = Color.argb(51, 0, 0, 0);
                } else {
                    argb = Color.argb(51, 255, 255, 255);
                }
                if (ank != 121) {
                    if (ank != 122) {
                        rVar = null;
                        break;
                    }
                    str4 = str + ".phoneNumList.phoneNum";
                    ArrayList arrayList2 = new ArrayList();
                    i5 = 0;
                    while (true) {
                        if (i5 == 0) {
                            charSequence2 = (String) map.get(str4);
                        } else {
                            charSequence2 = (String) map.get(str4 + i5);
                        }
                        if (!TextUtils.isEmpty(charSequence2)) {
                            arrayList2.add(charSequence2);
                            i5++;
                        } else if (!arrayList2.isEmpty()) {
                            rVar = new d(a, a2, argb, arrayList2);
                            break;
                        } else {
                            AppMethodBeat.o(37734);
                            return null;
                        }
                    }
                }
                anm = bo.anm((String) map.get(str + ".location.$x"));
                anm2 = bo.anm((String) map.get(str + ".location.$y"));
                ank3 = bo.ank((String) map.get(str + ".location.$scale"));
                str2 = (String) map.get(str + ".location.$label");
                str3 = (String) map.get(str + ".location.$poiname");
                if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
                    r gVar = new g(a, a2, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g.a(anm, anm2, ank3, str2, str3), argb);
                    break;
                }
                AppMethodBeat.o(37734);
                return null;
                break;
            case 131:
                uVar = new t();
                uVar.qWP = ank;
                uVar.cuu = ank2;
                uVar.label = bo.bc((String) map.get(str + ".label"), "");
                uVar.value = (float) bo.anm((String) map.get(str + ".value"));
                uVar.qXe = bo.bc((String) map.get(str + ".foregroundImage"), "");
                uVar.fontSize = a(bo.anm((String) map.get(str + ".fontSize")), i, i2, i3);
                uVar.hfo = bo.bc((String) map.get(str + ".backgroundColor"), "");
                rVar = uVar;
                break;
            case 132:
                rVar = a(map, str, i, i2, i3);
                break;
            default:
                AppMethodBeat.o(37734);
                return null;
        }
        if (rVar != null) {
            rVar.qWW = DE(i4);
            rVar.type = ank;
            rVar.cuu = ank2;
            a(rVar, (Map) map, str, i, i2, i3);
        }
        AppMethodBeat.o(37734);
        return rVar;
    }

    private static ab a(Map<String, String> map, String str, int i, int i2, int i3) {
        AppMethodBeat.i(37735);
        ab abVar = new ab();
        try {
            String str2 = str + ".radarChart";
            abVar.qXx = (String) map.get(str2 + ".borderImg");
            abVar.qXD = (String) map.get(str2 + ".maskImg");
            abVar.qXy = (String) map.get(str2 + ".coverColor");
            abVar.qXz = Color.parseColor((String) map.get(str2 + ".labelFont.$color"));
            abVar.qXA = (int) a(bo.anm((String) map.get(str2 + ".labelFont.$size")), i, i2, i3);
            abVar.qXB = Color.parseColor((String) map.get(str2 + ".scoreFont.$color"));
            abVar.qXC = (int) a(bo.anm((String) map.get(str2 + ".scoreFont.$size")), i, i2, i3);
            abVar.borderWidth = a(bo.anm((String) map.get(str2 + ".borderImgWidth")), i, i2, i3);
            String str3 = str2 + ".itemList.item";
            int i4 = 0;
            while (true) {
                if (i4 != 0) {
                    str2 = str3 + i4;
                } else {
                    str2 = str3;
                }
                com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab.a aVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab.a();
                aVar.label = (String) map.get(str2 + ".label");
                aVar.qXE = (String) map.get(str2 + ".score");
                aVar.value = (float) bo.anm((String) map.get(str2 + ".value"));
                if (TextUtils.isEmpty(aVar.label) && TextUtils.isEmpty(aVar.qXE)) {
                    break;
                }
                abVar.itemList.add(aVar);
                i4++;
            }
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.ab.e("AdLandingPagesParseHelper", bo.l(e));
        }
        AppMethodBeat.o(37735);
        return abVar;
    }

    private static List<r> b(Map<String, String> map, String str, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(37736);
        ArrayList arrayList = new ArrayList();
        String str2 = str + ".layoutItems.componentItem";
        int i5 = 0;
        while (true) {
            String str3;
            if (i5 == 0) {
                str3 = str2;
            } else {
                str3 = str2 + i5;
            }
            r a = a((Map) map, i, i2, i3, i4, str3);
            if (a != null) {
                if (a.qXa) {
                    arrayList.add(a);
                } else {
                    com.tencent.mm.sdk.platformtools.ab.i("AdLandingPagesParseHelper", "comp " + a.toString() + " ifCondition is false");
                }
                i5++;
            } else {
                AppMethodBeat.o(37736);
                return arrayList;
            }
        }
    }

    private static l c(Map<String, String> map, String str, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(37737);
        l lVar = new l();
        try {
            int parseColor = Color.parseColor((String) map.get(str + ".bgColorTheme"));
            lVar.backgroundColor = (((int) (bo.getDouble((String) map.get(str + ".bgColorAlpha"), 0.0d) * 255.0d)) << 24) | (parseColor & 16777215);
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.ab.e("AdLandingPagesParseHelper", "%s", bo.l(e));
            lVar.backgroundColor = Color.argb(51, 0, 0, 0);
        }
        String str2 = (str + ".componentGroupList") + ".componentItem";
        int i5 = 0;
        while (true) {
            String str3;
            if (i5 == 0) {
                str3 = str2;
            } else {
                str3 = str2 + i5;
            }
            r a = a((Map) map, i, i2, i3, i4, str3);
            if (a != null) {
                if (a.qXa) {
                    lVar.qWB.add(a);
                }
                i5++;
            } else {
                AppMethodBeat.o(37737);
                return lVar;
            }
        }
    }

    private static x d(Map<String, String> map, String str, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(37738);
        r xVar = new x();
        a(xVar, (Map) map, str, i, i2, i3);
        xVar.qXu = bo.ank((String) map.get(str + ".pageCtrType"));
        xVar.iXr = bo.ank((String) map.get(new StringBuilder().append(str).append(".isFullScreen").toString())) == 1;
        String str2 = str + ".componentGroupList.componentGroup";
        int i5 = 0;
        while (true) {
            String str3;
            if (i5 == 0) {
                str3 = str2;
            } else {
                str3 = str2 + i5;
            }
            l lVar = new l();
            String str4 = str3 + ".componentItem";
            int i6 = 0;
            while (true) {
                String str5;
                if (i6 == 0) {
                    str5 = str4;
                } else {
                    str5 = str4 + i6;
                }
                r a = a((Map) map, i, i2, i3, i4, str5);
                if (a == null) {
                    break;
                }
                if (a.qXa) {
                    lVar.qWB.add(a);
                }
                i6++;
            }
            if (lVar.qWB.size() != 0) {
                xVar.qWB.add(lVar);
                i5++;
            } else {
                AppMethodBeat.o(37738);
                return xVar;
            }
        }
    }

    private static void a(r rVar, Map<String, String> map, String str, int i, int i2, int i3) {
        boolean z = true;
        AppMethodBeat.i(37739);
        rVar.qWP = bo.ank((String) map.get(str + ".type"));
        rVar.type = rVar.qWP;
        rVar.qWO = bo.bc((String) map.get(str + ".id"), "");
        rVar.qWQ = a(bo.anm((String) map.get(str + ".paddingTop")), i, i2, i3);
        rVar.qWR = a(bo.anm((String) map.get(str + ".paddingBottom")), i, i2, i3);
        rVar.qWS = a(bo.anm((String) map.get(str + ".paddingLeft")), i, i2, i3);
        rVar.qWT = a(bo.anm((String) map.get(str + ".paddingRight")), i, i2, i3);
        rVar.cuu = bo.ank((String) map.get(str + ".subType"));
        rVar.qWX = bo.bc((String) map.get(str + ".cellBackgroundColor"), "");
        String str2 = str + ".if";
        if (map.containsKey(str2)) {
            rVar.qXa = "1".equals(map.get(str2));
        } else {
            rVar.qXa = true;
        }
        str2 = str + ".noReport";
        if (map.containsKey(str2)) {
            if (!"1".equals(map.get(str2))) {
                z = false;
            }
            rVar.qXb = z;
        } else {
            rVar.qXb = false;
        }
        String bc = bo.bc((String) map.get(str + ".layoutWidth"), "");
        str2 = bo.bc((String) map.get(str + ".layoutHeight"), "");
        if (TextUtils.isEmpty(bc)) {
            rVar.qWU = 2.14748365E9f;
        } else {
            double anm = bo.anm(bc);
            if (anm < 0.0d) {
                rVar.qWU = (float) anm;
            } else {
                rVar.qWU = a(anm, i, i2, i3);
            }
        }
        if (TextUtils.isEmpty(str2)) {
            rVar.qWV = 2.14748365E9f;
        } else {
            double anm2 = bo.anm(str2);
            if (anm2 < 0.0d) {
                rVar.qWV = (float) anm2;
            } else {
                rVar.qWV = a(anm2, i, i2, i3);
            }
        }
        str2 = (String) map.get(str + ".verticalAlignment");
        bc = (String) map.get(str + ".horizontalAlignment");
        if (TextUtils.isEmpty(str2)) {
            rVar.qWY = -1;
        } else {
            rVar.qWY = bo.ank(str2);
        }
        if (TextUtils.isEmpty(bc)) {
            rVar.qWZ = -1;
            AppMethodBeat.o(37739);
            return;
        }
        rVar.qWZ = bo.ank(bc);
        AppMethodBeat.o(37739);
    }

    private static r e(Map<String, String> map, String str, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(37740);
        r sVar = new s();
        sVar.qXd = bo.ank((String) map.get(str + ".subType"));
        a(sVar, (Map) map, str, i, i2, i3);
        String str2 = str + ".layoutItems.componentItem";
        int i5 = 0;
        while (true) {
            String str3;
            if (i5 == 0) {
                str3 = str2;
            } else {
                str3 = str2 + i5;
            }
            r a = a((Map) map, i, i2, i3, i4, str3);
            if (a != null) {
                if (a.qXa) {
                    sVar.qXc.add(a);
                }
                i5++;
            } else {
                AppMethodBeat.o(37740);
                return sVar;
            }
        }
    }

    private static r f(Map<String, String> map, String str, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(37741);
        List b = b(map, str, i, i2, i3, i4);
        r qVar = new q();
        qVar.bnR = b;
        a(qVar, (Map) map, str, i, i2, i3);
        String str2 = str + ".layoutItems.componentItem";
        int i5 = 0;
        while (true) {
            String str3;
            if (i5 == 0) {
                str3 = str2;
            } else {
                str3 = str2 + i5;
            }
            r a = a((Map) map, i, i2, i3, i4, str3);
            if (a != null) {
                if (a.qXa) {
                    qVar.bnR.add(a);
                }
                i5++;
            } else {
                AppMethodBeat.o(37741);
                return qVar;
            }
        }
    }

    private static r g(Map<String, String> map, String str, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(37742);
        List b = b(map, str, i, i2, i3, i4);
        r pVar = new p();
        pVar.qWN = com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), bo.ank((String) map.get(str + ".cornerRadius")));
        pVar.bnR = b;
        a(pVar, (Map) map, str, i, i2, i3);
        String str2 = str + ".layoutItems.componentItem";
        int i5 = 0;
        while (true) {
            String str3;
            if (i5 == 0) {
                str3 = str2;
            } else {
                str3 = str2 + i5;
            }
            r a = a((Map) map, i, i2, i3, i4, str3);
            if (a != null) {
                if (a.qXa) {
                    pVar.bnR.add(a);
                }
                i5++;
            } else {
                AppMethodBeat.o(37742);
                return pVar;
            }
        }
    }

    public static LinkedList<g> gn(String str, String str2) {
        AppMethodBeat.i(37743);
        LinkedList<g> linkedList = new LinkedList();
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(37743);
            return linkedList;
        }
        String str3 = "";
        if (!TextUtils.isEmpty(str)) {
            str = str.replaceAll("\\{\\{.*?\\}\\}", str3);
        }
        Map z = br.z(str, str2);
        if (z == null) {
            com.tencent.mm.sdk.platformtools.ab.w("AdLandingPagesParseHelper", " parse landingpages xml is error ,".concat(String.valueOf(str)));
            AppMethodBeat.o(37743);
            return linkedList;
        }
        String str4;
        int ank = bo.ank((String) z.get("." + str2 + ".adCanvasInfo.sizeType"));
        int ank2 = bo.ank((String) z.get("." + str2 + ".adCanvasInfo.basicRootFontSize"));
        int ank3 = bo.ank((String) z.get("." + str2 + ".adCanvasInfo.basicWidth"));
        if (ank2 == 0 && ank == 1) {
            ank2 = ren;
        }
        if (ank3 == 0 && ank == 1) {
            ank3 = rem;
        }
        String str5 = ".adCanvasInfo.PageList.Page";
        if (bo.isNullOrNil(str2) || str5.equals("adCanvasInfo")) {
            str4 = str5;
        } else {
            str4 = "." + str2 + str5;
        }
        int i = 0;
        while (true) {
            String str6;
            if (i == 0) {
                str6 = str4;
            } else {
                str6 = str4 + i;
            }
            g gVar = new g();
            gVar.reh = bo.bc((String) z.get(str6 + ".backgroundCover"), "");
            gVar.hfo = bo.bc((String) z.get(str6 + ".backgroundColor"), "");
            gVar.rei = bo.ank((String) z.get(new StringBuilder().append(str6).append(".backgroundCover.$isAddBlur").toString())) > 0;
            gVar.id = i;
            str5 = str6 + ".if";
            if (z.containsKey(str5)) {
                gVar.rel = "1".equals(z.get(str5));
            } else {
                gVar.rel = true;
            }
            if (gVar.rel) {
                String str7 = str6 + ".componentItemList.componentItem";
                int i2 = 0;
                while (true) {
                    r a;
                    if (i2 == 0) {
                        str6 = str7;
                    } else {
                        str6 = str7 + i2;
                    }
                    try {
                        a = a(z, ank, ank3, ank2, !TextUtils.isEmpty(gVar.hfo) ? Color.parseColor(gVar.hfo) : 0, str6);
                    } catch (Exception e) {
                        com.tencent.mm.sdk.platformtools.ab.e("AdLandingPagesParseHelper", bo.l(e));
                        a = a(z, ank, ank3, ank2, 0, str6);
                    }
                    if (a == null) {
                        break;
                    }
                    if (a.qXa) {
                        a(a, z, str6, ank, ank3, ank2);
                        if (a instanceof p) {
                            gVar.rek.put(a.qWO, a);
                        } else {
                            gVar.rej.add(a);
                        }
                    } else {
                        com.tencent.mm.sdk.platformtools.ab.i("AdLandingPagesParseHelper", "comp " + a.toString() + " ifCondition is false");
                    }
                    i2++;
                }
                if (gVar.rej.size() == 0) {
                    break;
                }
                linkedList.add(gVar);
            }
            i++;
        }
        if (linkedList.size() > 0) {
            ((g) linkedList.get(0)).mTL = true;
        }
        AppMethodBeat.o(37743);
        return linkedList;
    }

    private static r a(Map<String, String> map, int i, int i2, int i3, int i4, String str) {
        AppMethodBeat.i(37744);
        int ank = bo.ank((String) map.get(str + ".type"));
        r rVar = null;
        if (!Dz(ank)) {
            try {
                rVar = a((Map) map, str, i, i2, i3, i4);
            } catch (Exception e) {
                rVar = a((Map) map, str, i, i2, i3, 0);
            }
        } else if (DA(ank)) {
            rVar = d(map, str, i, i2, i3, i4);
        } else if (DB(ank)) {
            rVar = e(map, str, i, i2, i3, i4);
        } else if (DC(ank)) {
            rVar = f(map, str, i, i2, i3, i4);
        } else if (DD(ank)) {
            rVar = g(map, str, i, i2, i3, i4);
        } else {
            com.tencent.mm.sdk.platformtools.ab.e("AdLandingPagesParseHelper", "the type" + ank + " is not client known type");
        }
        AppMethodBeat.o(37744);
        return rVar;
    }

    public static LinkedList<g> ai(String str, String str2, String str3) {
        AppMethodBeat.i(37745);
        String str4 = new String(str);
        try {
            JSONObject jSONObject = new JSONObject(str3);
            com.tencent.mm.sdk.platformtools.ab.i("AdLandingPagesParseHelper", "the jsonObject is " + jSONObject.toString());
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str5;
                Object next = keys.next();
                if (next != null && (next instanceof String)) {
                    str5 = (String) next;
                    String string = jSONObject.getString(str5);
                    if (!bo.isNullOrNil(string)) {
                        str5 = str4.replace("{{" + str5 + "}}", "<![CDATA[" + string + "]]>");
                        str4 = str5;
                    }
                }
                str5 = str4;
                str4 = str5;
            }
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.ab.e("AdLandingPagesParseHelper", "the json is parsed error : ".concat(String.valueOf(str)));
        }
        LinkedList gn = gn(str4, str2);
        AppMethodBeat.o(37745);
        return gn;
    }

    private static boolean DE(int i) {
        int i2 = i | WebView.NIGHT_MODE_COLOR;
        return i2 - WebView.NIGHT_MODE_COLOR > -1 - i2;
    }

    private static boolean YN(String str) {
        AppMethodBeat.i(37746);
        if (bo.ank(bo.bc((String) br.z(str, "adCanvasInfo").get(".adCanvasInfo.bizId"), "")) == 1) {
            AppMethodBeat.o(37746);
            return true;
        }
        AppMethodBeat.o(37746);
        return false;
    }

    private static boolean b(String str, Context context, boolean z, int i) {
        AppMethodBeat.i(37747);
        String str2 = (String) br.z(str, "adCanvasInfo").get(".adCanvasInfo.shareWebUrl");
        if (TextUtils.isEmpty(str2)) {
            AppMethodBeat.o(37747);
            return false;
        }
        if (z) {
            try {
                str2 = m(str2, "exp=" + c.abj().getExpIdByKey("Sns_Canvas_GameShare_JumpWay") + "_" + i);
            } catch (URISyntaxException e) {
            }
            com.tencent.mm.sdk.platformtools.ab.i("AdLandingPagesParseHelper", "canvas jump url ".concat(String.valueOf(str2)));
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str2);
        intent.putExtra("showShare", true);
        com.tencent.mm.bp.d.b(context, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(37747);
        return true;
    }

    public static String m(String str, String... strArr) {
        AppMethodBeat.i(37748);
        URI uri = new URI(str);
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : strArr) {
            stringBuilder.append(append).append("&");
        }
        if (stringBuilder.length() > 1) {
            String stringBuilder2;
            StringBuilder deleteCharAt = stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            String query = uri.getQuery();
            if (query == null) {
                stringBuilder2 = deleteCharAt.toString();
            } else {
                stringBuilder2 = query + "&" + deleteCharAt.toString();
            }
            str = new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), stringBuilder2, uri.getFragment()).toString();
            AppMethodBeat.o(37748);
            return str;
        }
        AppMethodBeat.o(37748);
        return str;
    }

    public static String n(String str, String... strArr) {
        AppMethodBeat.i(37749);
        if (str == null) {
            str = "";
        }
        String join = TextUtils.join("&", strArr);
        String str2 = "?";
        if (str.contains("?")) {
            str2 = "&";
        }
        if (str.contains("#")) {
            try {
                int indexOf = str.indexOf("#");
                String substring = str.substring(0, indexOf);
                str = substring + str2 + join + str.substring(indexOf + 1);
                AppMethodBeat.o(37749);
                return str;
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.ab.e("AdLandingPagesParseHelper", "append url params failed, %s", e.toString());
                AppMethodBeat.o(37749);
                return str;
            }
        }
        str = str + str2 + join;
        AppMethodBeat.o(37749);
        return str;
    }

    private static boolean cqj() {
        AppMethodBeat.i(37750);
        com.tencent.mm.storage.c ll = c.abi().ll("100150");
        if (ll.isValid()) {
            int i = bo.getInt((String) ll.dru().get("openCanvas"), 0);
            com.tencent.mm.sdk.platformtools.ab.i("AdLandingPagesParseHelper", "canOpenGameCanvas abtest=".concat(String.valueOf(i)));
            if (i == 1) {
                AppMethodBeat.o(37750);
                return true;
            }
            AppMethodBeat.o(37750);
            return false;
        }
        AppMethodBeat.o(37750);
        return false;
    }

    public static boolean y(Intent intent, Context context) {
        int i = 0;
        AppMethodBeat.i(37751);
        String stringExtra = intent.getStringExtra("sns_landing_pages_xml");
        if (!TextUtils.isEmpty(stringExtra)) {
            if (TextUtils.isEmpty(stringExtra) || !go(stringExtra, "adCanvasInfo")) {
                com.tencent.mm.sdk.platformtools.ab.i("AdLandingPagesParseHelper", "invalid canvas xml %s", stringExtra);
            } else {
                String str = "";
                boolean YN = YN(stringExtra);
                if (YN) {
                    str = c.abj().getExpIdByKey("Sns_Canvas_GameShare_JumpWay");
                    if (TextUtils.isEmpty(str)) {
                        i = cqj();
                    } else {
                        int en = c.abj().en("Sns_Canvas_GameShare_JumpWay", 0);
                        com.tencent.mm.sdk.platformtools.ab.i("AdLandingPagesParseHelper", "abtestvalue = ".concat(String.valueOf(en)));
                        if (en != 0) {
                            i = 1;
                        }
                    }
                } else {
                    i = 1;
                }
                if (i != 0) {
                    Intent intent2 = new Intent(intent);
                    intent2.setClass(context, SnsAdNativeLandingPagesUI.class);
                    intent2.putExtra("sns_landing_pages_expid", str);
                    context.startActivity(intent2);
                    AppMethodBeat.o(37751);
                    return true;
                }
                boolean b = b(stringExtra, context, YN, intent.getIntExtra("sns_landig_pages_from_source", -1));
                AppMethodBeat.o(37751);
                return b;
            }
        }
        AppMethodBeat.o(37751);
        return false;
    }

    public static boolean a(TimeLineObject timeLineObject, Activity activity) {
        AppMethodBeat.i(37752);
        String str = timeLineObject.rCK;
        long longValue = new BigInteger(timeLineObject.Id).longValue();
        LinkedList linkedList = timeLineObject.xfI.wbK;
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str) || !YO(str)) {
                com.tencent.mm.sdk.platformtools.ab.i("AdLandingPagesParseHelper", "invalid canvas xml %s", str);
            } else {
                int i;
                String str2 = "";
                boolean YN = YN(str);
                if (YN) {
                    str2 = c.abj().getExpIdByKey("Sns_Canvas_GameShare_JumpWay");
                    if (c.abj().en("Sns_Canvas_GameShare_JumpWay", 0) == 0) {
                        i = 0;
                    } else {
                        i = 1;
                    }
                    if (i == 0 && cqj()) {
                        i = 1;
                    }
                } else {
                    i = 1;
                }
                if (i != 0) {
                    com.tencent.mm.plugin.sns.storage.n kD = af.cnF().kD(longValue);
                    Intent intent = new Intent();
                    if (kD != null) {
                        intent.putExtra("sns_landing_pages_share_sns_id", kD.cqA());
                        intent.putExtra("sns_landing_pages_rawSnsId", kD.cqu().Id);
                        intent.putExtra("sns_landing_pages_ux_info", kD.crc());
                        intent.putExtra("sns_landing_pages_aid", kD.cqZ());
                        intent.putExtra("sns_landing_pages_traceid", kD.cra());
                        intent.putExtra("sns_landing_pages_rec_src", kD.cre());
                    }
                    if (linkedList != null && linkedList.size() > 0) {
                        intent.putExtra("sns_landing_pages_share_thumb_url", ((bau) linkedList.get(0)).wEH);
                    }
                    intent.putExtra("sns_landing_pages_expid", str2);
                    intent.putExtra("sns_landig_pages_from_source", 11);
                    intent.setClass(activity, SnsAdNativeLandingPagesUI.class);
                    intent.putExtra("sns_landing_pages_xml", str);
                    intent.putExtra("sns_landing_pages_xml_prefix", "adxml");
                    intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
                    activity.startActivity(intent);
                    AppMethodBeat.o(37752);
                    return true;
                }
                b(str, activity, YN, 11);
            }
        }
        AppMethodBeat.o(37752);
        return false;
    }

    public static boolean YO(String str) {
        AppMethodBeat.i(139039);
        boolean go = go(str, "adCanvasInfo");
        AppMethodBeat.o(139039);
        return go;
    }

    public static boolean go(String str, String str2) {
        AppMethodBeat.i(37754);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            AppMethodBeat.o(37754);
            return false;
        }
        if (reo == null) {
            cqk();
        }
        if (reo == null || reo.isEmpty()) {
            AppMethodBeat.o(37754);
            return false;
        }
        Map z = br.z(str, str2);
        if (z == null || z.isEmpty()) {
            com.tencent.mm.sdk.platformtools.ab.w("AdLandingPagesParseHelper", "invalid landingpages xml,".concat(String.valueOf(str)));
            AppMethodBeat.o(37754);
            return false;
        }
        a aVar = new a();
        aVar.rep = 0;
        aVar.req = bo.ank((String) z.get(".adCanvasInfo.type"));
        aVar.rer = bo.ank((String) z.get(".adCanvasInfo.subtype"));
        if (reo.contains(aVar)) {
            String str3 = ".adCanvasInfo.PageList.Page";
            int i = 0;
            while (true) {
                String str4;
                aVar.rep = 1;
                if (i == 0) {
                    str4 = str3;
                } else {
                    str4 = str3 + i;
                }
                if (z.containsKey(str4 + ".componentItemList.componentItem.type")) {
                    aVar.req = bo.ank((String) z.get(str4 + ".type"));
                    aVar.rer = bo.ank((String) z.get(str4 + ".subType"));
                    if (reo.contains(aVar)) {
                        String str5 = str4 + ".componentItemList.componentItem";
                        aVar.rep = 2;
                        int i2 = 0;
                        while (true) {
                            if (i2 == 0) {
                                str4 = str5;
                            } else {
                                str4 = str5 + i2;
                            }
                            if (!z.containsKey(str4 + ".type")) {
                                break;
                            }
                            aVar.req = bo.ank((String) z.get(str4 + ".type"));
                            aVar.rer = bo.ank((String) z.get(str4 + ".subType"));
                            if (reo.contains(aVar)) {
                                i2++;
                            } else {
                                com.tencent.mm.sdk.platformtools.ab.i("AdLandingPagesParseHelper", "invalid component type ".concat(String.valueOf(aVar)));
                                AppMethodBeat.o(37754);
                                return false;
                            }
                        }
                    }
                    com.tencent.mm.sdk.platformtools.ab.i("AdLandingPagesParseHelper", "invalid page type ".concat(String.valueOf(aVar)));
                    AppMethodBeat.o(37754);
                    return false;
                }
                aVar.rep = 2;
                for (Entry entry : z.entrySet()) {
                    if (entry.getKey() != null && ((String) entry.getKey()).matches("[\\s\\S]*\\.componentItem[0-9]*\\.type$")) {
                        String str6 = (String) entry.getKey();
                        String replace = ((String) entry.getKey()).replace(".type", ".subType");
                        aVar.req = bo.ank((String) z.get(str6));
                        aVar.rer = bo.ank((String) z.get(replace));
                        if (!reo.contains(aVar)) {
                            com.tencent.mm.sdk.platformtools.ab.i("AdLandingPagesParseHelper", "invalid component type ".concat(String.valueOf(aVar)));
                            AppMethodBeat.o(37754);
                            return false;
                        }
                    }
                }
                AppMethodBeat.o(37754);
                return true;
                i++;
            }
        } else {
            com.tencent.mm.sdk.platformtools.ab.i("AdLandingPagesParseHelper", "invalid canvas type ".concat(String.valueOf(aVar)));
            AppMethodBeat.o(37754);
            return false;
        }
    }

    private static void cqk() {
        AppMethodBeat.i(37755);
        if (reo != null) {
            AppMethodBeat.o(37755);
            return;
        }
        reo = new HashSet();
        InputStream inputStream = null;
        try {
            inputStream = ah.getContext().getAssets().open("sns/canvas_valid_type.xml");
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            newPullParser.setInput(inputStream, "UTF-8");
            int i = -1;
            int i2 = -1;
            int eventType = newPullParser.getEventType();
            while (eventType != 1) {
                int i3;
                if (eventType == 2) {
                    Object obj;
                    String name = newPullParser.getName();
                    if ("canvastype".equals(name)) {
                        i2 = 0;
                        obj = null;
                    } else if ("pagetype".equals(name)) {
                        i2 = 1;
                        eventType = 1;
                    } else if ("componenttype".equals(name)) {
                        i2 = 2;
                        eventType = 2;
                    } else {
                        eventType = "subtype".equals(name) ? 3 : -1;
                    }
                    if (obj != -1) {
                        if (bo.getInt(newPullParser.getAttributeValue(null, "android"), 0) == 1) {
                            i3 = bo.getInt(newPullParser.getAttributeValue(null, "val"), -1);
                        } else {
                            i3 = -1;
                        }
                        switch (obj) {
                            case null:
                            case 1:
                            case 2:
                                break;
                            case 3:
                                if (!(i2 == -1 || i == -1 || i3 == -1)) {
                                    a aVar = new a();
                                    aVar.rep = i2;
                                    aVar.req = i;
                                    aVar.rer = i3;
                                    reo.add(aVar);
                                    com.tencent.mm.sdk.platformtools.ab.i("AdLandingPagesParseHelper", "valid canvas type ".concat(String.valueOf(aVar)));
                                    break;
                                }
                        }
                    }
                }
                i3 = i;
                eventType = newPullParser.next();
                i = i3;
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                    AppMethodBeat.o(37755);
                    return;
                } catch (IOException e) {
                    AppMethodBeat.o(37755);
                    return;
                }
            }
        } catch (IOException e2) {
            com.tencent.mm.sdk.platformtools.ab.e("AdLandingPagesParseHelper", bo.l(e2));
            if (inputStream != null) {
                try {
                    inputStream.close();
                    AppMethodBeat.o(37755);
                    return;
                } catch (IOException e3) {
                    AppMethodBeat.o(37755);
                    return;
                }
            }
        } catch (XmlPullParserException e4) {
            com.tencent.mm.sdk.platformtools.ab.e("AdLandingPagesParseHelper", bo.l(e4));
            if (inputStream != null) {
                try {
                    inputStream.close();
                    AppMethodBeat.o(37755);
                    return;
                } catch (IOException e5) {
                    AppMethodBeat.o(37755);
                    return;
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e6) {
                }
            }
            AppMethodBeat.o(37755);
        }
        AppMethodBeat.o(37755);
    }

    public static String y(com.tencent.mm.plugin.sns.storage.n nVar) {
        AppMethodBeat.i(37756);
        if (nVar == null) {
            com.tencent.mm.sdk.platformtools.ab.e("AdLandingPagesParseHelper", "the snsinfo is null");
            AppMethodBeat.o(37756);
            return null;
        } else if (nVar.DI(32)) {
            com.tencent.mm.plugin.sns.storage.e crd = nVar.crd();
            if (crd == null) {
                com.tencent.mm.sdk.platformtools.ab.e("AdLandingPagesParseHelper", "the adSnsInfo is null");
                AppMethodBeat.o(37756);
                return null;
            }
            com.tencent.mm.plugin.sns.storage.b cqo = nVar.cqo();
            if (cqo == null) {
                com.tencent.mm.sdk.platformtools.ab.e("AdLandingPagesParseHelper", "the adxml is null");
                AppMethodBeat.o(37756);
                return null;
            }
            com.tencent.mm.plugin.sns.storage.a cqq = nVar.cqq();
            if (cqq == null) {
                com.tencent.mm.sdk.platformtools.ab.e("AdLandingPagesParseHelper", "the adInfo is null");
                AppMethodBeat.o(37756);
                return null;
            } else if (!cqo.coK()) {
                com.tencent.mm.sdk.platformtools.ab.e("AdLandingPagesParseHelper", "the snsinfo is not a landingpage");
                AppMethodBeat.o(37756);
                return null;
            } else if (cqq.qTN == null || cqq.qTN.size() == 0) {
                com.tencent.mm.sdk.platformtools.ab.e("AdLandingPagesParseHelper", "the mappedCanvasCardExt is empty");
                AppMethodBeat.o(37756);
                return null;
            } else {
                String v = v(crd.field_adxml, cqq.qTN);
                AppMethodBeat.o(37756);
                return v;
            }
        } else {
            com.tencent.mm.sdk.platformtools.ab.e("AdLandingPagesParseHelper", "the snsinfo is not a ad");
            AppMethodBeat.o(37756);
            return null;
        }
    }

    private static String v(String str, Map<String, String> map) {
        AppMethodBeat.i(37757);
        if (str == null || str.length() == 0) {
            com.tencent.mm.sdk.platformtools.ab.e("AdLandingPagesParseHelper", "the adLandingPagesXml is empty");
            AppMethodBeat.o(37757);
            return null;
        } else if (map == null || map.size() == 0) {
            com.tencent.mm.sdk.platformtools.ab.e("AdLandingPagesParseHelper", "the mappedCanvasCardExt is empty");
            AppMethodBeat.o(37757);
            return null;
        } else {
            LinkedList gn = gn(str, "adxml");
            for (String str2 : map.keySet()) {
                if (!bo.isNullOrNil(str2)) {
                    String str3 = (String) map.get(str2);
                    if (!bo.isNullOrNil(str3)) {
                        String str4;
                        Iterator it = gn.iterator();
                        String str5 = null;
                        while (it.hasNext()) {
                            Iterator it2 = ((g) it.next()).rej.iterator();
                            while (it2.hasNext()) {
                                r rVar = (r) it2.next();
                                if ((rVar instanceof e) && !bo.isNullOrNil(((e) rVar).kcM) && ((e) rVar).kcM.equals(str2)) {
                                    str4 = ((e) rVar).kdB;
                                    break;
                                }
                            }
                            str4 = str5;
                            if (str4 != null) {
                                break;
                            }
                            str5 = str4;
                        }
                        str4 = str5;
                        if (!bo.isNullOrNil(str4)) {
                            com.tencent.mm.sdk.platformtools.ab.i("AdLandingPagesParseHelper", "old card ext is " + str4 + " and new card ext is " + str3);
                            str = str.replace(str4, str3);
                            try {
                                str = str.replace(bo.ani(str4), bo.ani(str3));
                            } catch (Exception e) {
                                com.tencent.mm.sdk.platformtools.ab.e("AdLandingPagesParseHelper", "the xml is error");
                            }
                        }
                    }
                }
            }
            AppMethodBeat.o(37757);
            return str;
        }
    }

    public static void dj(List<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.h> list) {
        AppMethodBeat.i(37758);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(37758);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.h hVar : list) {
            if (Dz(hVar.cpv().type)) {
                arrayList.addAll(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a) hVar).cpt());
            }
        }
        if (!arrayList.isEmpty()) {
            dj(arrayList);
            list.addAll(arrayList);
        }
        AppMethodBeat.o(37758);
    }
}
