package com.tencent.mm.plugin.story.e;

import a.f.b.j;
import a.k.v;
import a.l;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, dWq = {"Lcom/tencent/mm/plugin/story/data/StoryTimeUtil;", "", "()V", "Companion", "plugin-story_release"})
public final class b {
    private static final String TAG = TAG;
    private static final long rRK = 1000;
    private static final long rRL = (rRK * 60);
    private static final long rRM = (rRL * 60);
    private static final long rRN = (24 * rRM);
    public static final a rRO = new a();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eJ\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u000eJ\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0004J\u0015\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0019J\u0006\u0010\u001b\u001a\u00020\u0014R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u000e\u0010\r\u001a\u00020\u000eXD¢\u0006\u0002\n\u0000¨\u0006\u001c"}, dWq = {"Lcom/tencent/mm/plugin/story/data/StoryTimeUtil$Companion;", "", "()V", "MILLSECONDS_OF_DAY", "", "getMILLSECONDS_OF_DAY", "()J", "MILLSECONDS_OF_HOUR", "getMILLSECONDS_OF_HOUR", "MILLSECONDS_OF_MINUTE", "getMILLSECONDS_OF_MINUTE", "MILLSECONDS_OF_SECOND", "getMILLSECONDS_OF_SECOND", "TAG", "", "formatDateInGallery", "", "date", "formatDateInGrid", "formatDateToTimeSecond", "", "formatStoryCreateDate", "time", "formatTimeInGrid", "formatTimeSecondToDate", "(Ljava/lang/Integer;)Ljava/lang/String;", "formatTimeSecondToMD", "nowToYear", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public static CharSequence aaf(String str) {
            long timeInMillis;
            AppMethodBeat.i(108988);
            j.p(str, FFmpegMetadataRetriever.METADATA_KEY_DATE);
            try {
                List a = v.a((CharSequence) str, new String[]{"-"});
                timeInMillis = new GregorianCalendar(Integer.parseInt((String) a.get(0)), Integer.parseInt((String) a.get(1)) - 1, Integer.parseInt((String) a.get(2))).getTimeInMillis();
            } catch (Exception e) {
                ab.printErrStackTrace(b.TAG, e, e.getMessage(), new Object[0]);
                timeInMillis = 0;
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            GregorianCalendar gregorianCalendar2 = new GregorianCalendar();
            gregorianCalendar2.setTimeInMillis(timeInMillis);
            CharSequence charSequence;
            if (gregorianCalendar.get(1) == gregorianCalendar2.get(1) && gregorianCalendar.get(2) == gregorianCalendar2.get(2)) {
                String string = ah.getContext().getString(R.string.es4);
                j.o(string, "MMApplicationContext.get…ry_album_date_this_month)");
                charSequence = string;
                AppMethodBeat.o(108988);
                return charSequence;
            }
            new GregorianCalendar().setTimeInMillis(timeInMillis);
            charSequence = DateFormat.format(ah.getContext().getString(R.string.es3), timeInMillis);
            j.o(charSequence, "DateFormat.format(MMAppl…_album_date_split), time)");
            AppMethodBeat.o(108988);
            return charSequence;
        }

        public static CharSequence aag(String str) {
            long timeInMillis;
            AppMethodBeat.i(138746);
            j.p(str, FFmpegMetadataRetriever.METADATA_KEY_DATE);
            try {
                List a = v.a((CharSequence) str, new String[]{"-"});
                timeInMillis = new GregorianCalendar(Integer.parseInt((String) a.get(0)), Integer.parseInt((String) a.get(1)) - 1, Integer.parseInt((String) a.get(2))).getTimeInMillis();
            } catch (Exception e) {
                ab.printErrStackTrace(b.TAG, e, e.getMessage(), new Object[0]);
                timeInMillis = 0;
            }
            CharSequence format = DateFormat.format(ah.getContext().getString(R.string.g_l), timeInMillis);
            j.o(format, "DateFormat.format(MMAppl…allery_date_split), time)");
            AppMethodBeat.o(138746);
            return format;
        }

        public static int kX(long j) {
            int parseInt;
            AppMethodBeat.i(108989);
            try {
                parseInt = Integer.parseInt(DateFormat.format(ah.getContext().getString(R.string.es2), j).toString());
            } catch (NumberFormatException e) {
                ab.printErrStackTrace(b.TAG, e, "NumberFormatException", new Object[0]);
                parseInt = 0;
            }
            AppMethodBeat.o(108989);
            return parseInt;
        }

        public static int aah(String str) {
            AppMethodBeat.i(108990);
            j.p(str, FFmpegMetadataRetriever.METADATA_KEY_DATE);
            Date parse = new SimpleDateFormat("yyyy-MM-dd").parse(str);
            j.o(parse, "simpleDateFormat.parse(date)");
            int time = (int) (parse.getTime() / 1000);
            AppMethodBeat.o(108990);
            return time;
        }

        public static String j(Integer num) {
            AppMethodBeat.i(108991);
            String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date((num != null ? (long) num.intValue() : 0) * 1000));
            j.o(format, "simpleDateFormat.format(date)");
            AppMethodBeat.o(108991);
            return format;
        }
    }

    static {
        AppMethodBeat.i(108992);
        AppMethodBeat.o(108992);
    }
}
