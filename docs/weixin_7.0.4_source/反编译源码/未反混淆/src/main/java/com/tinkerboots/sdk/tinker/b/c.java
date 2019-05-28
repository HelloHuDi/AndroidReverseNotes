package com.tinkerboots.sdk.tinker.b;

import android.content.Context;
import android.content.Intent;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.lib.d.b;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import java.io.File;
import java.util.List;

public final class c extends b {
    public c(Context context) {
        super(context);
    }

    public final void ad(Intent intent) {
        AppMethodBeat.i(NativeProtocol.MESSAGE_GET_INSTALL_DATA_REPLY);
        super.ad(intent);
        AppMethodBeat.o(NativeProtocol.MESSAGE_GET_INSTALL_DATA_REPLY);
    }

    public final void a(File file, boolean z, long j) {
        AppMethodBeat.i(NativeProtocol.MESSAGE_GET_LIKE_STATUS_REQUEST);
        super.a(file, z, j);
        AppMethodBeat.o(NativeProtocol.MESSAGE_GET_LIKE_STATUS_REQUEST);
    }

    public final void a(File file, List<File> list, Throwable th) {
        AppMethodBeat.i(NativeProtocol.MESSAGE_GET_LIKE_STATUS_REPLY);
        super.a(file, (List) list, th);
        AppMethodBeat.o(NativeProtocol.MESSAGE_GET_LIKE_STATUS_REPLY);
    }

    public final void a(File file, Throwable th) {
        AppMethodBeat.i(NativeProtocol.MESSAGE_GET_AK_SEAMLESS_TOKEN_REQUEST);
        super.a(file, th);
        AppMethodBeat.o(NativeProtocol.MESSAGE_GET_AK_SEAMLESS_TOKEN_REQUEST);
    }

    public final void a(File file, String str, String str2) {
        AppMethodBeat.i(NativeProtocol.MESSAGE_GET_AK_SEAMLESS_TOKEN_REPLY);
        super.a(file, str, str2);
        AppMethodBeat.o(NativeProtocol.MESSAGE_GET_AK_SEAMLESS_TOKEN_REPLY);
    }

    public final void e(File file, int i) {
        AppMethodBeat.i(NativeProtocol.MESSAGE_GET_LOGIN_STATUS_REQUEST);
        super.e(file, i);
        AppMethodBeat.o(NativeProtocol.MESSAGE_GET_LOGIN_STATUS_REQUEST);
    }

    public final void a(File file, File file2, String str, int i) {
        AppMethodBeat.i(NativeProtocol.MESSAGE_GET_LOGIN_STATUS_REPLY);
        super.a(file, file2, str, i);
        AppMethodBeat.o(NativeProtocol.MESSAGE_GET_LOGIN_STATUS_REPLY);
    }

    public final void a(File file, SharePatchInfo sharePatchInfo, String str) {
        AppMethodBeat.i(65548);
        super.a(file, sharePatchInfo, str);
        AppMethodBeat.o(65548);
    }
}
