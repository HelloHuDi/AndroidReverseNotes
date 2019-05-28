package com.tencent.mm.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Calendar;

public final class a {
    private Calendar calendar;
    public long cvx;
    public int ehf;
    public long ehg;
    public int month;
    public int year;

    public a() {
        AppMethodBeat.i(103902);
        setTime(System.currentTimeMillis());
        AppMethodBeat.o(103902);
    }

    public a(int i, int i2, int i3) {
        AppMethodBeat.i(103903);
        this.year = i;
        this.month = i2;
        this.ehf = i3;
        AppMethodBeat.o(103903);
    }

    public a(long j) {
        AppMethodBeat.i(103904);
        this.ehg = j;
        setTime(j);
        AppMethodBeat.o(103904);
    }

    private void setTime(long j) {
        AppMethodBeat.i(103905);
        this.ehg = j;
        if (this.calendar == null) {
            this.calendar = Calendar.getInstance();
        }
        this.calendar.setTimeInMillis(j);
        this.month = this.calendar.get(2);
        this.year = this.calendar.get(1);
        this.ehf = this.calendar.get(5);
        AppMethodBeat.o(103905);
    }

    public final String toString() {
        AppMethodBeat.i(103906);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{ year: ");
        stringBuilder.append(this.year);
        stringBuilder.append(", month: ");
        stringBuilder.append(this.month);
        stringBuilder.append(", day: ");
        stringBuilder.append(this.ehf);
        stringBuilder.append(" }");
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(103906);
        return stringBuilder2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (aVar.ehf == this.ehf && aVar.month == this.month && aVar.year == this.year) {
            return true;
        }
        return false;
    }
}
