package com.tencent.p177mm.protocal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.FaceOffUtil;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/* renamed from: com.tencent.mm.protocal.z */
public final class C4851z {
    public int ver;
    public String vyO;
    public String vyP;

    /* renamed from: O */
    public static void m7216O(String str, String str2, int i) {
        AppMethodBeat.m2504i(58873);
        C4990ab.m7411d("MicroMsg.RsaInfo", "summercert dkcert saveRsaInfo ver:%d keye:%s keyn:%s  ", Integer.valueOf(i), str, str2);
        Editor edit = C4996ah.getContext().getSharedPreferences("rsa_public_key_prefs", C1448h.m3078Mu()).edit();
        edit.putString("keye", str);
        edit.putString("keyn", str2);
        edit.putInt("version", i);
        edit.putInt("client_version", C7243d.vxo);
        edit.commit();
        AppMethodBeat.m2505o(58873);
    }

    public static C4851z dmv() {
        AppMethodBeat.m2504i(58874);
        SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("rsa_public_key_prefs", C1448h.m3078Mu());
        C4851z c4851z = new C4851z(sharedPreferences.getString("keye", ""), sharedPreferences.getString("keyn", ""), sharedPreferences.getInt("version", 0));
        int i = sharedPreferences.getInt("client_version", 0);
        if (!c4851z.dmy()) {
            if (i > 637665843) {
                AppMethodBeat.m2505o(58874);
                return c4851z;
            }
            boolean commit = sharedPreferences.edit().clear().commit();
            C7053e.pXa.mo8378a(148, 38, 1, false);
            C4990ab.m7417i("MicroMsg.RsaInfo", "summercert clear old rsa lastClientVer[%d] nowVer[%d], commit[%b]", Integer.valueOf(i), Integer.valueOf(C7243d.vxo), Boolean.valueOf(commit));
        }
        C7053e.pXa.mo8378a(148, 39, 1, false);
        C4990ab.m7411d("MicroMsg.RsaInfo", "summercert default req keye[%s], keyn[%s], ver[%d]", "010001", "BB5FB9017F1CA20257A0384C7C87F568F618FA2697A7C12821FCEC3C97BA2509576944A67D4B4FA5A4B9FB4DB9DDB687FE3354B607E1FD0DE58E39F05B772F5E4976A6E83F6BE1DDD5F0D02A237B6CF5DD957B76EF9BF29B523EFA1041A87D3469590F473C9EC4B448034A3EC0C4B221B960F346FDCDA3BBF3CD984FBBDE97FAFE26FC317E4ACC653688F407E5BE93D41DE8981C113069A21329119F65578E0614957AFE0E0CF52A4A38A85CFD163424945C28CD181A3BEB198DF54303ED070C90419F1C31703C93448F1B381623EE6AED759A21865B5F612EBC9FD367AC4AD781D0E99DD4D7E68664989AF71E9A9342A38277018AA8672A465C8225CACD2CB9".substring(0, 4) + "_" + "BB5FB9017F1CA20257A0384C7C87F568F618FA2697A7C12821FCEC3C97BA2509576944A67D4B4FA5A4B9FB4DB9DDB687FE3354B607E1FD0DE58E39F05B772F5E4976A6E83F6BE1DDD5F0D02A237B6CF5DD957B76EF9BF29B523EFA1041A87D3469590F473C9EC4B448034A3EC0C4B221B960F346FDCDA3BBF3CD984FBBDE97FAFE26FC317E4ACC653688F407E5BE93D41DE8981C113069A21329119F65578E0614957AFE0E0CF52A4A38A85CFD163424945C28CD181A3BEB198DF54303ED070C90419F1C31703C93448F1B381623EE6AED759A21865B5F612EBC9FD367AC4AD781D0E99DD4D7E68664989AF71E9A9342A38277018AA8672A465C8225CACD2CB9".substring(507, ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_MINIQBFAILED), Integer.valueOf(FaceOffUtil.NO_HOLE_TRIANGLE_COUNT_FACE_AVERAGE));
        c4851z = new C4851z("010001", "BB5FB9017F1CA20257A0384C7C87F568F618FA2697A7C12821FCEC3C97BA2509576944A67D4B4FA5A4B9FB4DB9DDB687FE3354B607E1FD0DE58E39F05B772F5E4976A6E83F6BE1DDD5F0D02A237B6CF5DD957B76EF9BF29B523EFA1041A87D3469590F473C9EC4B448034A3EC0C4B221B960F346FDCDA3BBF3CD984FBBDE97FAFE26FC317E4ACC653688F407E5BE93D41DE8981C113069A21329119F65578E0614957AFE0E0CF52A4A38A85CFD163424945C28CD181A3BEB198DF54303ED070C90419F1C31703C93448F1B381623EE6AED759A21865B5F612EBC9FD367AC4AD781D0E99DD4D7E68664989AF71E9A9342A38277018AA8672A465C8225CACD2CB9", FaceOffUtil.NO_HOLE_TRIANGLE_COUNT_FACE_AVERAGE);
        AppMethodBeat.m2505o(58874);
        return c4851z;
    }

    public static C4851z dmw() {
        AppMethodBeat.m2504i(58875);
        C4851z c4851z = new C4851z("010001", "D8D2AE73FF601B93B1471B35870A1B59D7649EEA815CDD8CE5496BBD0C6CFE19C0E082F4E513B615C6030CCFCE3153E25AA00E8156D0311AF72ABBB9BBEC8B1D3751592234B1A621CA774E2EC50047A93FA0BC60DF0C10E8A65C3B29D13167EC217FC6A29034494870705CBF4AC929FBA0E1E656A8F8B50E779AD89BB4EEF6FF", 125);
        AppMethodBeat.m2505o(58875);
        return c4851z;
    }

    public static C4851z dmx() {
        AppMethodBeat.m2504i(58876);
        C4990ab.m7411d("MicroMsg.RsaInfo", "summercert default base keye[%s], keyn[%s], ver[%d]", "010001", "AF64B69AA6F14D838E22F72BBAD6DCDBDC7B2262617C553968EFC0CF2E73FD1714597F9E6BDF1661113B2DC82FDB77286E35822A187380640F5C107DF86CF35FFA3811BDD7012C4C41F5803F644DEE7CF3F037F0BE239A2FBE99F4E002C636759B65BDE41ECF15E594CE28793623FEE039B0E6D3C14131B8AE7BE8C01DF4D03D31C6DCDC228A9A35F74FF4DBB51F8A4E57490965D1074871CE3DB450966A444CF1BE85005D5089752C13D074DAE0172E2BAD3717357A6B49E7A156A6A4EDCFB1BA70C6073431AD0BE0FBBC3C53DCF746663733298385EB5105CA17796A62DAF110380061B1ECF21E686F7467D4327EE6393D2F666C973EA4651AEC32FEC52885".substring(0, 4) + "_" + "AF64B69AA6F14D838E22F72BBAD6DCDBDC7B2262617C553968EFC0CF2E73FD1714597F9E6BDF1661113B2DC82FDB77286E35822A187380640F5C107DF86CF35FFA3811BDD7012C4C41F5803F644DEE7CF3F037F0BE239A2FBE99F4E002C636759B65BDE41ECF15E594CE28793623FEE039B0E6D3C14131B8AE7BE8C01DF4D03D31C6DCDC228A9A35F74FF4DBB51F8A4E57490965D1074871CE3DB450966A444CF1BE85005D5089752C13D074DAE0172E2BAD3717357A6B49E7A156A6A4EDCFB1BA70C6073431AD0BE0FBBC3C53DCF746663733298385EB5105CA17796A62DAF110380061B1ECF21E686F7467D4327EE6393D2F666C973EA4651AEC32FEC52885".substring(507, ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_MINIQBFAILED), Integer.valueOf(183));
        C4851z c4851z = new C4851z("010001", "AF64B69AA6F14D838E22F72BBAD6DCDBDC7B2262617C553968EFC0CF2E73FD1714597F9E6BDF1661113B2DC82FDB77286E35822A187380640F5C107DF86CF35FFA3811BDD7012C4C41F5803F644DEE7CF3F037F0BE239A2FBE99F4E002C636759B65BDE41ECF15E594CE28793623FEE039B0E6D3C14131B8AE7BE8C01DF4D03D31C6DCDC228A9A35F74FF4DBB51F8A4E57490965D1074871CE3DB450966A444CF1BE85005D5089752C13D074DAE0172E2BAD3717357A6B49E7A156A6A4EDCFB1BA70C6073431AD0BE0FBBC3C53DCF746663733298385EB5105CA17796A62DAF110380061B1ECF21E686F7467D4327EE6393D2F666C973EA4651AEC32FEC52885", 183);
        AppMethodBeat.m2505o(58876);
        return c4851z;
    }

    public final boolean dmy() {
        AppMethodBeat.m2504i(58877);
        if (this.ver == 0 || C5046bo.isNullOrNil(this.vyO) || C5046bo.isNullOrNil(this.vyP)) {
            AppMethodBeat.m2505o(58877);
            return true;
        }
        AppMethodBeat.m2505o(58877);
        return false;
    }

    C4851z(String str, String str2, int i) {
        this.vyO = str;
        this.vyP = str2;
        this.ver = i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00bc A:{SYNTHETIC, Splitter:B:21:0x00bc} */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x00b2 A:{SYNTHETIC, Splitter:B:15:0x00b2} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean dmz() {
        Throwable e;
        Throwable th;
        boolean z = false;
        AppMethodBeat.m2504i(58878);
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(C6457e.eSn + "DefaultRSA.java");
            try {
                fileWriter.write("package com.tencent.mm.protocal;\n\n");
                fileWriter.write("/**\n *\n * @ClientVersion: " + C5058f.CLIENT_VERSION + IOUtils.LINE_SEPARATOR_UNIX);
                fileWriter.write(" * @DumpTime: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " \n */\n");
                fileWriter.write("public final class DefaultRSA {\n");
                fileWriter.write("\n\tpublic final static int BASE_RSA_PUBLIC_VERSION = 183;");
                fileWriter.write("\n\tpublic final static String BASE_RSA_PUBLIC_KEYN = \"AF64B69AA6F14D838E22F72BBAD6DCDBDC7B2262617C553968EFC0CF2E73FD1714597F9E6BDF1661113B2DC82FDB77286E35822A187380640F5C107DF86CF35FFA3811BDD7012C4C41F5803F644DEE7CF3F037F0BE239A2FBE99F4E002C636759B65BDE41ECF15E594CE28793623FEE039B0E6D3C14131B8AE7BE8C01DF4D03D31C6DCDC228A9A35F74FF4DBB51F8A4E57490965D1074871CE3DB450966A444CF1BE85005D5089752C13D074DAE0172E2BAD3717357A6B49E7A156A6A4EDCFB1BA70C6073431AD0BE0FBBC3C53DCF746663733298385EB5105CA17796A62DAF110380061B1ECF21E686F7467D4327EE6393D2F666C973EA4651AEC32FEC52885\";");
                fileWriter.write("\n\tpublic final static String BASE_RSA_PUBLIC_KEYE = \"010001\";\n");
                fileWriter.write("\n\tpublic final static int REQ_RSA_PUBLIC_VERSION = 184;");
                fileWriter.write("\n\tpublic final static String REQ_RSA_PUBLIC_KEYN = \"BB5FB9017F1CA20257A0384C7C87F568F618FA2697A7C12821FCEC3C97BA2509576944A67D4B4FA5A4B9FB4DB9DDB687FE3354B607E1FD0DE58E39F05B772F5E4976A6E83F6BE1DDD5F0D02A237B6CF5DD957B76EF9BF29B523EFA1041A87D3469590F473C9EC4B448034A3EC0C4B221B960F346FDCDA3BBF3CD984FBBDE97FAFE26FC317E4ACC653688F407E5BE93D41DE8981C113069A21329119F65578E0614957AFE0E0CF52A4A38A85CFD163424945C28CD181A3BEB198DF54303ED070C90419F1C31703C93448F1B381623EE6AED759A21865B5F612EBC9FD367AC4AD781D0E99DD4D7E68664989AF71E9A9342A38277018AA8672A465C8225CACD2CB9\";");
                fileWriter.write("\n\tpublic final static String REQ_RSA_PUBLIC_KEYE = \"010001\";\n\n}\n");
                z = true;
                try {
                    fileWriter.close();
                } catch (Exception e2) {
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    C4990ab.printErrStackTrace("MicroMsg.RsaInfo", e, "", new Object[0]);
                    if (fileWriter != null) {
                    }
                    AppMethodBeat.m2505o(58878);
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileWriter != null) {
                    }
                    AppMethodBeat.m2505o(58878);
                    throw th;
                }
            }
        } catch (Exception e4) {
            e = e4;
            fileWriter = null;
            C4990ab.printErrStackTrace("MicroMsg.RsaInfo", e, "", new Object[0]);
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (Exception e5) {
                }
            }
            AppMethodBeat.m2505o(58878);
            return z;
        } catch (Throwable th3) {
            th = th3;
            fileWriter = null;
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (Exception e6) {
                }
            }
            AppMethodBeat.m2505o(58878);
            throw th;
        }
        AppMethodBeat.m2505o(58878);
        return z;
    }
}
