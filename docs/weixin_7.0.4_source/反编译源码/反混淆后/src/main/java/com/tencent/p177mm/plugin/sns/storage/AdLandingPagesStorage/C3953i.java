package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.p520ui.SnsAdNativeLandingPagesUI;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C13469p;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C13470q;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C13471s;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C13472y;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C21937ab;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C21937ab.C21938a;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C21967k;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C24829h;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C29062b;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C29084i;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C29085j;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C29086r;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C31414aa;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C31416t;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C34985w;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C34986x;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C3947z;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C39779l;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C39780n;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C39781u;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C43567e;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C43568f;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C43568f.C3946a;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C44764d;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C44765g;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C44765g.C29083a;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C46232m;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C46233o;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.C13437h;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.C29064ad;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.C3910a;
import com.tencent.p177mm.plugin.sns.storage.C21980a;
import com.tencent.p177mm.plugin.sns.storage.C21984b;
import com.tencent.p177mm.plugin.sns.storage.C43570e;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C5141c;
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

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i */
public final class C3953i {
    public static int rem = 750;
    public static int ren = 10;
    private static Set<C3954a> reo = null;

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i$a */
    static class C3954a {
        int rep;
        int req;
        int rer;

        private C3954a() {
        }

        /* synthetic */ C3954a(byte b) {
            this();
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof C3954a)) {
                return false;
            }
            C3954a c3954a = (C3954a) obj;
            if (c3954a.rep == this.rep && c3954a.req == this.req && c3954a.rer == this.rer) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return (this.rep + this.req) + this.rer;
        }

        public final String toString() {
            AppMethodBeat.m2504i(37732);
            String str = "[nodeType=" + this.rep + ",compType=" + this.req + ",subCompType=" + this.rer + "]";
            AppMethodBeat.m2505o(37732);
            return str;
        }
    }

    /* renamed from: Dz */
    public static boolean m6286Dz(int i) {
        if (i == 101 || i == 103 || i == 104 || i == 105) {
            return true;
        }
        return false;
    }

    /* renamed from: DA */
    public static boolean m6281DA(int i) {
        if (i == 101) {
            return true;
        }
        return false;
    }

    /* renamed from: DB */
    public static boolean m6282DB(int i) {
        if (i == 103) {
            return true;
        }
        return false;
    }

    /* renamed from: DC */
    public static boolean m6283DC(int i) {
        if (i == 104) {
            return true;
        }
        return false;
    }

    /* renamed from: DD */
    public static boolean m6284DD(int i) {
        if (i == 105) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public static float m6289a(double d, int i, int i2, int i3) {
        AppMethodBeat.m2504i(37733);
        float f;
        if (i == 0) {
            f = (float) d;
            AppMethodBeat.m2505o(37733);
            return f;
        } else if (i2 == 0) {
            f = (float) d;
            AppMethodBeat.m2505o(37733);
            return f;
        } else {
            f = (float) C29064ad.m46204aY((((float) C29064ad.m46206eP(C4996ah.getContext())[0]) * (((float) d) * ((float) i3))) / ((float) i2));
            AppMethodBeat.m2505o(37733);
            return f;
        }
    }

    /* renamed from: a */
    private static C29086r m6292a(Map<String, String> map, String str, int i, int i2, int i3, int i4) {
        C29086r c29086r;
        AppMethodBeat.m2504i(37734);
        int ank = C5046bo.ank((String) map.get(str + ".type"));
        int ank2 = C5046bo.ank((String) map.get(str + ".subType"));
        C29086r c39781u;
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
        C34985w c34985w;
        switch (ank) {
            case 1:
                c39781u = new C39781u();
                c39781u.qWP = ank;
                c39781u.cuu = ank2;
                c39781u.qXk = C5046bo.m7532bc((String) map.get(str + ".content"), "");
                c39781u.textAlignment = C5046bo.ank((String) map.get(str + ".textAlignment"));
                c39781u.oxN = C5046bo.m7532bc((String) map.get(str + ".fontColor"), "");
                c39781u.eOg = C3953i.m6289a(C5046bo.anm((String) map.get(str + ".fontSize")), i, i2, i3);
                c39781u.qXl = (C5046bo.ank((String) map.get(new StringBuilder().append(str).append(".showType").toString())) & C39781u.qXf) > 0;
                c39781u.qXm = (C5046bo.ank((String) map.get(new StringBuilder().append(str).append(".showType").toString())) & C39781u.qXg) > 0;
                c39781u.qXn = (C5046bo.ank((String) map.get(new StringBuilder().append(str).append(".showType").toString())) & C39781u.qXh) > 0;
                c39781u.maxLines = C5046bo.ank((String) map.get(str + ".maxLines"));
                c39781u.qWp = C5046bo.ank((String) map.get(str + ".fontType"));
                c39781u.qXo = C5046bo.ann((String) map.get(str + ".lineSpace"));
                c29086r = c39781u;
                break;
            case 21:
                C29086r c29062b;
                if (ank2 == 2) {
                    c29062b = new C29062b();
                    c29062b.csB = (String) map.get(str + ".appid");
                    c29062b.qVZ = (String) map.get(str + ".appPageUrlAndroid");
                    c29062b.channelId = (String) map.get(str + ".channelId");
                    c29062b.f13702Iw = (String) map.get(str + ".pkg");
                    c29062b.qVO = C5046bo.ank((String) map.get(str + ".platform"));
                    c29062b.qVP = (String) map.get(str + ".warningAndroid");
                    c29062b.qVQ = (String) map.get(str + ".btnBgColorTheme");
                    c29062b.qVS = (String) map.get(str + ".btnBgColorThemePressed");
                    c29062b.qVR = (String) map.get(str + ".btnBgColorThemeDisable");
                    c29062b.qVT = (String) map.get(str + ".btnBorderColorTheme");
                    c29062b.qVV = (String) map.get(str + ".btnBorderColorThemePressed");
                    c29062b.qVU = (String) map.get(str + ".btnBorderColorThemeDisable");
                    c29062b.qVW = (String) map.get(str + ".fontColor");
                    c29062b.qVY = (String) map.get(str + ".fontColorPressed");
                    c29062b.qVX = (String) map.get(str + ".fontColorDisable");
                    c39781u = c29062b;
                } else if (ank2 == 4) {
                    c29062b = new C43567e();
                    c29062b.kcM = C5046bo.m7532bc((String) map.get(str + ".cardTpId"), "");
                    c29062b.kdB = C5046bo.m7532bc((String) map.get(str + ".cardExt"), "");
                    c39781u = c29062b;
                } else if (ank2 == 7) {
                    c29062b = new C29085j();
                    c29062b.qWf = C5046bo.m7532bc((String) map.get(str + ".jumpCanvasId"), "");
                    c29062b.qWg = C5046bo.m7532bc((String) map.get(str + ".jumpCanvasExt"), "");
                    c29062b.qWh = C5046bo.ank((String) map.get(str + ".jumpCanvasNoStore"));
                    c29062b.qWi = C5046bo.ank((String) map.get(str + ".btnCanvasEnterType"));
                    c29062b.qWj = C5046bo.ank((String) map.get(str + ".btnCanvasSource"));
                    c39781u = c29062b;
                } else if (ank2 == 8) {
                    c29062b = new C29084i();
                    c29062b.username = (String) map.get(str + ".weappUserName");
                    c29062b.cOh = (String) map.get(str + ".weappPath");
                    c39781u = c29062b;
                } else if (ank2 == 9) {
                    anm = C5046bo.anm((String) map.get(str + ".location.$x"));
                    anm2 = C5046bo.anm((String) map.get(str + ".location.$y"));
                    ank3 = C5046bo.ank((String) map.get(str + ".location.$scale"));
                    str2 = (String) map.get(str + ".location.$label");
                    str3 = (String) map.get(str + ".location.$poiname");
                    if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
                        AppMethodBeat.m2505o(37734);
                        return null;
                    }
                    c39781u = new C43568f(new C3946a(anm, anm2, ank3, str2, str3));
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
                            AppMethodBeat.m2505o(37734);
                            return null;
                        } else {
                            c39781u = new C24829h(arrayList);
                        }
                    }
                } else {
                    c39781u = new C21967k();
                }
                c39781u.qWP = ank;
                c39781u.cuu = ank2;
                c39781u.title = C5046bo.m7532bc((String) map.get(str + ".btnTitle"), "");
                c39781u.qWk = C5046bo.ank((String) map.get(str + ".btnType"));
                c39781u.qWl = C5046bo.m7532bc((String) map.get(str + ".btnJumpUrl"), "");
                c39781u.qWm = C5046bo.m7532bc((String) map.get(str + ".btnJumpApp"), "");
                c39781u.qWn = C5046bo.m7532bc((String) map.get(str + ".fontColor"), "");
                c39781u.fontSize = C3953i.m6289a(C5046bo.anm((String) map.get(str + ".fontSize")), i, i2, i3);
                c39781u.qWp = C5046bo.ank((String) map.get(str + ".btnFontType"));
                c39781u.textAlignment = C5046bo.ank((String) map.get(str + ".btnAlignment"));
                c39781u.qWo = C3953i.m6289a(C5046bo.anm((String) map.get(str + ".borderSize")), i, i2, i3);
                c39781u.height = C3953i.m6289a(C5046bo.anm((String) map.get(str + ".btnHeight")), i, i2, i3);
                c39781u.qWq = C5046bo.m7532bc((String) map.get(str + ".btnBgColorTheme"), "");
                c39781u.qWr = C5046bo.m7532bc((String) map.get(str + ".btnBorderColorTheme"), "");
                c39781u.qWs = C5046bo.m7532bc((String) map.get(str + ".btnBgImgUrl"), "");
                c39781u.qWt = C5046bo.ank((String) map.get(str + ".bCanLongPress"));
                c39781u.qWu = C5046bo.ank((String) map.get(str + ".bHideActionSheet"));
                c39781u.qWv = C5046bo.ank((String) map.get(str + ".hideProductActionHeader"));
                c39781u.qWw = C5046bo.ank((String) map.get(str + ".showProductActionCancelButton"));
                c39781u.qWy = C5046bo.m7532bc((String) map.get(str + ".productActionTitle"), "");
                c39781u.qWx = C5046bo.m7532bc((String) map.get(str + ".productActionBuffer"), "");
                c39781u.qWz = C5046bo.m7532bc((String) map.get(str + ".productActionIconUrl"), "");
                if (map.containsKey(str + ".productActionItem.componentItem.type")) {
                    c39781u.qWA = C3953i.m6291a((Map) map, i, i2, i3, i4, str + ".productActionItem.componentItem");
                }
                c29086r = c39781u;
                break;
            case 41:
                c39781u = new C39780n();
                c39781u.qWP = ank;
                c39781u.cuu = ank2;
                c39781u.qWD = C5046bo.m7532bc((String) map.get(str + ".pureImageUrl"), "");
                c39781u.qWE = C5046bo.m7532bc((String) map.get(str + ".bgColor"), "");
                if (map.containsKey(str + ".bgColorAlpha") && c39781u.qWE.length() > 0) {
                    Map<String, String> map2 = map;
                    c39781u.qWE = String.format("#%02x%s", new Object[]{Integer.valueOf((int) (C5046bo.anm((String) map2.get(str + ".bgColorAlpha")) * 255.0d)), c39781u.qWE.substring(1)});
                }
                c39781u.width = C3953i.m6289a(C5046bo.anm((String) map.get(str + ".imageWidth")), i, i2, i3);
                c39781u.height = C3953i.m6289a(C5046bo.anm((String) map.get(str + ".imageHeight")), i, i2, i3);
                c39781u.qWC = false;
                c29086r = c39781u;
                break;
            case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                c39781u = new C46232m();
                c39781u.qWP = ank;
                c39781u.cuu = ank2;
                c39781u.qWD = C5046bo.m7532bc((String) map.get(str + ".panoramaImageUrl"), "");
                c39781u.width = C3953i.m6289a(C5046bo.anm((String) map.get(str + ".imageWidth")), i, i2, i3);
                c39781u.height = C3953i.m6289a(C5046bo.anm((String) map.get(str + ".imageHeight")), i, i2, i3);
                c29086r = c39781u;
                break;
            case IMediaObject.TYPE_BUSINESS_CARD /*45*/:
                c39781u = new C39780n();
                c39781u.qWP = ank;
                c39781u.cuu = ank2;
                c39781u.qWD = C5046bo.m7532bc((String) map.get(str + ".fullScreenImageUrl"), "");
                c39781u.qWC = true;
                c29086r = c39781u;
                break;
            case PlayerException.EXCEPTION_TYPE_INITLIB /*61*/:
                c39781u = new C46233o();
                c39781u.qWP = ank;
                c39781u.cuu = ank2;
                c39781u.qWF = C5046bo.m7532bc((String) map.get(str + ".sightVideoUrl"), "");
                c39781u.qWG = C5046bo.m7532bc((String) map.get(str + ".sightThumbUrl"), "");
                c39781u.qWH = C5046bo.m7532bc((String) map.get(str + ".streamVideoUrl"), "");
                c39781u.qWI = C5046bo.m7532bc((String) map.get(str + ".jumpText"), "");
                c39781u.qWf = C5046bo.m7532bc((String) map.get(str + ".jumpCanvasId"), "");
                c39781u.qWg = C5046bo.m7532bc((String) map.get(str + ".jumpCanvasExt"), "");
                c39781u.qWh = C5046bo.ank((String) map.get(str + ".jumpCanvasNoStore"));
                try {
                    c39781u.qWJ = Color.parseColor((String) map.get(str + ".jumpTextColor"));
                } catch (Exception e) {
                    c39781u.qWJ = Color.rgb(255, 255, 255);
                }
                try {
                    c39781u.qWK = Color.parseColor((String) map.get(str + ".separatorColor"));
                } catch (Exception e2) {
                    c39781u.qWK = Color.rgb(255, 255, 255);
                }
                c39781u.width = C3953i.m6289a(C5046bo.anm((String) map.get(str + ".sightDisplayWidth")), i, i2, i3);
                c39781u.height = C3953i.m6289a(C5046bo.anm((String) map.get(str + ".sightDisplayHeight")), i, i2, i3);
                c39781u.qWL = C5046bo.ank((String) map.get(str + ".sightDisplayType"));
                nullAsNil = C5046bo.nullAsNil((String) map.get(str + ".floatComponentId"));
                ank4 = C5046bo.ank((String) map.get(str + ".floatStartTime"));
                if (!C5046bo.isNullOrNil(nullAsNil) && ank4 > 0) {
                    c34985w = new C34985w();
                    c34985w.cHR = nullAsNil;
                    c34985w.qXt = ank4;
                    c39781u.qWM = c34985w;
                }
                c29086r = c39781u;
                break;
            case 62:
                c39781u = new C3947z();
                c39781u.qWP = ank;
                c39781u.cuu = ank2;
                c39781u.qWH = C5046bo.m7532bc((String) map.get(str + ".streamVideoUrl"), "");
                c39781u.qXv = C5046bo.m7532bc((String) map.get(str + ".streamVideoThumb"), "");
                c39781u.width = C3953i.m6289a(C5046bo.anm((String) map.get(str + ".streamDisplayWidth")), i, i2, i3);
                c39781u.height = C3953i.m6289a(C5046bo.anm((String) map.get(str + ".streamDisplayHeight")), i, i2, i3);
                c39781u.qXw = C5046bo.ank((String) map.get(str + ".streamDisplayType"));
                nullAsNil = C5046bo.nullAsNil((String) map.get(str + ".floatComponentId"));
                ank4 = C5046bo.ank((String) map.get(str + ".floatStartTime"));
                if (!C5046bo.isNullOrNil(nullAsNil) && ank4 > 0) {
                    c34985w = new C34985w();
                    c34985w.cHR = nullAsNil;
                    c34985w.qXt = ank4;
                    c39781u.qWM = c34985w;
                }
                c29086r = c39781u;
                break;
            case 81:
                c39781u = new C13472y();
                c39781u.qWP = ank;
                c39781u.cuu = ank2;
                c39781u.nmz = C5046bo.m7532bc((String) map.get(str + ".webviewUrl"), "");
                c29086r = c39781u;
                break;
            case 82:
                c39781u = new C31414aa();
                c39781u.url = C5046bo.m7532bc((String) map.get(str + ".webviewUrl"), "");
                c29086r = c39781u;
                break;
            case 102:
                c29086r = C3953i.m6298c(map, str, i, i2, i3, i4);
                break;
            case 121:
            case 122:
                int argb;
                double a = (double) C3953i.m6289a(C5046bo.anm((String) map.get(str + ".topLineSize")), i, i2, i3);
                double a2 = (double) C3953i.m6289a(C5046bo.anm((String) map.get(str + ".bottomLineSize")), i, i2, i3);
                if (C3953i.m6285DE(i4)) {
                    argb = Color.argb(51, 0, 0, 0);
                } else {
                    argb = Color.argb(51, 255, 255, 255);
                }
                if (ank != 121) {
                    if (ank != 122) {
                        c29086r = null;
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
                            c29086r = new C44764d(a, a2, argb, arrayList2);
                            break;
                        } else {
                            AppMethodBeat.m2505o(37734);
                            return null;
                        }
                    }
                }
                anm = C5046bo.anm((String) map.get(str + ".location.$x"));
                anm2 = C5046bo.anm((String) map.get(str + ".location.$y"));
                ank3 = C5046bo.ank((String) map.get(str + ".location.$scale"));
                str2 = (String) map.get(str + ".location.$label");
                str3 = (String) map.get(str + ".location.$poiname");
                if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
                    C29086r c44765g = new C44765g(a, a2, new C29083a(anm, anm2, ank3, str2, str3), argb);
                    break;
                }
                AppMethodBeat.m2505o(37734);
                return null;
                break;
            case 131:
                c39781u = new C31416t();
                c39781u.qWP = ank;
                c39781u.cuu = ank2;
                c39781u.label = C5046bo.m7532bc((String) map.get(str + ".label"), "");
                c39781u.value = (float) C5046bo.anm((String) map.get(str + ".value"));
                c39781u.qXe = C5046bo.m7532bc((String) map.get(str + ".foregroundImage"), "");
                c39781u.fontSize = C3953i.m6289a(C5046bo.anm((String) map.get(str + ".fontSize")), i, i2, i3);
                c39781u.hfo = C5046bo.m7532bc((String) map.get(str + ".backgroundColor"), "");
                c29086r = c39781u;
                break;
            case 132:
                c29086r = C3953i.m6290a(map, str, i, i2, i3);
                break;
            default:
                AppMethodBeat.m2505o(37734);
                return null;
        }
        if (c29086r != null) {
            c29086r.qWW = C3953i.m6285DE(i4);
            c29086r.type = ank;
            c29086r.cuu = ank2;
            C3953i.m6293a(c29086r, (Map) map, str, i, i2, i3);
        }
        AppMethodBeat.m2505o(37734);
        return c29086r;
    }

    /* renamed from: a */
    private static C21937ab m6290a(Map<String, String> map, String str, int i, int i2, int i3) {
        AppMethodBeat.m2504i(37735);
        C21937ab c21937ab = new C21937ab();
        try {
            String str2 = str + ".radarChart";
            c21937ab.qXx = (String) map.get(str2 + ".borderImg");
            c21937ab.qXD = (String) map.get(str2 + ".maskImg");
            c21937ab.qXy = (String) map.get(str2 + ".coverColor");
            c21937ab.qXz = Color.parseColor((String) map.get(str2 + ".labelFont.$color"));
            c21937ab.qXA = (int) C3953i.m6289a(C5046bo.anm((String) map.get(str2 + ".labelFont.$size")), i, i2, i3);
            c21937ab.qXB = Color.parseColor((String) map.get(str2 + ".scoreFont.$color"));
            c21937ab.qXC = (int) C3953i.m6289a(C5046bo.anm((String) map.get(str2 + ".scoreFont.$size")), i, i2, i3);
            c21937ab.borderWidth = C3953i.m6289a(C5046bo.anm((String) map.get(str2 + ".borderImgWidth")), i, i2, i3);
            String str3 = str2 + ".itemList.item";
            int i4 = 0;
            while (true) {
                if (i4 != 0) {
                    str2 = str3 + i4;
                } else {
                    str2 = str3;
                }
                C21938a c21938a = new C21938a();
                c21938a.label = (String) map.get(str2 + ".label");
                c21938a.qXE = (String) map.get(str2 + ".score");
                c21938a.value = (float) C5046bo.anm((String) map.get(str2 + ".value"));
                if (TextUtils.isEmpty(c21938a.label) && TextUtils.isEmpty(c21938a.qXE)) {
                    break;
                }
                c21937ab.itemList.add(c21938a);
                i4++;
            }
        } catch (Exception e) {
            C4990ab.m7412e("AdLandingPagesParseHelper", C5046bo.m7574l(e));
        }
        AppMethodBeat.m2505o(37735);
        return c21937ab;
    }

    /* renamed from: b */
    private static List<C29086r> m6296b(Map<String, String> map, String str, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(37736);
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
            C29086r a = C3953i.m6291a((Map) map, i, i2, i3, i4, str3);
            if (a != null) {
                if (a.qXa) {
                    arrayList.add(a);
                } else {
                    C4990ab.m7416i("AdLandingPagesParseHelper", "comp " + a.toString() + " ifCondition is false");
                }
                i5++;
            } else {
                AppMethodBeat.m2505o(37736);
                return arrayList;
            }
        }
    }

    /* renamed from: c */
    private static C39779l m6298c(Map<String, String> map, String str, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(37737);
        C39779l c39779l = new C39779l();
        try {
            int parseColor = Color.parseColor((String) map.get(str + ".bgColorTheme"));
            c39779l.backgroundColor = (((int) (C5046bo.getDouble((String) map.get(str + ".bgColorAlpha"), 0.0d) * 255.0d)) << 24) | (parseColor & 16777215);
        } catch (Exception e) {
            C4990ab.m7413e("AdLandingPagesParseHelper", "%s", C5046bo.m7574l(e));
            c39779l.backgroundColor = Color.argb(51, 0, 0, 0);
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
            C29086r a = C3953i.m6291a((Map) map, i, i2, i3, i4, str3);
            if (a != null) {
                if (a.qXa) {
                    c39779l.qWB.add(a);
                }
                i5++;
            } else {
                AppMethodBeat.m2505o(37737);
                return c39779l;
            }
        }
    }

    /* renamed from: d */
    private static C34986x m6299d(Map<String, String> map, String str, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(37738);
        C29086r c34986x = new C34986x();
        C3953i.m6293a(c34986x, (Map) map, str, i, i2, i3);
        c34986x.qXu = C5046bo.ank((String) map.get(str + ".pageCtrType"));
        c34986x.iXr = C5046bo.ank((String) map.get(new StringBuilder().append(str).append(".isFullScreen").toString())) == 1;
        String str2 = str + ".componentGroupList.componentGroup";
        int i5 = 0;
        while (true) {
            String str3;
            if (i5 == 0) {
                str3 = str2;
            } else {
                str3 = str2 + i5;
            }
            C39779l c39779l = new C39779l();
            String str4 = str3 + ".componentItem";
            int i6 = 0;
            while (true) {
                String str5;
                if (i6 == 0) {
                    str5 = str4;
                } else {
                    str5 = str4 + i6;
                }
                C29086r a = C3953i.m6291a((Map) map, i, i2, i3, i4, str5);
                if (a == null) {
                    break;
                }
                if (a.qXa) {
                    c39779l.qWB.add(a);
                }
                i6++;
            }
            if (c39779l.qWB.size() != 0) {
                c34986x.qWB.add(c39779l);
                i5++;
            } else {
                AppMethodBeat.m2505o(37738);
                return c34986x;
            }
        }
    }

    /* renamed from: a */
    private static void m6293a(C29086r c29086r, Map<String, String> map, String str, int i, int i2, int i3) {
        boolean z = true;
        AppMethodBeat.m2504i(37739);
        c29086r.qWP = C5046bo.ank((String) map.get(str + ".type"));
        c29086r.type = c29086r.qWP;
        c29086r.qWO = C5046bo.m7532bc((String) map.get(str + ".id"), "");
        c29086r.qWQ = C3953i.m6289a(C5046bo.anm((String) map.get(str + ".paddingTop")), i, i2, i3);
        c29086r.qWR = C3953i.m6289a(C5046bo.anm((String) map.get(str + ".paddingBottom")), i, i2, i3);
        c29086r.qWS = C3953i.m6289a(C5046bo.anm((String) map.get(str + ".paddingLeft")), i, i2, i3);
        c29086r.qWT = C3953i.m6289a(C5046bo.anm((String) map.get(str + ".paddingRight")), i, i2, i3);
        c29086r.cuu = C5046bo.ank((String) map.get(str + ".subType"));
        c29086r.qWX = C5046bo.m7532bc((String) map.get(str + ".cellBackgroundColor"), "");
        String str2 = str + ".if";
        if (map.containsKey(str2)) {
            c29086r.qXa = "1".equals(map.get(str2));
        } else {
            c29086r.qXa = true;
        }
        str2 = str + ".noReport";
        if (map.containsKey(str2)) {
            if (!"1".equals(map.get(str2))) {
                z = false;
            }
            c29086r.qXb = z;
        } else {
            c29086r.qXb = false;
        }
        String bc = C5046bo.m7532bc((String) map.get(str + ".layoutWidth"), "");
        str2 = C5046bo.m7532bc((String) map.get(str + ".layoutHeight"), "");
        if (TextUtils.isEmpty(bc)) {
            c29086r.qWU = 2.14748365E9f;
        } else {
            double anm = C5046bo.anm(bc);
            if (anm < 0.0d) {
                c29086r.qWU = (float) anm;
            } else {
                c29086r.qWU = C3953i.m6289a(anm, i, i2, i3);
            }
        }
        if (TextUtils.isEmpty(str2)) {
            c29086r.qWV = 2.14748365E9f;
        } else {
            double anm2 = C5046bo.anm(str2);
            if (anm2 < 0.0d) {
                c29086r.qWV = (float) anm2;
            } else {
                c29086r.qWV = C3953i.m6289a(anm2, i, i2, i3);
            }
        }
        str2 = (String) map.get(str + ".verticalAlignment");
        bc = (String) map.get(str + ".horizontalAlignment");
        if (TextUtils.isEmpty(str2)) {
            c29086r.qWY = -1;
        } else {
            c29086r.qWY = C5046bo.ank(str2);
        }
        if (TextUtils.isEmpty(bc)) {
            c29086r.qWZ = -1;
            AppMethodBeat.m2505o(37739);
            return;
        }
        c29086r.qWZ = C5046bo.ank(bc);
        AppMethodBeat.m2505o(37739);
    }

    /* renamed from: e */
    private static C29086r m6301e(Map<String, String> map, String str, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(37740);
        C29086r c13471s = new C13471s();
        c13471s.qXd = C5046bo.ank((String) map.get(str + ".subType"));
        C3953i.m6293a(c13471s, (Map) map, str, i, i2, i3);
        String str2 = str + ".layoutItems.componentItem";
        int i5 = 0;
        while (true) {
            String str3;
            if (i5 == 0) {
                str3 = str2;
            } else {
                str3 = str2 + i5;
            }
            C29086r a = C3953i.m6291a((Map) map, i, i2, i3, i4, str3);
            if (a != null) {
                if (a.qXa) {
                    c13471s.qXc.add(a);
                }
                i5++;
            } else {
                AppMethodBeat.m2505o(37740);
                return c13471s;
            }
        }
    }

    /* renamed from: f */
    private static C29086r m6302f(Map<String, String> map, String str, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(37741);
        List b = C3953i.m6296b(map, str, i, i2, i3, i4);
        C29086r c13470q = new C13470q();
        c13470q.bnR = b;
        C3953i.m6293a(c13470q, (Map) map, str, i, i2, i3);
        String str2 = str + ".layoutItems.componentItem";
        int i5 = 0;
        while (true) {
            String str3;
            if (i5 == 0) {
                str3 = str2;
            } else {
                str3 = str2 + i5;
            }
            C29086r a = C3953i.m6291a((Map) map, i, i2, i3, i4, str3);
            if (a != null) {
                if (a.qXa) {
                    c13470q.bnR.add(a);
                }
                i5++;
            } else {
                AppMethodBeat.m2505o(37741);
                return c13470q;
            }
        }
    }

    /* renamed from: g */
    private static C29086r m6303g(Map<String, String> map, String str, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(37742);
        List b = C3953i.m6296b(map, str, i, i2, i3, i4);
        C29086r c13469p = new C13469p();
        c13469p.qWN = C1338a.fromDPToPix(C4996ah.getContext(), C5046bo.ank((String) map.get(str + ".cornerRadius")));
        c13469p.bnR = b;
        C3953i.m6293a(c13469p, (Map) map, str, i, i2, i3);
        String str2 = str + ".layoutItems.componentItem";
        int i5 = 0;
        while (true) {
            String str3;
            if (i5 == 0) {
                str3 = str2;
            } else {
                str3 = str2 + i5;
            }
            C29086r a = C3953i.m6291a((Map) map, i, i2, i3, i4, str3);
            if (a != null) {
                if (a.qXa) {
                    c13469p.bnR.add(a);
                }
                i5++;
            } else {
                AppMethodBeat.m2505o(37742);
                return c13469p;
            }
        }
    }

    /* renamed from: gn */
    public static LinkedList<C3952g> m6304gn(String str, String str2) {
        AppMethodBeat.m2504i(37743);
        LinkedList<C3952g> linkedList = new LinkedList();
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(37743);
            return linkedList;
        }
        String str3 = "";
        if (!TextUtils.isEmpty(str)) {
            str = str.replaceAll("\\{\\{.*?\\}\\}", str3);
        }
        Map z = C5049br.m7595z(str, str2);
        if (z == null) {
            C4990ab.m7420w("AdLandingPagesParseHelper", " parse landingpages xml is error ,".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(37743);
            return linkedList;
        }
        String str4;
        int ank = C5046bo.ank((String) z.get("." + str2 + ".adCanvasInfo.sizeType"));
        int ank2 = C5046bo.ank((String) z.get("." + str2 + ".adCanvasInfo.basicRootFontSize"));
        int ank3 = C5046bo.ank((String) z.get("." + str2 + ".adCanvasInfo.basicWidth"));
        if (ank2 == 0 && ank == 1) {
            ank2 = ren;
        }
        if (ank3 == 0 && ank == 1) {
            ank3 = rem;
        }
        String str5 = ".adCanvasInfo.PageList.Page";
        if (C5046bo.isNullOrNil(str2) || str5.equals("adCanvasInfo")) {
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
            C3952g c3952g = new C3952g();
            c3952g.reh = C5046bo.m7532bc((String) z.get(str6 + ".backgroundCover"), "");
            c3952g.hfo = C5046bo.m7532bc((String) z.get(str6 + ".backgroundColor"), "");
            c3952g.rei = C5046bo.ank((String) z.get(new StringBuilder().append(str6).append(".backgroundCover.$isAddBlur").toString())) > 0;
            c3952g.f1283id = i;
            str5 = str6 + ".if";
            if (z.containsKey(str5)) {
                c3952g.rel = "1".equals(z.get(str5));
            } else {
                c3952g.rel = true;
            }
            if (c3952g.rel) {
                String str7 = str6 + ".componentItemList.componentItem";
                int i2 = 0;
                while (true) {
                    C29086r a;
                    if (i2 == 0) {
                        str6 = str7;
                    } else {
                        str6 = str7 + i2;
                    }
                    try {
                        a = C3953i.m6291a(z, ank, ank3, ank2, !TextUtils.isEmpty(c3952g.hfo) ? Color.parseColor(c3952g.hfo) : 0, str6);
                    } catch (Exception e) {
                        C4990ab.m7412e("AdLandingPagesParseHelper", C5046bo.m7574l(e));
                        a = C3953i.m6291a(z, ank, ank3, ank2, 0, str6);
                    }
                    if (a == null) {
                        break;
                    }
                    if (a.qXa) {
                        C3953i.m6293a(a, z, str6, ank, ank3, ank2);
                        if (a instanceof C13469p) {
                            c3952g.rek.put(a.qWO, a);
                        } else {
                            c3952g.rej.add(a);
                        }
                    } else {
                        C4990ab.m7416i("AdLandingPagesParseHelper", "comp " + a.toString() + " ifCondition is false");
                    }
                    i2++;
                }
                if (c3952g.rej.size() == 0) {
                    break;
                }
                linkedList.add(c3952g);
            }
            i++;
        }
        if (linkedList.size() > 0) {
            ((C3952g) linkedList.get(0)).mTL = true;
        }
        AppMethodBeat.m2505o(37743);
        return linkedList;
    }

    /* renamed from: a */
    private static C29086r m6291a(Map<String, String> map, int i, int i2, int i3, int i4, String str) {
        AppMethodBeat.m2504i(37744);
        int ank = C5046bo.ank((String) map.get(str + ".type"));
        C29086r c29086r = null;
        if (!C3953i.m6286Dz(ank)) {
            try {
                c29086r = C3953i.m6292a((Map) map, str, i, i2, i3, i4);
            } catch (Exception e) {
                c29086r = C3953i.m6292a((Map) map, str, i, i2, i3, 0);
            }
        } else if (C3953i.m6281DA(ank)) {
            c29086r = C3953i.m6299d(map, str, i, i2, i3, i4);
        } else if (C3953i.m6282DB(ank)) {
            c29086r = C3953i.m6301e(map, str, i, i2, i3, i4);
        } else if (C3953i.m6283DC(ank)) {
            c29086r = C3953i.m6302f(map, str, i, i2, i3, i4);
        } else if (C3953i.m6284DD(ank)) {
            c29086r = C3953i.m6303g(map, str, i, i2, i3, i4);
        } else {
            C4990ab.m7412e("AdLandingPagesParseHelper", "the type" + ank + " is not client known type");
        }
        AppMethodBeat.m2505o(37744);
        return c29086r;
    }

    /* renamed from: ai */
    public static LinkedList<C3952g> m6295ai(String str, String str2, String str3) {
        AppMethodBeat.m2504i(37745);
        String str4 = new String(str);
        try {
            JSONObject jSONObject = new JSONObject(str3);
            C4990ab.m7416i("AdLandingPagesParseHelper", "the jsonObject is " + jSONObject.toString());
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str5;
                Object next = keys.next();
                if (next != null && (next instanceof String)) {
                    str5 = (String) next;
                    String string = jSONObject.getString(str5);
                    if (!C5046bo.isNullOrNil(string)) {
                        str5 = str4.replace("{{" + str5 + "}}", "<![CDATA[" + string + "]]>");
                        str4 = str5;
                    }
                }
                str5 = str4;
                str4 = str5;
            }
        } catch (Exception e) {
            C4990ab.m7412e("AdLandingPagesParseHelper", "the json is parsed error : ".concat(String.valueOf(str)));
        }
        LinkedList gn = C3953i.m6304gn(str4, str2);
        AppMethodBeat.m2505o(37745);
        return gn;
    }

    /* renamed from: DE */
    private static boolean m6285DE(int i) {
        int i2 = i | WebView.NIGHT_MODE_COLOR;
        return i2 - WebView.NIGHT_MODE_COLOR > -1 - i2;
    }

    /* renamed from: YN */
    private static boolean m6287YN(String str) {
        AppMethodBeat.m2504i(37746);
        if (C5046bo.ank(C5046bo.m7532bc((String) C5049br.m7595z(str, "adCanvasInfo").get(".adCanvasInfo.bizId"), "")) == 1) {
            AppMethodBeat.m2505o(37746);
            return true;
        }
        AppMethodBeat.m2505o(37746);
        return false;
    }

    /* renamed from: b */
    private static boolean m6297b(String str, Context context, boolean z, int i) {
        AppMethodBeat.m2504i(37747);
        String str2 = (String) C5049br.m7595z(str, "adCanvasInfo").get(".adCanvasInfo.shareWebUrl");
        if (TextUtils.isEmpty(str2)) {
            AppMethodBeat.m2505o(37747);
            return false;
        }
        if (z) {
            try {
                str2 = C3953i.m6306m(str2, "exp=" + C18624c.abj().getExpIdByKey("Sns_Canvas_GameShare_JumpWay") + "_" + i);
            } catch (URISyntaxException e) {
            }
            C4990ab.m7416i("AdLandingPagesParseHelper", "canvas jump url ".concat(String.valueOf(str2)));
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str2);
        intent.putExtra("showShare", true);
        C25985d.m41467b(context, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.m2505o(37747);
        return true;
    }

    /* renamed from: m */
    public static String m6306m(String str, String... strArr) {
        AppMethodBeat.m2504i(37748);
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
            AppMethodBeat.m2505o(37748);
            return str;
        }
        AppMethodBeat.m2505o(37748);
        return str;
    }

    /* renamed from: n */
    public static String m6307n(String str, String... strArr) {
        AppMethodBeat.m2504i(37749);
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
                AppMethodBeat.m2505o(37749);
                return str;
            } catch (Exception e) {
                C4990ab.m7413e("AdLandingPagesParseHelper", "append url params failed, %s", e.toString());
                AppMethodBeat.m2505o(37749);
                return str;
            }
        }
        str = str + str2 + join;
        AppMethodBeat.m2505o(37749);
        return str;
    }

    private static boolean cqj() {
        AppMethodBeat.m2504i(37750);
        C5141c ll = C18624c.abi().mo17131ll("100150");
        if (ll.isValid()) {
            int i = C5046bo.getInt((String) ll.dru().get("openCanvas"), 0);
            C4990ab.m7416i("AdLandingPagesParseHelper", "canOpenGameCanvas abtest=".concat(String.valueOf(i)));
            if (i == 1) {
                AppMethodBeat.m2505o(37750);
                return true;
            }
            AppMethodBeat.m2505o(37750);
            return false;
        }
        AppMethodBeat.m2505o(37750);
        return false;
    }

    /* renamed from: y */
    public static boolean m6310y(Intent intent, Context context) {
        int i = 0;
        AppMethodBeat.m2504i(37751);
        String stringExtra = intent.getStringExtra("sns_landing_pages_xml");
        if (!TextUtils.isEmpty(stringExtra)) {
            if (TextUtils.isEmpty(stringExtra) || !C3953i.m6305go(stringExtra, "adCanvasInfo")) {
                C4990ab.m7417i("AdLandingPagesParseHelper", "invalid canvas xml %s", stringExtra);
            } else {
                String str = "";
                boolean YN = C3953i.m6287YN(stringExtra);
                if (YN) {
                    str = C18624c.abj().getExpIdByKey("Sns_Canvas_GameShare_JumpWay");
                    if (TextUtils.isEmpty(str)) {
                        i = C3953i.cqj();
                    } else {
                        int en = C18624c.abj().mo39176en("Sns_Canvas_GameShare_JumpWay", 0);
                        C4990ab.m7416i("AdLandingPagesParseHelper", "abtestvalue = ".concat(String.valueOf(en)));
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
                    AppMethodBeat.m2505o(37751);
                    return true;
                }
                boolean b = C3953i.m6297b(stringExtra, context, YN, intent.getIntExtra("sns_landig_pages_from_source", -1));
                AppMethodBeat.m2505o(37751);
                return b;
            }
        }
        AppMethodBeat.m2505o(37751);
        return false;
    }

    /* renamed from: a */
    public static boolean m6294a(TimeLineObject timeLineObject, Activity activity) {
        AppMethodBeat.m2504i(37752);
        String str = timeLineObject.rCK;
        long longValue = new BigInteger(timeLineObject.f15074Id).longValue();
        LinkedList linkedList = timeLineObject.xfI.wbK;
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str) || !C3953i.m6288YO(str)) {
                C4990ab.m7417i("AdLandingPagesParseHelper", "invalid canvas xml %s", str);
            } else {
                int i;
                String str2 = "";
                boolean YN = C3953i.m6287YN(str);
                if (YN) {
                    str2 = C18624c.abj().getExpIdByKey("Sns_Canvas_GameShare_JumpWay");
                    if (C18624c.abj().mo39176en("Sns_Canvas_GameShare_JumpWay", 0) == 0) {
                        i = 0;
                    } else {
                        i = 1;
                    }
                    if (i == 0 && C3953i.cqj()) {
                        i = 1;
                    }
                } else {
                    i = 1;
                }
                if (i != 0) {
                    C46236n kD = C13373af.cnF().mo62941kD(longValue);
                    Intent intent = new Intent();
                    if (kD != null) {
                        intent.putExtra("sns_landing_pages_share_sns_id", kD.cqA());
                        intent.putExtra("sns_landing_pages_rawSnsId", kD.cqu().f15074Id);
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
                    AppMethodBeat.m2505o(37752);
                    return true;
                }
                C3953i.m6297b(str, activity, YN, 11);
            }
        }
        AppMethodBeat.m2505o(37752);
        return false;
    }

    /* renamed from: YO */
    public static boolean m6288YO(String str) {
        AppMethodBeat.m2504i(139039);
        boolean go = C3953i.m6305go(str, "adCanvasInfo");
        AppMethodBeat.m2505o(139039);
        return go;
    }

    /* renamed from: go */
    public static boolean m6305go(String str, String str2) {
        AppMethodBeat.m2504i(37754);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            AppMethodBeat.m2505o(37754);
            return false;
        }
        if (reo == null) {
            C3953i.cqk();
        }
        if (reo == null || reo.isEmpty()) {
            AppMethodBeat.m2505o(37754);
            return false;
        }
        Map z = C5049br.m7595z(str, str2);
        if (z == null || z.isEmpty()) {
            C4990ab.m7420w("AdLandingPagesParseHelper", "invalid landingpages xml,".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(37754);
            return false;
        }
        C3954a c3954a = new C3954a();
        c3954a.rep = 0;
        c3954a.req = C5046bo.ank((String) z.get(".adCanvasInfo.type"));
        c3954a.rer = C5046bo.ank((String) z.get(".adCanvasInfo.subtype"));
        if (reo.contains(c3954a)) {
            String str3 = ".adCanvasInfo.PageList.Page";
            int i = 0;
            while (true) {
                String str4;
                c3954a.rep = 1;
                if (i == 0) {
                    str4 = str3;
                } else {
                    str4 = str3 + i;
                }
                if (z.containsKey(str4 + ".componentItemList.componentItem.type")) {
                    c3954a.req = C5046bo.ank((String) z.get(str4 + ".type"));
                    c3954a.rer = C5046bo.ank((String) z.get(str4 + ".subType"));
                    if (reo.contains(c3954a)) {
                        String str5 = str4 + ".componentItemList.componentItem";
                        c3954a.rep = 2;
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
                            c3954a.req = C5046bo.ank((String) z.get(str4 + ".type"));
                            c3954a.rer = C5046bo.ank((String) z.get(str4 + ".subType"));
                            if (reo.contains(c3954a)) {
                                i2++;
                            } else {
                                C4990ab.m7416i("AdLandingPagesParseHelper", "invalid component type ".concat(String.valueOf(c3954a)));
                                AppMethodBeat.m2505o(37754);
                                return false;
                            }
                        }
                    }
                    C4990ab.m7416i("AdLandingPagesParseHelper", "invalid page type ".concat(String.valueOf(c3954a)));
                    AppMethodBeat.m2505o(37754);
                    return false;
                }
                c3954a.rep = 2;
                for (Entry entry : z.entrySet()) {
                    if (entry.getKey() != null && ((String) entry.getKey()).matches("[\\s\\S]*\\.componentItem[0-9]*\\.type$")) {
                        String str6 = (String) entry.getKey();
                        String replace = ((String) entry.getKey()).replace(".type", ".subType");
                        c3954a.req = C5046bo.ank((String) z.get(str6));
                        c3954a.rer = C5046bo.ank((String) z.get(replace));
                        if (!reo.contains(c3954a)) {
                            C4990ab.m7416i("AdLandingPagesParseHelper", "invalid component type ".concat(String.valueOf(c3954a)));
                            AppMethodBeat.m2505o(37754);
                            return false;
                        }
                    }
                }
                AppMethodBeat.m2505o(37754);
                return true;
                i++;
            }
        } else {
            C4990ab.m7416i("AdLandingPagesParseHelper", "invalid canvas type ".concat(String.valueOf(c3954a)));
            AppMethodBeat.m2505o(37754);
            return false;
        }
    }

    private static void cqk() {
        AppMethodBeat.m2504i(37755);
        if (reo != null) {
            AppMethodBeat.m2505o(37755);
            return;
        }
        reo = new HashSet();
        InputStream inputStream = null;
        try {
            inputStream = C4996ah.getContext().getAssets().open("sns/canvas_valid_type.xml");
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
                        if (C5046bo.getInt(newPullParser.getAttributeValue(null, "android"), 0) == 1) {
                            i3 = C5046bo.getInt(newPullParser.getAttributeValue(null, "val"), -1);
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
                                    C3954a c3954a = new C3954a();
                                    c3954a.rep = i2;
                                    c3954a.req = i;
                                    c3954a.rer = i3;
                                    reo.add(c3954a);
                                    C4990ab.m7416i("AdLandingPagesParseHelper", "valid canvas type ".concat(String.valueOf(c3954a)));
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
                    AppMethodBeat.m2505o(37755);
                    return;
                } catch (IOException e) {
                    AppMethodBeat.m2505o(37755);
                    return;
                }
            }
        } catch (IOException e2) {
            C4990ab.m7412e("AdLandingPagesParseHelper", C5046bo.m7574l(e2));
            if (inputStream != null) {
                try {
                    inputStream.close();
                    AppMethodBeat.m2505o(37755);
                    return;
                } catch (IOException e3) {
                    AppMethodBeat.m2505o(37755);
                    return;
                }
            }
        } catch (XmlPullParserException e4) {
            C4990ab.m7412e("AdLandingPagesParseHelper", C5046bo.m7574l(e4));
            if (inputStream != null) {
                try {
                    inputStream.close();
                    AppMethodBeat.m2505o(37755);
                    return;
                } catch (IOException e5) {
                    AppMethodBeat.m2505o(37755);
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
            AppMethodBeat.m2505o(37755);
        }
        AppMethodBeat.m2505o(37755);
    }

    /* renamed from: y */
    public static String m6309y(C46236n c46236n) {
        AppMethodBeat.m2504i(37756);
        if (c46236n == null) {
            C4990ab.m7412e("AdLandingPagesParseHelper", "the snsinfo is null");
            AppMethodBeat.m2505o(37756);
            return null;
        } else if (c46236n.mo74253DI(32)) {
            C43570e crd = c46236n.crd();
            if (crd == null) {
                C4990ab.m7412e("AdLandingPagesParseHelper", "the adSnsInfo is null");
                AppMethodBeat.m2505o(37756);
                return null;
            }
            C21984b cqo = c46236n.cqo();
            if (cqo == null) {
                C4990ab.m7412e("AdLandingPagesParseHelper", "the adxml is null");
                AppMethodBeat.m2505o(37756);
                return null;
            }
            C21980a cqq = c46236n.cqq();
            if (cqq == null) {
                C4990ab.m7412e("AdLandingPagesParseHelper", "the adInfo is null");
                AppMethodBeat.m2505o(37756);
                return null;
            } else if (!cqo.coK()) {
                C4990ab.m7412e("AdLandingPagesParseHelper", "the snsinfo is not a landingpage");
                AppMethodBeat.m2505o(37756);
                return null;
            } else if (cqq.qTN == null || cqq.qTN.size() == 0) {
                C4990ab.m7412e("AdLandingPagesParseHelper", "the mappedCanvasCardExt is empty");
                AppMethodBeat.m2505o(37756);
                return null;
            } else {
                String v = C3953i.m6308v(crd.field_adxml, cqq.qTN);
                AppMethodBeat.m2505o(37756);
                return v;
            }
        } else {
            C4990ab.m7412e("AdLandingPagesParseHelper", "the snsinfo is not a ad");
            AppMethodBeat.m2505o(37756);
            return null;
        }
    }

    /* renamed from: v */
    private static String m6308v(String str, Map<String, String> map) {
        AppMethodBeat.m2504i(37757);
        if (str == null || str.length() == 0) {
            C4990ab.m7412e("AdLandingPagesParseHelper", "the adLandingPagesXml is empty");
            AppMethodBeat.m2505o(37757);
            return null;
        } else if (map == null || map.size() == 0) {
            C4990ab.m7412e("AdLandingPagesParseHelper", "the mappedCanvasCardExt is empty");
            AppMethodBeat.m2505o(37757);
            return null;
        } else {
            LinkedList gn = C3953i.m6304gn(str, "adxml");
            for (String str2 : map.keySet()) {
                if (!C5046bo.isNullOrNil(str2)) {
                    String str3 = (String) map.get(str2);
                    if (!C5046bo.isNullOrNil(str3)) {
                        String str4;
                        Iterator it = gn.iterator();
                        String str5 = null;
                        while (it.hasNext()) {
                            Iterator it2 = ((C3952g) it.next()).rej.iterator();
                            while (it2.hasNext()) {
                                C29086r c29086r = (C29086r) it2.next();
                                if ((c29086r instanceof C43567e) && !C5046bo.isNullOrNil(((C43567e) c29086r).kcM) && ((C43567e) c29086r).kcM.equals(str2)) {
                                    str4 = ((C43567e) c29086r).kdB;
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
                        if (!C5046bo.isNullOrNil(str4)) {
                            C4990ab.m7416i("AdLandingPagesParseHelper", "old card ext is " + str4 + " and new card ext is " + str3);
                            str = str.replace(str4, str3);
                            try {
                                str = str.replace(C5046bo.ani(str4), C5046bo.ani(str3));
                            } catch (Exception e) {
                                C4990ab.m7412e("AdLandingPagesParseHelper", "the xml is error");
                            }
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(37757);
            return str;
        }
    }

    /* renamed from: dj */
    public static void m6300dj(List<C13437h> list) {
        AppMethodBeat.m2504i(37758);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.m2505o(37758);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (C13437h c13437h : list) {
            if (C3953i.m6286Dz(c13437h.cpv().type)) {
                arrayList.addAll(((C3910a) c13437h).cpt());
            }
        }
        if (!arrayList.isEmpty()) {
            C3953i.m6300dj(arrayList);
            list.addAll(arrayList);
        }
        AppMethodBeat.m2505o(37758);
    }
}
