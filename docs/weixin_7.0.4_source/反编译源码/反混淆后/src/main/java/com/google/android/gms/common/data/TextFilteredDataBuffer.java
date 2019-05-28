package com.google.android.gms.common.data;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.data.TextFilterable.StringFilter;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Locale;

public final class TextFilteredDataBuffer<T> extends FilteredDataBuffer<T> implements TextFilterable {
    private final ArrayList<Integer> zzob = new ArrayList();
    private AbstractDataBuffer<T> zzoc;
    private final String zzoo;
    private String zzop;
    private StringFilter zzoq;
    private Locale zzor;

    public TextFilteredDataBuffer(AbstractDataBuffer<T> abstractDataBuffer, String str) {
        super(abstractDataBuffer);
        AppMethodBeat.m2504i(61181);
        this.zzoc = abstractDataBuffer;
        this.zzoo = str;
        AppMethodBeat.m2505o(61181);
    }

    private final String zzh(String str) {
        AppMethodBeat.m2504i(61186);
        String toLowerCase = str.toLowerCase(this.zzor);
        StringBuilder stringBuilder = new StringBuilder();
        int length = toLowerCase.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isIdentifierIgnorable(toLowerCase.charAt(i))) {
                stringBuilder.append(toLowerCase.charAt(i));
            }
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(61186);
        return stringBuilder2;
    }

    public final int computeRealPosition(int i) {
        AppMethodBeat.m2504i(61183);
        if (TextUtils.isEmpty(this.zzop)) {
            AppMethodBeat.m2505o(61183);
            return i;
        } else if (i < 0 || i >= this.zzob.size()) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Position " + i + " is out of bounds for this buffer");
            AppMethodBeat.m2505o(61183);
            throw illegalArgumentException;
        } else {
            i = ((Integer) this.zzob.get(i)).intValue();
            AppMethodBeat.m2505o(61183);
            return i;
        }
    }

    public final int getCount() {
        AppMethodBeat.m2504i(61182);
        int count;
        if (TextUtils.isEmpty(this.zzop)) {
            count = this.mDataBuffer.getCount();
            AppMethodBeat.m2505o(61182);
            return count;
        }
        count = this.zzob.size();
        AppMethodBeat.m2505o(61182);
        return count;
    }

    public final void setFilterTerm(Context context, StringFilter stringFilter, String str) {
        AppMethodBeat.m2504i(61185);
        Preconditions.checkNotNull(stringFilter);
        this.zzop = str;
        this.zzoq = stringFilter;
        if (TextUtils.isEmpty(this.zzop)) {
            this.zzob.clear();
            AppMethodBeat.m2505o(61185);
            return;
        }
        this.zzor = context.getResources().getConfiguration().locale;
        this.zzop = zzh(this.zzop);
        this.zzob.clear();
        DataHolder dataHolder = this.zzoc.mDataHolder;
        String str2 = this.zzoo;
        boolean z = this.zzoc instanceof EntityBuffer;
        int i = 0;
        int count = this.zzoc.getCount();
        while (i < count) {
            int zzi = z ? ((EntityBuffer) this.zzoc).zzi(i) : i;
            String string = dataHolder.getString(str2, zzi, dataHolder.getWindowIndex(zzi));
            if (!TextUtils.isEmpty(string) && this.zzoq.matches(zzh(string), this.zzop)) {
                this.zzob.add(Integer.valueOf(i));
            }
            i++;
        }
        AppMethodBeat.m2505o(61185);
    }

    @VisibleForTesting
    public final void setFilterTerm(Context context, String str) {
        AppMethodBeat.m2504i(61184);
        setFilterTerm(context, CONTAINS, str);
        AppMethodBeat.m2505o(61184);
    }
}
