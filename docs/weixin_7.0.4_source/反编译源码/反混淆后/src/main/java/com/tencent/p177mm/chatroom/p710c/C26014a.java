package com.tencent.p177mm.chatroom.p710c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Calendar;

/* renamed from: com.tencent.mm.chatroom.c.a */
public final class C26014a {
    private Calendar calendar;
    public long cvx;
    public int ehf;
    public long ehg;
    public int month;
    public int year;

    public C26014a() {
        AppMethodBeat.m2504i(103902);
        setTime(System.currentTimeMillis());
        AppMethodBeat.m2505o(103902);
    }

    public C26014a(int i, int i2, int i3) {
        AppMethodBeat.m2504i(103903);
        this.year = i;
        this.month = i2;
        this.ehf = i3;
        AppMethodBeat.m2505o(103903);
    }

    public C26014a(long j) {
        AppMethodBeat.m2504i(103904);
        this.ehg = j;
        setTime(j);
        AppMethodBeat.m2505o(103904);
    }

    private void setTime(long j) {
        AppMethodBeat.m2504i(103905);
        this.ehg = j;
        if (this.calendar == null) {
            this.calendar = Calendar.getInstance();
        }
        this.calendar.setTimeInMillis(j);
        this.month = this.calendar.get(2);
        this.year = this.calendar.get(1);
        this.ehf = this.calendar.get(5);
        AppMethodBeat.m2505o(103905);
    }

    public final String toString() {
        AppMethodBeat.m2504i(103906);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{ year: ");
        stringBuilder.append(this.year);
        stringBuilder.append(", month: ");
        stringBuilder.append(this.month);
        stringBuilder.append(", day: ");
        stringBuilder.append(this.ehf);
        stringBuilder.append(" }");
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(103906);
        return stringBuilder2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C26014a)) {
            return false;
        }
        C26014a c26014a = (C26014a) obj;
        if (c26014a.ehf == this.ehf && c26014a.month == this.month && c26014a.year == this.year) {
            return true;
        }
        return false;
    }
}
