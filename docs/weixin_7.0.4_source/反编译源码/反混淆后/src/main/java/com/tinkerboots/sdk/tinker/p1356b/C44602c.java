package com.tinkerboots.sdk.tinker.p1356b;

import android.content.Context;
import android.content.Intent;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.lib.p1353d.C24434b;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import java.io.File;
import java.util.List;

/* renamed from: com.tinkerboots.sdk.tinker.b.c */
public final class C44602c extends C24434b {
    public C44602c(Context context) {
        super(context);
    }

    /* renamed from: ad */
    public final void mo40783ad(Intent intent) {
        AppMethodBeat.m2504i(NativeProtocol.MESSAGE_GET_INSTALL_DATA_REPLY);
        super.mo40783ad(intent);
        AppMethodBeat.m2505o(NativeProtocol.MESSAGE_GET_INSTALL_DATA_REPLY);
    }

    /* renamed from: a */
    public final void mo40782a(File file, boolean z, long j) {
        AppMethodBeat.m2504i(NativeProtocol.MESSAGE_GET_LIKE_STATUS_REQUEST);
        super.mo40782a(file, z, j);
        AppMethodBeat.m2505o(NativeProtocol.MESSAGE_GET_LIKE_STATUS_REQUEST);
    }

    /* renamed from: a */
    public final void mo40781a(File file, List<File> list, Throwable th) {
        AppMethodBeat.m2504i(NativeProtocol.MESSAGE_GET_LIKE_STATUS_REPLY);
        super.mo40781a(file, (List) list, th);
        AppMethodBeat.m2505o(NativeProtocol.MESSAGE_GET_LIKE_STATUS_REPLY);
    }

    /* renamed from: a */
    public final void mo40780a(File file, Throwable th) {
        AppMethodBeat.m2504i(NativeProtocol.MESSAGE_GET_AK_SEAMLESS_TOKEN_REQUEST);
        super.mo40780a(file, th);
        AppMethodBeat.m2505o(NativeProtocol.MESSAGE_GET_AK_SEAMLESS_TOKEN_REQUEST);
    }

    /* renamed from: a */
    public final void mo40779a(File file, String str, String str2) {
        AppMethodBeat.m2504i(NativeProtocol.MESSAGE_GET_AK_SEAMLESS_TOKEN_REPLY);
        super.mo40779a(file, str, str2);
        AppMethodBeat.m2505o(NativeProtocol.MESSAGE_GET_AK_SEAMLESS_TOKEN_REPLY);
    }

    /* renamed from: e */
    public final void mo40784e(File file, int i) {
        AppMethodBeat.m2504i(NativeProtocol.MESSAGE_GET_LOGIN_STATUS_REQUEST);
        super.mo40784e(file, i);
        AppMethodBeat.m2505o(NativeProtocol.MESSAGE_GET_LOGIN_STATUS_REQUEST);
    }

    /* renamed from: a */
    public final void mo40778a(File file, File file2, String str, int i) {
        AppMethodBeat.m2504i(NativeProtocol.MESSAGE_GET_LOGIN_STATUS_REPLY);
        super.mo40778a(file, file2, str, i);
        AppMethodBeat.m2505o(NativeProtocol.MESSAGE_GET_LOGIN_STATUS_REPLY);
    }

    /* renamed from: a */
    public final void mo40777a(File file, SharePatchInfo sharePatchInfo, String str) {
        AppMethodBeat.m2504i(65548);
        super.mo40777a(file, sharePatchInfo, str);
        AppMethodBeat.m2505o(65548);
    }
}
