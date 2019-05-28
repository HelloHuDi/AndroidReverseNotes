package com.tencent.mm.plugin.emojicapture.model.a;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.emojicapture.api.a;
import com.tencent.mm.plugin.emojicapture.model.c.g;
import com.tencent.mm.plugin.emojicapture.model.c.h;
import com.tencent.mm.plugin.emojicapture.model.c.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.File;

@l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020 H\u0016J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%J\u000e\u0010&\u001a\u00020#2\u0006\u0010$\u001a\u00020%J\u000e\u0010'\u001a\u00020\u00042\u0006\u0010$\u001a\u00020%J\u000e\u0010(\u001a\u00020\u00042\u0006\u0010$\u001a\u00020%J\u000e\u0010)\u001a\u00020\u00042\u0006\u0010$\u001a\u00020%J\b\u0010*\u001a\u00020 H\u0002J\u0018\u0010+\u001a\u00020 2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u0004H\u0002J\u000e\u0010.\u001a\u00020 2\u0006\u0010$\u001a\u00020%R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0011\u0010\u0011\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0011\u0010\u0013\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0011\u0010\u0015\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0014\u0010\u0017\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0014\u0010\u0019\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006R\u0014\u0010\u001b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006¨\u0006/"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerResHelper;", "Lcom/tencent/mm/plugin/emojicapture/api/IEmojiStickerRes;", "()V", "assetsRoot", "", "getAssetsRoot", "()Ljava/lang/String;", "compressConfigFile", "getCompressConfigFile", "configFile", "getConfigFile", "configFilePath", "getConfigFilePath", "itemConfigFile", "getItemConfigFile", "localRoot", "getLocalRoot", "localStickerRes", "getLocalStickerRes", "localStickerTmp", "getLocalStickerTmp", "tempConfigPath", "getTempConfigPath", "typePrefix", "getTypePrefix", "versionFile", "getVersionFile", "zipFile", "getZipFile", "checkAssetsVersion", "", "checkResUpdate", "", "copyResFromAssets", "getItemConfig", "Lcom/tencent/mm/plugin/emojicapture/model/xml/ResourceFileConfig;", "subType", "", "getItemConfigTemp", "itemConfigFilePath", "itemConfigTempFilePath", "itemDirPath", "unCompressFromTemp", "unCompressItem", "fromFolder", "toFolder", "unCompressSubType", "plugin-emojicapture_release"})
public final class e implements a {
    private static final String lhV = lhV;
    private static final String lhW = (b.eSk + "sticker/");
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
    public static final e lii = new e();

    static {
        AppMethodBeat.i(2651);
        AppMethodBeat.o(2651);
    }

    private e() {
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
        AppMethodBeat.i(2647);
        ab.i(f.TAG, "copyResFromAssets: ");
        long yz = bo.yz();
        com.tencent.mm.vfs.e.cu(lhW);
        ab.i(f.TAG, "copyResFromAssets: cost " + bo.az(yz));
        AppMethodBeat.o(2647);
    }

    static void dO(String str, String str2) {
        AppMethodBeat.i(2648);
        com.tencent.mm.vfs.e.cu(str2);
        com.tencent.mm.vfs.e.is(str, str2);
        String str3 = str2 + File.separator + lig;
        if (com.tencent.mm.vfs.e.ct(str3)) {
            g gVar = new g();
            com.tencent.mm.plugin.emojicapture.model.c.a.a aVar = com.tencent.mm.plugin.emojicapture.model.c.a.ljn;
            com.tencent.mm.plugin.emojicapture.model.c.a.a.a(str3, gVar);
            for (h hVar : gVar.ljF) {
                com.tencent.mm.vfs.e.y(str2 + hVar.ljG, str2 + hVar.ljH);
            }
        }
        AppMethodBeat.o(2648);
    }

    public static String uw(int i) {
        AppMethodBeat.i(2649);
        String str = lhX + lic + i + IOUtils.DIR_SEPARATOR_UNIX + lih;
        AppMethodBeat.o(2649);
        return str;
    }

    public static i ux(int i) {
        AppMethodBeat.i(2650);
        String str = lhY + lic + i + IOUtils.DIR_SEPARATOR_UNIX + lih;
        i iVar = new i();
        com.tencent.mm.plugin.emojicapture.model.c.a.a aVar = com.tencent.mm.plugin.emojicapture.model.c.a.ljn;
        com.tencent.mm.plugin.emojicapture.model.c.a.a.a(str, iVar);
        AppMethodBeat.o(2650);
        return iVar;
    }
}
