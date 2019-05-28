package com.tencent.p177mm.plugin.appbrand.appstorage;

import com.tencent.luggage.p147g.C37399a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appstorage.C19092p.C19093a;
import com.tencent.p177mm.plugin.appbrand.p328r.C19681j;
import com.tencent.p177mm.vfs.C5728b;
import java.io.File;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.appstorage.g */
public class C24685g implements C19092p {
    /* renamed from: yd */
    public C45518j mo5849yd(String str) {
        return C45518j.ERR_PERMISSION_DENIED;
    }

    /* renamed from: ye */
    public C45518j mo5850ye(String str) {
        return C45518j.ERR_PERMISSION_DENIED;
    }

    /* renamed from: X */
    public C45518j mo5830X(String str, boolean z) {
        return C45518j.ERR_PERMISSION_DENIED;
    }

    /* renamed from: Y */
    public C45518j mo5831Y(String str, boolean z) {
        return C45518j.ERR_PERMISSION_DENIED;
    }

    /* renamed from: a */
    public C45518j mo5837a(String str, C19681j<List<C26753h>> c19681j) {
        return C45518j.ERR_PERMISSION_DENIED;
    }

    /* renamed from: b */
    public C45518j mo5843b(String str, C19681j<ByteBuffer> c19681j) {
        return C45518j.ERR_PERMISSION_DENIED;
    }

    /* renamed from: a */
    public C45518j mo5839a(String str, InputStream inputStream, boolean z) {
        return C45518j.ERR_PERMISSION_DENIED;
    }

    /* renamed from: yf */
    public C45518j mo5851yf(String str) {
        return C45518j.ERR_PERMISSION_DENIED;
    }

    /* renamed from: a */
    public C45518j mo5836a(String str, C42366k c42366k) {
        return C45518j.ERR_PERMISSION_DENIED;
    }

    /* renamed from: g */
    public C45518j mo5846g(String str, List<C33103u> list) {
        return C45518j.ERR_PERMISSION_DENIED;
    }

    /* renamed from: a */
    public C45518j mo5838a(String str, File file, boolean z) {
        return C45518j.ERR_PERMISSION_DENIED;
    }

    /* renamed from: yg */
    public File mo34314yg(String str) {
        AppMethodBeat.m2504i(90975);
        File Z = mo5832Z(str, false);
        AppMethodBeat.m2505o(90975);
        return Z;
    }

    /* renamed from: Z */
    public File mo5832Z(String str, boolean z) {
        return null;
    }

    /* renamed from: b */
    public C45518j mo5844b(String str, File file) {
        return C45518j.ERR_PERMISSION_DENIED;
    }

    /* renamed from: ca */
    public boolean mo5845ca(String str) {
        return false;
    }

    public void initialize() {
    }

    public void release() {
    }

    public void awP() {
    }

    /* renamed from: yh */
    public C5728b mo34315yh(String str) {
        return null;
    }

    /* renamed from: a */
    public C45518j mo5833a(C19681j<String> c19681j) {
        return C45518j.ERR_NOT_SUPPORTED;
    }

    /* renamed from: a */
    public C45518j mo5835a(File file, String str, boolean z, C19681j<String> c19681j) {
        return C45518j.ERR_NOT_SUPPORTED;
    }

    /* renamed from: a */
    public C45518j mo5834a(File file, String str, C19681j<String> c19681j) {
        return C45518j.ERR_NOT_SUPPORTED;
    }

    public List<? extends C19093a> awQ() {
        return null;
    }

    /* renamed from: yi */
    public boolean mo34316yi(String str) {
        return false;
    }

    /* renamed from: xt */
    public final InputStream mo34313xt(String str) {
        AppMethodBeat.m2504i(90976);
        C19681j c19681j = new C19681j();
        if (mo5843b(str, c19681j) == C45518j.OK) {
            InputStream c37399a = new C37399a((ByteBuffer) c19681j.value);
            AppMethodBeat.m2505o(90976);
            return c37399a;
        }
        AppMethodBeat.m2505o(90976);
        return null;
    }
}
