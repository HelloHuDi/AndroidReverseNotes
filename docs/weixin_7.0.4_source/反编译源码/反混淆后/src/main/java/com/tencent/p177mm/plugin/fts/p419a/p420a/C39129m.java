package com.tencent.p177mm.plugin.fts.p419a.p420a;

import android.database.Cursor;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.fts.p419a.C34202c;
import com.tencent.p177mm.plugin.fts.p419a.C34202c.C28110a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.plugin.fts.a.a.m */
public final class C39129m extends C45966l {
    /* renamed from: i */
    public final C39129m mo62030i(Cursor cursor) {
        AppMethodBeat.m2504i(114275);
        this.mEz = cursor.getLong(0);
        this.type = cursor.getInt(1);
        this.mDw = cursor.getInt(2);
        this.mEB = cursor.getLong(3);
        this.mDx = cursor.getString(4);
        this.timestamp = cursor.getLong(5);
        this.talker = cursor.getString(6);
        AppMethodBeat.m2505o(114275);
        return this;
    }

    /* renamed from: j */
    public final C39129m mo62031j(Cursor cursor) {
        AppMethodBeat.m2504i(114276);
        this.mEz = cursor.getLong(0);
        this.type = cursor.getInt(1);
        this.mDw = cursor.getInt(2);
        this.mEB = cursor.getLong(3);
        this.mDx = cursor.getString(4);
        this.timestamp = cursor.getLong(5);
        this.content = cursor.getString(6);
        this.mED = cursor.getString(7);
        this.mEJ = cursor.getLong(8);
        AppMethodBeat.m2505o(114276);
        return this;
    }

    /* renamed from: k */
    public final C39129m mo62032k(Cursor cursor) {
        AppMethodBeat.m2504i(114277);
        this.mEz = cursor.getLong(0);
        this.type = cursor.getInt(1);
        this.mDw = cursor.getInt(2);
        this.mEB = cursor.getLong(3);
        this.mDx = cursor.getString(4);
        this.timestamp = cursor.getLong(5);
        if (cursor.getColumnCount() >= 7) {
            this.content = cursor.getString(6);
        }
        if (cursor.getColumnCount() >= 8) {
            this.mED = cursor.getString(7);
        }
        AppMethodBeat.m2505o(114277);
        return this;
    }

    /* renamed from: a */
    private void m66575a(Pattern pattern) {
        int i = 0;
        AppMethodBeat.m2504i(114278);
        this.mEG = pattern.split(this.content);
        this.mEH = new int[this.mEG.length];
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 < this.mEH.length) {
                this.mEH[i2] = i3;
                i = (this.mEG[i2].length() + 1) + i3;
                i2++;
            } else {
                AppMethodBeat.m2505o(114278);
                return;
            }
        }
    }

    public final void bAo() {
        AppMethodBeat.m2504i(114279);
        if (C5046bo.isNullOrNil(this.mED)) {
            AppMethodBeat.m2505o(114279);
            return;
        }
        switch (this.type) {
            case WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT /*131072*/:
            case 131073:
            case 131074:
            case 131076:
            case 131081:
            case 262144:
            case 327680:
                bAq();
                AppMethodBeat.m2505o(114279);
                return;
            case 131075:
                bAp();
                break;
        }
        AppMethodBeat.m2505o(114279);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x008c A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x007f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void bAp() {
        AppMethodBeat.m2504i(114280);
        switch (this.mDw) {
            case 38:
                ArrayList arrayList = new ArrayList();
                m66575a(C28110a.mCA);
                String[] split = C28110a.mCz.split(this.mED);
                byte[] bytes = this.content.getBytes();
                for (int i = 0; i < split.length; i += 2) {
                    int intValue = Integer.valueOf(split[i]).intValue();
                    int length = new String(bytes, 0, Integer.valueOf(split[i + 1]).intValue()).length();
                    int binarySearch = Arrays.binarySearch(this.mEH, length);
                    if (binarySearch < 0) {
                        binarySearch = (-binarySearch) - 2;
                    }
                    String str = null;
                    String[] split2 = C28110a.mCB.split(this.mEG[binarySearch]);
                    int i2 = length - this.mEH[binarySearch];
                    length = 0;
                    while (length < split2.length) {
                        i2 = (i2 - split2[length].length()) - 1;
                        if (i2 < 0) {
                            str = split2[length];
                            i2 = C34202c.mCs[length];
                            if (i2 <= 0) {
                                arrayList.add(new C43121f(binarySearch, intValue, i2, str, split2[split2.length - 1]));
                            }
                        } else {
                            length++;
                        }
                    }
                    i2 = -1;
                    if (i2 <= 0) {
                    }
                }
                this.mEI = arrayList;
                break;
        }
        AppMethodBeat.m2505o(114280);
    }

    private void bAq() {
        AppMethodBeat.m2504i(114281);
        switch (this.mDw) {
            case 2:
            case 3:
            case 6:
            case 7:
                try {
                    String[] split = C28110a.mCz.split(this.mED);
                    m66575a(C28110a.mCD);
                    this.mEE = Arrays.binarySearch(this.mEH, new String(this.content.getBytes(), 0, Integer.valueOf(split[1]).intValue()).length());
                    if (this.mEE < 0) {
                        this.mEE = (-this.mEE) - 2;
                    }
                    this.mEF = this.mEG[this.mEE];
                    AppMethodBeat.m2505o(114281);
                    return;
                } catch (Exception e) {
                    this.mEE = BaseClientBuilder.API_PRIORITY_OTHER;
                    this.mEF = "";
                    AppMethodBeat.m2505o(114281);
                    return;
                }
            case 11:
            case 51:
                this.mEE = BaseClientBuilder.API_PRIORITY_OTHER;
                this.mEF = "";
                AppMethodBeat.m2505o(114281);
                return;
            default:
                try {
                    this.mEE = new String(this.content.getBytes(), 0, Integer.valueOf(C28110a.mCz.split(this.mED)[1]).intValue()).length();
                    this.mEF = this.content;
                    AppMethodBeat.m2505o(114281);
                    return;
                } catch (Exception e2) {
                    this.mEE = BaseClientBuilder.API_PRIORITY_OTHER;
                    this.mEF = "";
                    AppMethodBeat.m2505o(114281);
                    return;
                }
        }
    }

    /* renamed from: a */
    public final void mo62028a(C20840g c20840g) {
        AppMethodBeat.m2504i(114282);
        if (c20840g.mEa.length > 1) {
            this.mEK = 1;
        } else {
            this.mEK = 0;
        }
        if (this.type == 131075) {
            if (System.currentTimeMillis() - this.timestamp < 1209600000) {
                this.mDW += 50;
                String Yz = C1853r.m3846Yz();
                if (this.mDw == 38) {
                    HashSet hashSet = new HashSet();
                    if (this.mEI != null) {
                        for (C43121f c43121f : this.mEI) {
                            if (!Yz.equals(c43121f.dFl)) {
                                hashSet.add(Integer.valueOf(c43121f.mDS));
                            }
                        }
                    }
                    if (((long) hashSet.size()) >= this.mEB - 1) {
                        this.mDW += 20;
                        this.mEL = true;
                    }
                    if (c20840g.mEa.length > 1 && this.content.contains(c20840g.mDY)) {
                        this.mEK = 2;
                        this.mDW += 5;
                    }
                    if (this.mEB <= 15) {
                        this.mEN = 1;
                    }
                }
                if ((this.mDw == 5 || this.mDw == 1) && this.content.contains(c20840g.mDY)) {
                    if (c20840g.mEa.length > 1) {
                        this.mEK = 2;
                    }
                    this.mDW += 10;
                }
                AppMethodBeat.m2505o(114282);
                return;
            }
        } else if (this.type == WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) {
            if (System.currentTimeMillis() - this.timestamp < 1105032704) {
                this.mDW += 50;
            }
            if ((this.mDw == 5 || this.mDw == 1) && this.content.contains(c20840g.mDY)) {
                if (c20840g.mEa.length > 1) {
                    this.mEK = 2;
                }
                this.mDW += 10;
            }
        }
        AppMethodBeat.m2505o(114282);
    }
}
