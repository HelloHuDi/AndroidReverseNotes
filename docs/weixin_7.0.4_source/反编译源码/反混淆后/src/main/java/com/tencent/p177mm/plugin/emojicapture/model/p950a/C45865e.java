package com.tencent.p177mm.plugin.emojicapture.model.p950a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.p248j.C1761b;
import com.tencent.p177mm.plugin.emojicapture.api.C42969a;
import com.tencent.p177mm.plugin.emojicapture.model.p1254c.C42974g;
import com.tencent.p177mm.plugin.emojicapture.model.p1254c.C42975h;
import com.tencent.p177mm.plugin.emojicapture.model.p1254c.C42976i;
import com.tencent.p177mm.plugin.emojicapture.model.p1254c.C45869a;
import com.tencent.p177mm.plugin.emojicapture.model.p1254c.C45869a.C20432a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.File;
import p000a.C0220l;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020 H\u0016J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%J\u000e\u0010&\u001a\u00020#2\u0006\u0010$\u001a\u00020%J\u000e\u0010'\u001a\u00020\u00042\u0006\u0010$\u001a\u00020%J\u000e\u0010(\u001a\u00020\u00042\u0006\u0010$\u001a\u00020%J\u000e\u0010)\u001a\u00020\u00042\u0006\u0010$\u001a\u00020%J\b\u0010*\u001a\u00020 H\u0002J\u0018\u0010+\u001a\u00020 2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u0004H\u0002J\u000e\u0010.\u001a\u00020 2\u0006\u0010$\u001a\u00020%R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0011\u0010\u0011\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0011\u0010\u0013\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0011\u0010\u0015\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0014\u0010\u0017\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0014\u0010\u0019\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006R\u0014\u0010\u001b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006¨\u0006/"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerResHelper;", "Lcom/tencent/mm/plugin/emojicapture/api/IEmojiStickerRes;", "()V", "assetsRoot", "", "getAssetsRoot", "()Ljava/lang/String;", "compressConfigFile", "getCompressConfigFile", "configFile", "getConfigFile", "configFilePath", "getConfigFilePath", "itemConfigFile", "getItemConfigFile", "localRoot", "getLocalRoot", "localStickerRes", "getLocalStickerRes", "localStickerTmp", "getLocalStickerTmp", "tempConfigPath", "getTempConfigPath", "typePrefix", "getTypePrefix", "versionFile", "getVersionFile", "zipFile", "getZipFile", "checkAssetsVersion", "", "checkResUpdate", "", "copyResFromAssets", "getItemConfig", "Lcom/tencent/mm/plugin/emojicapture/model/xml/ResourceFileConfig;", "subType", "", "getItemConfigTemp", "itemConfigFilePath", "itemConfigTempFilePath", "itemDirPath", "unCompressFromTemp", "unCompressItem", "fromFolder", "toFolder", "unCompressSubType", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.model.a.e */
public final class C45865e implements C42969a {
    private static final String lhV = lhV;
    private static final String lhW = (C1761b.eSk + "sticker/");
    static final String lhX = (lhW + "res/");
    static final String lhY = (lhW + "compress/");
    private static final String lhZ = lhZ;
    private static final String lia = lia;
    static final String lic = lic;
    private static final String lid = lid;
    private static final String lie = (lhX + "59_0/" + lid);
    private static final String lif = (lhY + "59_0/" + lid);
    private static final String lig = lig;
    private static final String lih = lih;
    public static final C45865e lii = new C45865e();

    static {
        AppMethodBeat.m2504i(2651);
        AppMethodBeat.m2505o(2651);
    }

    private C45865e() {
    }

    public static String bnz() {
        return lhW;
    }

    public static String bnA() {
        return lhY;
    }

    public static String bnB() {
        return lif;
    }

    public static void bnC() {
        AppMethodBeat.m2504i(2647);
        C4990ab.m7416i(C11612f.TAG, "copyResFromAssets: ");
        long yz = C5046bo.m7588yz();
        C5730e.m8629cu(lhW);
        C4990ab.m7416i(C11612f.TAG, "copyResFromAssets: cost " + C5046bo.m7525az(yz));
        AppMethodBeat.m2505o(2647);
    }

    /* renamed from: dO */
    static void m84968dO(String str, String str2) {
        AppMethodBeat.m2504i(2648);
        C5730e.m8629cu(str2);
        C5730e.m8634is(str, str2);
        String str3 = str2 + File.separator + lig;
        if (C5730e.m8628ct(str3)) {
            C42974g c42974g = new C42974g();
            C20432a c20432a = C45869a.ljn;
            C20432a.m31586a(str3, c42974g);
            for (C42975h c42975h : c42974g.ljF) {
                C5730e.m8644y(str2 + c42975h.ljG, str2 + c42975h.ljH);
            }
        }
        AppMethodBeat.m2505o(2648);
    }

    /* renamed from: uw */
    public static String m84969uw(int i) {
        AppMethodBeat.m2504i(2649);
        String str = lhX + lic + i + IOUtils.DIR_SEPARATOR_UNIX + lih;
        AppMethodBeat.m2505o(2649);
        return str;
    }

    /* renamed from: ux */
    public static C42976i m84970ux(int i) {
        AppMethodBeat.m2504i(2650);
        String str = lhY + lic + i + IOUtils.DIR_SEPARATOR_UNIX + lih;
        C42976i c42976i = new C42976i();
        C20432a c20432a = C45869a.ljn;
        C20432a.m31586a(str, c42976i);
        AppMethodBeat.m2505o(2650);
        return c42976i;
    }
}
