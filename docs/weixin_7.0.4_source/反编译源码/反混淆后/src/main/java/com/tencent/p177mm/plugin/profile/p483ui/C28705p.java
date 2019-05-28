package com.tencent.p177mm.plugin.profile.p483ui;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.p1374bi.C41789d;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.pluginsdk.p597ui.preference.C14957b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C41338bt;
import com.tencent.p177mm.storage.C7569ax;
import com.tencent.p177mm.storage.C7570bf;
import com.tencent.p177mm.storage.C7616ad;

/* renamed from: com.tencent.mm.plugin.profile.ui.p */
public final class C28705p {
    /* renamed from: a */
    public static C14957b[] m45603a(Context context, C7616ad c7616ad, int i) {
        AppMethodBeat.m2504i(23613);
        String nullAsNil = C5046bo.nullAsNil(((Activity) context).getIntent().getStringExtra("Verify_ticket"));
        if (C7486a.m12942jh(c7616ad.field_type)) {
            AppMethodBeat.m2505o(23613);
            return null;
        } else if (C5046bo.isNullOrNil(nullAsNil)) {
            AppMethodBeat.m2505o(23613);
            return null;
        } else {
            C14957b[] a;
            C4990ab.m7410d("MicroMsg.FMessageUtil", "initAddContent, scene = ".concat(String.valueOf(i)));
            if (i == 18) {
                C4990ab.m7410d("MicroMsg.FMessageUtil", "initAddContent, scene is lbs");
                a = C14957b.m23241a(context, C41789d.akQ().apz(c7616ad.field_username));
            } else if (C1829bf.m3750kE(i)) {
                C4990ab.m7410d("MicroMsg.FMessageUtil", "initAddContent, scene is shake");
                a = C14957b.m23243a(context, C41789d.akR().apY(c7616ad.field_username));
            } else {
                C4990ab.m7410d("MicroMsg.FMessageUtil", "initAddContent, scene is other");
                a = C14957b.m23242a(context, C41789d.akO().apv(c7616ad.field_username));
            }
            if (a == null || a.length == 0) {
                AppMethodBeat.m2505o(23613);
                return null;
            }
            AppMethodBeat.m2505o(23613);
            return a;
        }
    }

    /* renamed from: b */
    public static String m45604b(Context context, C7616ad c7616ad, int i) {
        String str = null;
        AppMethodBeat.m2504i(23614);
        String nullAsNil = C5046bo.nullAsNil(((Activity) context).getIntent().getStringExtra("Verify_ticket"));
        if (C7486a.m12942jh(c7616ad.field_type)) {
            AppMethodBeat.m2505o(23614);
        } else if (C5046bo.isNullOrNil(nullAsNil)) {
            AppMethodBeat.m2505o(23614);
        } else {
            str = "";
            C4990ab.m7410d("MicroMsg.FMessageUtil", "initAddContent, scene = ".concat(String.valueOf(i)));
            if (i == 18) {
                C4990ab.m7410d("MicroMsg.FMessageUtil", "initAddContent, scene is lbs");
                C7570bf[] apz = C41789d.akQ().apz(c7616ad.field_username);
                if (apz.length > 0) {
                    str = apz[0].field_svrid;
                }
            } else if (C1829bf.m3750kE(i)) {
                C4990ab.m7410d("MicroMsg.FMessageUtil", "initAddContent, scene is shake");
                C41338bt[] apY = C41789d.akR().apY(c7616ad.field_username);
                if (apY.length > 0) {
                    str = apY[0].field_svrid;
                }
            } else {
                C4990ab.m7410d("MicroMsg.FMessageUtil", "initAddContent, scene is other");
                C7569ax[] apv = C41789d.akO().apv(c7616ad.field_username);
                if (apv.length > 0) {
                    str = apv[0].field_svrId;
                }
            }
            AppMethodBeat.m2505o(23614);
        }
        return str;
    }
}
