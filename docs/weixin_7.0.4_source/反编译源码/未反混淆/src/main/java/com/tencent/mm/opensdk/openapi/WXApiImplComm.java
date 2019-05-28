package com.tencent.mm.opensdk.openapi;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.constants.ConstantsAPI.Token;
import com.tencent.mm.opensdk.utils.Log;

class WXApiImplComm {
    private static final String TAG = "MicroMsg.SDK.WXMsgImplComm";
    private static final String WX_APP_SIGNATURE = "308202eb30820254a00302010202044d36f7a4300d06092a864886f70d01010505003081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e74301e170d3131303131393134333933325a170d3431303131313134333933325a3081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100c05f34b231b083fb1323670bfbe7bdab40c0c0a6efc87ef2072a1ff0d60cc67c8edb0d0847f210bea6cbfaa241be70c86daf56be08b723c859e52428a064555d80db448cdcacc1aea2501eba06f8bad12a4fa49d85cacd7abeb68945a5cb5e061629b52e3254c373550ee4e40cb7c8ae6f7a8151ccd8df582d446f39ae0c5e930203010001300d06092a864886f70d0101050500038181009c8d9d7f2f908c42081b4c764c377109a8b2c70582422125ce545842d5f520aea69550b6bd8bfd94e987b75a3077eb04ad341f481aac266e89d3864456e69fba13df018acdc168b9a19dfd7ad9d9cc6f6ace57c746515f71234df3a053e33ba93ece5cd0fc15f3e389a3f365588a9fcb439e069d3629cd7732a13fff7b891499";

    private WXApiImplComm() {
        AppMethodBeat.i(128090);
        RuntimeException runtimeException = new RuntimeException(getClass().getSimpleName() + " should not be instantiated");
        AppMethodBeat.o(128090);
        throw runtimeException;
    }

    public static boolean isIntentFromWx(Intent intent, String str) {
        AppMethodBeat.i(128091);
        if (intent == null) {
            AppMethodBeat.o(128091);
            return false;
        }
        String stringExtra = intent.getStringExtra(Token.WX_TOKEN_KEY);
        if (stringExtra == null || !stringExtra.equals(str)) {
            AppMethodBeat.o(128091);
            return false;
        }
        AppMethodBeat.o(128091);
        return true;
    }

    public static boolean validateAppSignature(Context context, Signature[] signatureArr, boolean z) {
        AppMethodBeat.i(128093);
        if (z) {
            for (Signature toCharsString : signatureArr) {
                String toLowerCase = toCharsString.toCharsString().toLowerCase();
                Log.d(TAG, "check signature:".concat(String.valueOf(toLowerCase)));
                if (toLowerCase.equals(WX_APP_SIGNATURE)) {
                    Log.d(TAG, "pass");
                    AppMethodBeat.o(128093);
                    return true;
                }
            }
            AppMethodBeat.o(128093);
            return false;
        }
        Log.d(TAG, "ignore wechat app signature validation");
        AppMethodBeat.o(128093);
        return true;
    }

    public static boolean validateAppSignatureForPackage(Context context, String str, boolean z) {
        AppMethodBeat.i(128092);
        if (z) {
            try {
                boolean validateAppSignature = validateAppSignature(context, context.getPackageManager().getPackageInfo(str, 64).signatures, z);
                AppMethodBeat.o(128092);
                return validateAppSignature;
            } catch (NameNotFoundException e) {
                AppMethodBeat.o(128092);
                return false;
            }
        }
        Log.d(TAG, "ignore wechat app signature validation");
        AppMethodBeat.o(128092);
        return true;
    }
}
