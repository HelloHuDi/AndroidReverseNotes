.class public final Landroid/support/v7/widget/o;
.super Ljava/lang/Object;
.source ""


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/support/v7/widget/o$a;,
        Landroid/support/v7/widget/o$b;,
        Landroid/support/v7/widget/o$e;,
        Landroid/support/v7/widget/o$c;,
        Landroid/support/v7/widget/o$d;
    }
.end annotation


# static fields
.field private static final a:Landroid/graphics/PorterDuff$Mode;

.field private static b:Landroid/support/v7/widget/o;

.field private static final c:Landroid/support/v7/widget/o$c;

.field private static final d:[I

.field private static final e:[I

.field private static final f:[I

.field private static final g:[I

.field private static final h:[I

.field private static final i:[I


# instance fields
.field private j:Ljava/util/WeakHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/WeakHashMap<",
            "Landroid/content/Context;",
            "La/b/c/f/n<",
            "Landroid/content/res/ColorStateList;",
            ">;>;"
        }
    .end annotation
.end field

.field private k:La/b/c/f/b;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "La/b/c/f/b<",
            "Ljava/lang/String;",
            "Landroid/support/v7/widget/o$d;",
            ">;"
        }
    .end annotation
.end field

.field private l:La/b/c/f/n;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "La/b/c/f/n<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private final m:Ljava/util/WeakHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/WeakHashMap<",
            "Landroid/content/Context;",
            "La/b/c/f/h<",
            "Ljava/lang/ref/WeakReference<",
            "Landroid/graphics/drawable/Drawable$ConstantState;",
            ">;>;>;"
        }
    .end annotation
.end field

.field private n:Landroid/util/TypedValue;

.field private o:Z


# direct methods
.method static constructor <clinit>()V
    .locals 10

    .line 78
    sget-object v0, Landroid/graphics/PorterDuff$Mode;->SRC_IN:Landroid/graphics/PorterDuff$Mode;

    sput-object v0, Landroid/support/v7/widget/o;->a:Landroid/graphics/PorterDuff$Mode;

    .line 107
    new-instance v0, Landroid/support/v7/widget/o$c;

    const/4 v1, 0x6

    invoke-direct {v0, v1}, Landroid/support/v7/widget/o$c;-><init>(I)V

    sput-object v0, Landroid/support/v7/widget/o;->c:Landroid/support/v7/widget/o$c;

    .line 113
    const/4 v0, 0x3

    new-array v2, v0, [I

    sget v3, La/b/d/a/e;->abc_textfield_search_default_mtrl_alpha:I

    const/4 v4, 0x0

    aput v3, v2, v4

    sget v3, La/b/d/a/e;->abc_textfield_default_mtrl_alpha:I

    const/4 v5, 0x1

    aput v3, v2, v5

    sget v3, La/b/d/a/e;->abc_ab_share_pack_mtrl_alpha:I

    const/4 v6, 0x2

    aput v3, v2, v6

    sput-object v2, Landroid/support/v7/widget/o;->d:[I

    .line 123
    const/4 v2, 0x7

    new-array v3, v2, [I

    sget v7, La/b/d/a/e;->abc_ic_commit_search_api_mtrl_alpha:I

    aput v7, v3, v4

    sget v7, La/b/d/a/e;->abc_seekbar_tick_mark_material:I

    aput v7, v3, v5

    sget v7, La/b/d/a/e;->abc_ic_menu_share_mtrl_alpha:I

    aput v7, v3, v6

    sget v7, La/b/d/a/e;->abc_ic_menu_copy_mtrl_am_alpha:I

    aput v7, v3, v0

    sget v7, La/b/d/a/e;->abc_ic_menu_cut_mtrl_alpha:I

    const/4 v8, 0x4

    aput v7, v3, v8

    sget v7, La/b/d/a/e;->abc_ic_menu_selectall_mtrl_alpha:I

    const/4 v9, 0x5

    aput v7, v3, v9

    sget v7, La/b/d/a/e;->abc_ic_menu_paste_mtrl_am_alpha:I

    aput v7, v3, v1

    sput-object v3, Landroid/support/v7/widget/o;->e:[I

    .line 137
    const/16 v3, 0xa

    new-array v3, v3, [I

    sget v7, La/b/d/a/e;->abc_textfield_activated_mtrl_alpha:I

    aput v7, v3, v4

    sget v7, La/b/d/a/e;->abc_textfield_search_activated_mtrl_alpha:I

    aput v7, v3, v5

    sget v7, La/b/d/a/e;->abc_cab_background_top_mtrl_alpha:I

    aput v7, v3, v6

    sget v7, La/b/d/a/e;->abc_text_cursor_material:I

    aput v7, v3, v0

    sget v7, La/b/d/a/e;->abc_text_select_handle_left_mtrl_dark:I

    aput v7, v3, v8

    sget v7, La/b/d/a/e;->abc_text_select_handle_middle_mtrl_dark:I

    aput v7, v3, v9

    sget v7, La/b/d/a/e;->abc_text_select_handle_right_mtrl_dark:I

    aput v7, v3, v1

    sget v1, La/b/d/a/e;->abc_text_select_handle_left_mtrl_light:I

    aput v1, v3, v2

    sget v1, La/b/d/a/e;->abc_text_select_handle_middle_mtrl_light:I

    const/16 v2, 0x8

    aput v1, v3, v2

    sget v1, La/b/d/a/e;->abc_text_select_handle_right_mtrl_light:I

    const/16 v2, 0x9

    aput v1, v3, v2

    sput-object v3, Landroid/support/v7/widget/o;->f:[I

    .line 154
    new-array v0, v0, [I

    sget v1, La/b/d/a/e;->abc_popup_background_mtrl_mult:I

    aput v1, v0, v4

    sget v1, La/b/d/a/e;->abc_cab_background_internal_bg:I

    aput v1, v0, v5

    sget v1, La/b/d/a/e;->abc_menu_hardkey_panel_mtrl_mult:I

    aput v1, v0, v6

    sput-object v0, Landroid/support/v7/widget/o;->g:[I

    .line 164
    new-array v0, v6, [I

    sget v1, La/b/d/a/e;->abc_tab_indicator_material:I

    aput v1, v0, v4

    sget v1, La/b/d/a/e;->abc_textfield_search_material:I

    aput v1, v0, v5

    sput-object v0, Landroid/support/v7/widget/o;->h:[I

    .line 174
    new-array v0, v6, [I

    sget v1, La/b/d/a/e;->abc_btn_check_material:I

    aput v1, v0, v4

    sget v1, La/b/d/a/e;->abc_btn_radio_material:I

    aput v1, v0, v5

    sput-object v0, Landroid/support/v7/widget/o;->i:[I

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .line 69
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 183
    new-instance v0, Ljava/util/WeakHashMap;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Ljava/util/WeakHashMap;-><init>(I)V

    iput-object v0, p0, Landroid/support/v7/widget/o;->m:Ljava/util/WeakHashMap;

    .line 800
    return-void
.end method

.method private static a(Landroid/util/TypedValue;)J
    .locals 4
    .param p0, "tv"    # Landroid/util/TypedValue;

    .line 226
    iget v0, p0, Landroid/util/TypedValue;->assetCookie:I

    int-to-long v0, v0

    const/16 v2, 0x20

    shl-long/2addr v0, v2

    iget v2, p0, Landroid/util/TypedValue;->data:I

    int-to-long v2, v2

    or-long/2addr v0, v2

    return-wide v0
.end method

.method static a(I)Landroid/graphics/PorterDuff$Mode;
    .locals 2
    .param p0, "resId"    # I

    .line 511
    const/4 v0, 0x0

    .line 513
    .local v0, "mode":Landroid/graphics/PorterDuff$Mode;
    sget v1, La/b/d/a/e;->abc_switch_thumb_material:I

    if-ne p0, v1, :cond_0

    .line 514
    sget-object v0, Landroid/graphics/PorterDuff$Mode;->MULTIPLY:Landroid/graphics/PorterDuff$Mode;

    .line 517
    :cond_0
    return-object v0
.end method

.method public static declared-synchronized a(ILandroid/graphics/PorterDuff$Mode;)Landroid/graphics/PorterDuffColorFilter;
    .locals 3
    .param p0, "color"    # I
    .param p1, "mode"    # Landroid/graphics/PorterDuff$Mode;

    const-class v0, Landroid/support/v7/widget/o;

    monitor-enter v0

    .line 727
    :try_start_0
    sget-object v1, Landroid/support/v7/widget/o;->c:Landroid/support/v7/widget/o$c;

    invoke-virtual {v1, p0, p1}, Landroid/support/v7/widget/o$c;->a(ILandroid/graphics/PorterDuff$Mode;)Landroid/graphics/PorterDuffColorFilter;

    move-result-object v1

    .line 729
    .local v1, "filter":Landroid/graphics/PorterDuffColorFilter;
    if-nez v1, :cond_0

    .line 731
    new-instance v2, Landroid/graphics/PorterDuffColorFilter;

    invoke-direct {v2, p0, p1}, Landroid/graphics/PorterDuffColorFilter;-><init>(ILandroid/graphics/PorterDuff$Mode;)V

    move-object v1, v2

    .line 732
    sget-object v2, Landroid/support/v7/widget/o;->c:Landroid/support/v7/widget/o$c;

    invoke-virtual {v2, p0, p1, v1}, Landroid/support/v7/widget/o$c;->a(ILandroid/graphics/PorterDuff$Mode;Landroid/graphics/PorterDuffColorFilter;)Landroid/graphics/PorterDuffColorFilter;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 735
    :cond_0
    monitor-exit v0

    return-object v1

    .line 726
    .end local v1    # "filter":Landroid/graphics/PorterDuffColorFilter;
    .end local p0    # "color":I
    .end local p1    # "mode":Landroid/graphics/PorterDuff$Mode;
    :catchall_0
    move-exception p0

    monitor-exit v0

    throw p0
.end method

.method private static a(Landroid/content/res/ColorStateList;Landroid/graphics/PorterDuff$Mode;[I)Landroid/graphics/PorterDuffColorFilter;
    .locals 2
    .param p0, "tint"    # Landroid/content/res/ColorStateList;
    .param p1, "tintMode"    # Landroid/graphics/PorterDuff$Mode;
    .param p2, "state"    # [I

    .line 717
    if-eqz p0, :cond_1

    if-nez p1, :cond_0

    goto :goto_0

    .line 720
    :cond_0
    const/4 v0, 0x0

    invoke-virtual {p0, p2, v0}, Landroid/content/res/ColorStateList;->getColorForState([II)I

    move-result v0

    .line 721
    .local v0, "color":I
    invoke-static {v0, p1}, Landroid/support/v7/widget/o;->a(ILandroid/graphics/PorterDuff$Mode;)Landroid/graphics/PorterDuffColorFilter;

    move-result-object v1

    return-object v1

    .line 718
    .end local v0    # "color":I
    :cond_1
    :goto_0
    const/4 v0, 0x0

    return-object v0
.end method

.method private a(Landroid/content/Context;IZLandroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;
    .locals 7
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "resId"    # I
    .param p3, "failIfNotKnown"    # Z
    .param p4, "drawable"    # Landroid/graphics/drawable/Drawable;

    .line 263
    invoke-virtual {p0, p1, p2}, Landroid/support/v7/widget/o;->b(Landroid/content/Context;I)Landroid/content/res/ColorStateList;

    move-result-object v0

    .line 264
    .local v0, "tintList":Landroid/content/res/ColorStateList;
    if-eqz v0, :cond_2

    .line 266
    invoke-static {p4}, Landroid/support/v7/widget/M;->a(Landroid/graphics/drawable/Drawable;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 267
    invoke-virtual {p4}, Landroid/graphics/drawable/Drawable;->mutate()Landroid/graphics/drawable/Drawable;

    move-result-object p4

    .line 269
    :cond_0
    invoke-static {p4}, Landroid/support/v4/graphics/drawable/a;->g(Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;

    move-result-object p4

    .line 270
    invoke-static {p4, v0}, Landroid/support/v4/graphics/drawable/a;->a(Landroid/graphics/drawable/Drawable;Landroid/content/res/ColorStateList;)V

    .line 273
    invoke-static {p2}, Landroid/support/v7/widget/o;->a(I)Landroid/graphics/PorterDuff$Mode;

    move-result-object v1

    .line 274
    .local v1, "tintMode":Landroid/graphics/PorterDuff$Mode;
    if-eqz v1, :cond_1

    .line 275
    invoke-static {p4, v1}, Landroid/support/v4/graphics/drawable/a;->a(Landroid/graphics/drawable/Drawable;Landroid/graphics/PorterDuff$Mode;)V

    .line 277
    .end local v1    # "tintMode":Landroid/graphics/PorterDuff$Mode;
    :cond_1
    goto/16 :goto_1

    :cond_2
    sget v1, La/b/d/a/e;->abc_seekbar_track_material:I

    const v2, 0x102000d

    const v3, 0x102000f

    const/high16 v4, 0x1020000

    if-ne p2, v1, :cond_3

    .line 278
    move-object v1, p4

    check-cast v1, Landroid/graphics/drawable/LayerDrawable;

    .line 279
    .local v1, "ld":Landroid/graphics/drawable/LayerDrawable;
    invoke-virtual {v1, v4}, Landroid/graphics/drawable/LayerDrawable;->findDrawableByLayerId(I)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    sget v5, La/b/d/a/a;->colorControlNormal:I

    .line 280
    invoke-static {p1, v5}, Landroid/support/v7/widget/oa;->b(Landroid/content/Context;I)I

    move-result v5

    sget-object v6, Landroid/support/v7/widget/o;->a:Landroid/graphics/PorterDuff$Mode;

    .line 279
    invoke-static {v4, v5, v6}, Landroid/support/v7/widget/o;->a(Landroid/graphics/drawable/Drawable;ILandroid/graphics/PorterDuff$Mode;)V

    .line 281
    invoke-virtual {v1, v3}, Landroid/graphics/drawable/LayerDrawable;->findDrawableByLayerId(I)Landroid/graphics/drawable/Drawable;

    move-result-object v3

    sget v4, La/b/d/a/a;->colorControlNormal:I

    .line 282
    invoke-static {p1, v4}, Landroid/support/v7/widget/oa;->b(Landroid/content/Context;I)I

    move-result v4

    sget-object v5, Landroid/support/v7/widget/o;->a:Landroid/graphics/PorterDuff$Mode;

    .line 281
    invoke-static {v3, v4, v5}, Landroid/support/v7/widget/o;->a(Landroid/graphics/drawable/Drawable;ILandroid/graphics/PorterDuff$Mode;)V

    .line 283
    invoke-virtual {v1, v2}, Landroid/graphics/drawable/LayerDrawable;->findDrawableByLayerId(I)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    sget v3, La/b/d/a/a;->colorControlActivated:I

    .line 284
    invoke-static {p1, v3}, Landroid/support/v7/widget/oa;->b(Landroid/content/Context;I)I

    move-result v3

    sget-object v4, Landroid/support/v7/widget/o;->a:Landroid/graphics/PorterDuff$Mode;

    .line 283
    invoke-static {v2, v3, v4}, Landroid/support/v7/widget/o;->a(Landroid/graphics/drawable/Drawable;ILandroid/graphics/PorterDuff$Mode;)V

    .line 285
    .end local v1    # "ld":Landroid/graphics/drawable/LayerDrawable;
    goto :goto_1

    :cond_3
    sget v1, La/b/d/a/e;->abc_ratingbar_material:I

    if-eq p2, v1, :cond_5

    sget v1, La/b/d/a/e;->abc_ratingbar_indicator_material:I

    if-eq p2, v1, :cond_5

    sget v1, La/b/d/a/e;->abc_ratingbar_small_material:I

    if-ne p2, v1, :cond_4

    goto :goto_0

    .line 297
    :cond_4
    invoke-static {p1, p2, p4}, Landroid/support/v7/widget/o;->a(Landroid/content/Context;ILandroid/graphics/drawable/Drawable;)Z

    move-result v1

    .line 298
    .local v1, "tinted":Z
    if-nez v1, :cond_6

    if-eqz p3, :cond_6

    .line 301
    const/4 p4, 0x0

    goto :goto_1

    .line 288
    .end local v1    # "tinted":Z
    :cond_5
    :goto_0
    move-object v1, p4

    check-cast v1, Landroid/graphics/drawable/LayerDrawable;

    .line 289
    .local v1, "ld":Landroid/graphics/drawable/LayerDrawable;
    invoke-virtual {v1, v4}, Landroid/graphics/drawable/LayerDrawable;->findDrawableByLayerId(I)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    sget v5, La/b/d/a/a;->colorControlNormal:I

    .line 290
    invoke-static {p1, v5}, Landroid/support/v7/widget/oa;->a(Landroid/content/Context;I)I

    move-result v5

    sget-object v6, Landroid/support/v7/widget/o;->a:Landroid/graphics/PorterDuff$Mode;

    .line 289
    invoke-static {v4, v5, v6}, Landroid/support/v7/widget/o;->a(Landroid/graphics/drawable/Drawable;ILandroid/graphics/PorterDuff$Mode;)V

    .line 292
    invoke-virtual {v1, v3}, Landroid/graphics/drawable/LayerDrawable;->findDrawableByLayerId(I)Landroid/graphics/drawable/Drawable;

    move-result-object v3

    sget v4, La/b/d/a/a;->colorControlActivated:I

    .line 293
    invoke-static {p1, v4}, Landroid/support/v7/widget/oa;->b(Landroid/content/Context;I)I

    move-result v4

    sget-object v5, Landroid/support/v7/widget/o;->a:Landroid/graphics/PorterDuff$Mode;

    .line 292
    invoke-static {v3, v4, v5}, Landroid/support/v7/widget/o;->a(Landroid/graphics/drawable/Drawable;ILandroid/graphics/PorterDuff$Mode;)V

    .line 294
    invoke-virtual {v1, v2}, Landroid/graphics/drawable/LayerDrawable;->findDrawableByLayerId(I)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    sget v3, La/b/d/a/a;->colorControlActivated:I

    .line 295
    invoke-static {p1, v3}, Landroid/support/v7/widget/oa;->b(Landroid/content/Context;I)I

    move-result v3

    sget-object v4, Landroid/support/v7/widget/o;->a:Landroid/graphics/PorterDuff$Mode;

    .line 294
    invoke-static {v2, v3, v4}, Landroid/support/v7/widget/o;->a(Landroid/graphics/drawable/Drawable;ILandroid/graphics/PorterDuff$Mode;)V

    .line 296
    .end local v1    # "ld":Landroid/graphics/drawable/LayerDrawable;
    nop

    .line 304
    :cond_6
    :goto_1
    return-object p4
.end method

.method private declared-synchronized a(Landroid/content/Context;J)Landroid/graphics/drawable/Drawable;
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "key"    # J

    monitor-enter p0

    .line 394
    :try_start_0
    iget-object v0, p0, Landroid/support/v7/widget/o;->m:Ljava/util/WeakHashMap;

    invoke-virtual {v0, p1}, Ljava/util/WeakHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, La/b/c/f/h;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 395
    .local v0, "cache":La/b/c/f/h;, "Landroid/support/v4/util/LongSparseArray<Ljava/lang/ref/WeakReference<Landroid/graphics/drawable/Drawable$ConstantState;>;>;"
    const/4 v1, 0x0

    if-nez v0, :cond_0

    .line 396
    monitor-exit p0

    return-object v1

    .line 399
    :cond_0
    :try_start_1
    invoke-virtual {v0, p2, p3}, La/b/c/f/h;->b(J)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/ref/WeakReference;

    .line 400
    .local v2, "wr":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Landroid/graphics/drawable/Drawable$ConstantState;>;"
    if-eqz v2, :cond_2

    .line 402
    invoke-virtual {v2}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/graphics/drawable/Drawable$ConstantState;

    .line 403
    .local v3, "entry":Landroid/graphics/drawable/Drawable$ConstantState;
    if-eqz v3, :cond_1

    .line 404
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v3, v1}, Landroid/graphics/drawable/Drawable$ConstantState;->newDrawable(Landroid/content/res/Resources;)Landroid/graphics/drawable/Drawable;

    move-result-object v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    monitor-exit p0

    return-object v1

    .line 407
    .end local p0    # "this":Landroid/support/v7/widget/o;
    :cond_1
    :try_start_2
    invoke-virtual {v0, p2, p3}, La/b/c/f/h;->a(J)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 410
    .end local v3    # "entry":Landroid/graphics/drawable/Drawable$ConstantState;
    :cond_2
    monitor-exit p0

    return-object v1

    .line 393
    .end local v0    # "cache":La/b/c/f/h;, "Landroid/support/v4/util/LongSparseArray<Ljava/lang/ref/WeakReference<Landroid/graphics/drawable/Drawable$ConstantState;>;>;"
    .end local v2    # "wr":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Landroid/graphics/drawable/Drawable$ConstantState;>;"
    .end local p1    # "context":Landroid/content/Context;
    .end local p2    # "key":J
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public static declared-synchronized a()Landroid/support/v7/widget/o;
    .locals 2

    const-class v0, Landroid/support/v7/widget/o;

    monitor-enter v0

    .line 89
    :try_start_0
    sget-object v1, Landroid/support/v7/widget/o;->b:Landroid/support/v7/widget/o;

    if-nez v1, :cond_0

    .line 90
    new-instance v1, Landroid/support/v7/widget/o;

    invoke-direct {v1}, Landroid/support/v7/widget/o;-><init>()V

    sput-object v1, Landroid/support/v7/widget/o;->b:Landroid/support/v7/widget/o;

    .line 91
    sget-object v1, Landroid/support/v7/widget/o;->b:Landroid/support/v7/widget/o;

    invoke-static {v1}, Landroid/support/v7/widget/o;->a(Landroid/support/v7/widget/o;)V

    .line 93
    :cond_0
    sget-object v1, Landroid/support/v7/widget/o;->b:Landroid/support/v7/widget/o;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v0

    return-object v1

    .line 88
    :catchall_0
    move-exception v1

    monitor-exit v0

    throw v1
.end method

.method private a(Landroid/content/Context;ILandroid/content/res/ColorStateList;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "resId"    # I
    .param p3, "tintList"    # Landroid/content/res/ColorStateList;

    .line 568
    iget-object v0, p0, Landroid/support/v7/widget/o;->j:Ljava/util/WeakHashMap;

    if-nez v0, :cond_0

    .line 569
    new-instance v0, Ljava/util/WeakHashMap;

    invoke-direct {v0}, Ljava/util/WeakHashMap;-><init>()V

    iput-object v0, p0, Landroid/support/v7/widget/o;->j:Ljava/util/WeakHashMap;

    .line 571
    :cond_0
    iget-object v0, p0, Landroid/support/v7/widget/o;->j:Ljava/util/WeakHashMap;

    invoke-virtual {v0, p1}, Ljava/util/WeakHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, La/b/c/f/n;

    .line 572
    .local v0, "themeTints":La/b/c/f/n;, "Landroid/support/v4/util/SparseArrayCompat<Landroid/content/res/ColorStateList;>;"
    if-nez v0, :cond_1

    .line 573
    new-instance v1, La/b/c/f/n;

    invoke-direct {v1}, La/b/c/f/n;-><init>()V

    move-object v0, v1

    .line 574
    iget-object v1, p0, Landroid/support/v7/widget/o;->j:Ljava/util/WeakHashMap;

    invoke-virtual {v1, p1, v0}, Ljava/util/WeakHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 576
    :cond_1
    invoke-virtual {v0, p2, p3}, La/b/c/f/n;->a(ILjava/lang/Object;)V

    .line 577
    return-void
.end method

.method private static a(Landroid/graphics/drawable/Drawable;ILandroid/graphics/PorterDuff$Mode;)V
    .locals 1
    .param p0, "d"    # Landroid/graphics/drawable/Drawable;
    .param p1, "color"    # I
    .param p2, "mode"    # Landroid/graphics/PorterDuff$Mode;

    .line 739
    invoke-static {p0}, Landroid/support/v7/widget/M;->a(Landroid/graphics/drawable/Drawable;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 740
    invoke-virtual {p0}, Landroid/graphics/drawable/Drawable;->mutate()Landroid/graphics/drawable/Drawable;

    move-result-object p0

    .line 742
    :cond_0
    if-nez p2, :cond_1

    sget-object v0, Landroid/support/v7/widget/o;->a:Landroid/graphics/PorterDuff$Mode;

    goto :goto_0

    :cond_1
    move-object v0, p2

    :goto_0
    invoke-static {p1, v0}, Landroid/support/v7/widget/o;->a(ILandroid/graphics/PorterDuff$Mode;)Landroid/graphics/PorterDuffColorFilter;

    move-result-object v0

    invoke-virtual {p0, v0}, Landroid/graphics/drawable/Drawable;->setColorFilter(Landroid/graphics/ColorFilter;)V

    .line 743
    return-void
.end method

.method static a(Landroid/graphics/drawable/Drawable;Landroid/support/v7/widget/ra;[I)V
    .locals 2
    .param p0, "drawable"    # Landroid/graphics/drawable/Drawable;
    .param p1, "tint"    # Landroid/support/v7/widget/ra;
    .param p2, "state"    # [I

    .line 693
    invoke-static {p0}, Landroid/support/v7/widget/M;->a(Landroid/graphics/drawable/Drawable;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 694
    invoke-virtual {p0}, Landroid/graphics/drawable/Drawable;->mutate()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    if-eq v0, p0, :cond_0

    .line 695
    const-string v0, "AppCompatDrawableManag"

    const-string v1, "Mutated drawable is not the same instance as the input."

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 696
    return-void

    .line 699
    :cond_0
    iget-boolean v0, p1, Landroid/support/v7/widget/ra;->d:Z

    if-nez v0, :cond_2

    iget-boolean v0, p1, Landroid/support/v7/widget/ra;->c:Z

    if-eqz v0, :cond_1

    goto :goto_0

    .line 705
    :cond_1
    invoke-virtual {p0}, Landroid/graphics/drawable/Drawable;->clearColorFilter()V

    goto :goto_3

    .line 700
    :cond_2
    :goto_0
    iget-boolean v0, p1, Landroid/support/v7/widget/ra;->d:Z

    if-eqz v0, :cond_3

    iget-object v0, p1, Landroid/support/v7/widget/ra;->a:Landroid/content/res/ColorStateList;

    goto :goto_1

    :cond_3
    const/4 v0, 0x0

    :goto_1
    iget-boolean v1, p1, Landroid/support/v7/widget/ra;->c:Z

    if-eqz v1, :cond_4

    iget-object v1, p1, Landroid/support/v7/widget/ra;->b:Landroid/graphics/PorterDuff$Mode;

    goto :goto_2

    :cond_4
    sget-object v1, Landroid/support/v7/widget/o;->a:Landroid/graphics/PorterDuff$Mode;

    :goto_2
    invoke-static {v0, v1, p2}, Landroid/support/v7/widget/o;->a(Landroid/content/res/ColorStateList;Landroid/graphics/PorterDuff$Mode;[I)Landroid/graphics/PorterDuffColorFilter;

    move-result-object v0

    invoke-virtual {p0, v0}, Landroid/graphics/drawable/Drawable;->setColorFilter(Landroid/graphics/ColorFilter;)V

    .line 708
    :goto_3
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x17

    if-gt v0, v1, :cond_5

    .line 711
    invoke-virtual {p0}, Landroid/graphics/drawable/Drawable;->invalidateSelf()V

    .line 713
    :cond_5
    return-void
.end method

.method private static a(Landroid/support/v7/widget/o;)V
    .locals 2
    .param p0, "manager"    # Landroid/support/v7/widget/o;

    .line 100
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x18

    if-ge v0, v1, :cond_0

    .line 101
    new-instance v0, Landroid/support/v7/widget/o$e;

    invoke-direct {v0}, Landroid/support/v7/widget/o$e;-><init>()V

    const-string v1, "vector"

    invoke-direct {p0, v1, v0}, Landroid/support/v7/widget/o;->a(Ljava/lang/String;Landroid/support/v7/widget/o$d;)V

    .line 102
    new-instance v0, Landroid/support/v7/widget/o$b;

    invoke-direct {v0}, Landroid/support/v7/widget/o$b;-><init>()V

    const-string v1, "animated-vector"

    invoke-direct {p0, v1, v0}, Landroid/support/v7/widget/o;->a(Ljava/lang/String;Landroid/support/v7/widget/o$d;)V

    .line 103
    new-instance v0, Landroid/support/v7/widget/o$a;

    invoke-direct {v0}, Landroid/support/v7/widget/o$a;-><init>()V

    const-string v1, "animated-selector"

    invoke-direct {p0, v1, v0}, Landroid/support/v7/widget/o;->a(Ljava/lang/String;Landroid/support/v7/widget/o$d;)V

    .line 105
    :cond_0
    return-void
.end method

.method private a(Ljava/lang/String;Landroid/support/v7/widget/o$d;)V
    .locals 1
    .param p1, "tagName"    # Ljava/lang/String;
    .param p2, "delegate"    # Landroid/support/v7/widget/o$d;

    .line 489
    iget-object v0, p0, Landroid/support/v7/widget/o;->k:La/b/c/f/b;

    if-nez v0, :cond_0

    .line 490
    new-instance v0, La/b/c/f/b;

    invoke-direct {v0}, La/b/c/f/b;-><init>()V

    iput-object v0, p0, Landroid/support/v7/widget/o;->k:La/b/c/f/b;

    .line 492
    :cond_0
    iget-object v0, p0, Landroid/support/v7/widget/o;->k:La/b/c/f/b;

    invoke-virtual {v0, p1, p2}, La/b/c/f/m;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 493
    return-void
.end method

.method static a(Landroid/content/Context;ILandroid/graphics/drawable/Drawable;)Z
    .locals 6
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "resId"    # I
    .param p2, "drawable"    # Landroid/graphics/drawable/Drawable;

    .line 442
    sget-object v0, Landroid/support/v7/widget/o;->a:Landroid/graphics/PorterDuff$Mode;

    .line 443
    .local v0, "tintMode":Landroid/graphics/PorterDuff$Mode;
    const/4 v1, 0x0

    .line 444
    .local v1, "colorAttrSet":Z
    const/4 v2, 0x0

    .line 445
    .local v2, "colorAttr":I
    const/4 v3, -0x1

    .line 447
    .local v3, "alpha":I
    sget-object v4, Landroid/support/v7/widget/o;->d:[I

    invoke-static {v4, p1}, Landroid/support/v7/widget/o;->a([II)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 448
    sget v2, La/b/d/a/a;->colorControlNormal:I

    .line 449
    const/4 v1, 0x1

    goto :goto_0

    .line 450
    :cond_0
    sget-object v4, Landroid/support/v7/widget/o;->f:[I

    invoke-static {v4, p1}, Landroid/support/v7/widget/o;->a([II)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 451
    sget v2, La/b/d/a/a;->colorControlActivated:I

    .line 452
    const/4 v1, 0x1

    goto :goto_0

    .line 453
    :cond_1
    sget-object v4, Landroid/support/v7/widget/o;->g:[I

    invoke-static {v4, p1}, Landroid/support/v7/widget/o;->a([II)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 454
    const v2, 0x1010031

    .line 455
    const/4 v1, 0x1

    .line 456
    sget-object v0, Landroid/graphics/PorterDuff$Mode;->MULTIPLY:Landroid/graphics/PorterDuff$Mode;

    goto :goto_0

    .line 457
    :cond_2
    sget v4, La/b/d/a/e;->abc_list_divider_mtrl_alpha:I

    if-ne p1, v4, :cond_3

    .line 458
    const v2, 0x1010030

    .line 459
    const/4 v1, 0x1

    .line 460
    const v4, 0x42233333    # 40.8f

    invoke-static {v4}, Ljava/lang/Math;->round(F)I

    move-result v3

    goto :goto_0

    .line 461
    :cond_3
    sget v4, La/b/d/a/e;->abc_dialog_material_background:I

    if-ne p1, v4, :cond_4

    .line 462
    const v2, 0x1010031

    .line 463
    const/4 v1, 0x1

    .line 466
    :cond_4
    :goto_0
    if-eqz v1, :cond_7

    .line 467
    invoke-static {p2}, Landroid/support/v7/widget/M;->a(Landroid/graphics/drawable/Drawable;)Z

    move-result v4

    if-eqz v4, :cond_5

    .line 468
    invoke-virtual {p2}, Landroid/graphics/drawable/Drawable;->mutate()Landroid/graphics/drawable/Drawable;

    move-result-object p2

    .line 471
    :cond_5
    invoke-static {p0, v2}, Landroid/support/v7/widget/oa;->b(Landroid/content/Context;I)I

    move-result v4

    .line 472
    .local v4, "color":I
    invoke-static {v4, v0}, Landroid/support/v7/widget/o;->a(ILandroid/graphics/PorterDuff$Mode;)Landroid/graphics/PorterDuffColorFilter;

    move-result-object v5

    invoke-virtual {p2, v5}, Landroid/graphics/drawable/Drawable;->setColorFilter(Landroid/graphics/ColorFilter;)V

    .line 474
    const/4 v5, -0x1

    if-eq v3, v5, :cond_6

    .line 475
    invoke-virtual {p2, v3}, Landroid/graphics/drawable/Drawable;->setAlpha(I)V

    .line 483
    :cond_6
    const/4 v5, 0x1

    return v5

    .line 485
    .end local v4    # "color":I
    :cond_7
    const/4 v4, 0x0

    return v4
.end method

.method private declared-synchronized a(Landroid/content/Context;JLandroid/graphics/drawable/Drawable;)Z
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "key"    # J
    .param p4, "drawable"    # Landroid/graphics/drawable/Drawable;

    monitor-enter p0

    .line 415
    :try_start_0
    invoke-virtual {p4}, Landroid/graphics/drawable/Drawable;->getConstantState()Landroid/graphics/drawable/Drawable$ConstantState;

    move-result-object v0

    .line 416
    .local v0, "cs":Landroid/graphics/drawable/Drawable$ConstantState;
    if-eqz v0, :cond_1

    .line 417
    iget-object v1, p0, Landroid/support/v7/widget/o;->m:Ljava/util/WeakHashMap;

    invoke-virtual {v1, p1}, Ljava/util/WeakHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, La/b/c/f/h;

    .line 418
    .local v1, "cache":La/b/c/f/h;, "Landroid/support/v4/util/LongSparseArray<Ljava/lang/ref/WeakReference<Landroid/graphics/drawable/Drawable$ConstantState;>;>;"
    if-nez v1, :cond_0

    .line 419
    new-instance v2, La/b/c/f/h;

    invoke-direct {v2}, La/b/c/f/h;-><init>()V

    move-object v1, v2

    .line 420
    iget-object v2, p0, Landroid/support/v7/widget/o;->m:Ljava/util/WeakHashMap;

    invoke-virtual {v2, p1, v1}, Ljava/util/WeakHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 422
    .end local p0    # "this":Landroid/support/v7/widget/o;
    :cond_0
    new-instance v2, Ljava/lang/ref/WeakReference;

    invoke-direct {v2, v0}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    invoke-virtual {v1, p2, p3, v2}, La/b/c/f/h;->c(JLjava/lang/Object;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 423
    const/4 v2, 0x1

    monitor-exit p0

    return v2

    .line 425
    .end local v1    # "cache":La/b/c/f/h;, "Landroid/support/v4/util/LongSparseArray<Ljava/lang/ref/WeakReference<Landroid/graphics/drawable/Drawable$ConstantState;>;>;"
    :cond_1
    const/4 v1, 0x0

    monitor-exit p0

    return v1

    .line 414
    .end local v0    # "cs":Landroid/graphics/drawable/Drawable$ConstantState;
    .end local p1    # "context":Landroid/content/Context;
    .end local p2    # "key":J
    .end local p4    # "drawable":Landroid/graphics/drawable/Drawable;
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method private static a(Landroid/graphics/drawable/Drawable;)Z
    .locals 2
    .param p0, "d"    # Landroid/graphics/drawable/Drawable;

    .line 762
    instance-of v0, p0, La/b/b/a/k;

    if-nez v0, :cond_1

    .line 763
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    const-string v1, "android.graphics.drawable.VectorDrawable"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    goto :goto_1

    :cond_1
    :goto_0
    const/4 v0, 0x1

    :goto_1
    return v0
.end method

.method private static a([II)Z
    .locals 4
    .param p0, "array"    # [I
    .param p1, "value"    # I

    .line 502
    array-length v0, p0

    const/4 v1, 0x0

    const/4 v2, 0x0

    :goto_0
    if-ge v2, v0, :cond_1

    aget v3, p0, v2

    .line 503
    .local v3, "id":I
    if-ne v3, p1, :cond_0

    .line 504
    const/4 v0, 0x1

    return v0

    .line 502
    .end local v3    # "id":I
    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 507
    :cond_1
    return v1
.end method

.method private b(Landroid/content/Context;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .line 746
    iget-boolean v0, p0, Landroid/support/v7/widget/o;->o:Z

    if-eqz v0, :cond_0

    .line 748
    return-void

    .line 752
    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v7/widget/o;->o:Z

    .line 753
    sget v0, La/b/d/a/e;->abc_vector_test:I

    invoke-virtual {p0, p1, v0}, Landroid/support/v7/widget/o;->a(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 754
    .local v0, "d":Landroid/graphics/drawable/Drawable;
    if-eqz v0, :cond_1

    invoke-static {v0}, Landroid/support/v7/widget/o;->a(Landroid/graphics/drawable/Drawable;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 759
    return-void

    .line 755
    :cond_1
    const/4 v1, 0x0

    iput-boolean v1, p0, Landroid/support/v7/widget/o;->o:Z

    .line 756
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string v2, "This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat."

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method private c(Landroid/content/Context;)Landroid/content/res/ColorStateList;
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .line 586
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Landroid/support/v7/widget/o;->c(Landroid/content/Context;I)Landroid/content/res/ColorStateList;

    move-result-object v0

    return-object v0
.end method

.method private c(Landroid/content/Context;I)Landroid/content/res/ColorStateList;
    .locals 6
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "baseColor"    # I

    .line 596
    const/4 v0, 0x4

    new-array v1, v0, [[I

    .line 597
    .local v1, "states":[[I
    new-array v0, v0, [I

    .line 598
    .local v0, "colors":[I
    const/4 v2, 0x0

    .line 600
    .local v2, "i":I
    sget v3, La/b/d/a/a;->colorControlHighlight:I

    invoke-static {p1, v3}, Landroid/support/v7/widget/oa;->b(Landroid/content/Context;I)I

    move-result v3

    .line 601
    .local v3, "colorControlHighlight":I
    sget v4, La/b/d/a/a;->colorButtonNormal:I

    invoke-static {p1, v4}, Landroid/support/v7/widget/oa;->a(Landroid/content/Context;I)I

    move-result v4

    .line 604
    .local v4, "disabledColor":I
    sget-object v5, Landroid/support/v7/widget/oa;->b:[I

    aput-object v5, v1, v2

    .line 605
    aput v4, v0, v2

    .line 606
    add-int/lit8 v2, v2, 0x1

    .line 608
    sget-object v5, Landroid/support/v7/widget/oa;->e:[I

    aput-object v5, v1, v2

    .line 609
    invoke-static {v3, p2}, La/b/c/b/a;->a(II)I

    move-result v5

    aput v5, v0, v2

    .line 610
    add-int/lit8 v2, v2, 0x1

    .line 612
    sget-object v5, Landroid/support/v7/widget/oa;->c:[I

    aput-object v5, v1, v2

    .line 613
    invoke-static {v3, p2}, La/b/c/b/a;->a(II)I

    move-result v5

    aput v5, v0, v2

    .line 614
    add-int/lit8 v2, v2, 0x1

    .line 617
    sget-object v5, Landroid/support/v7/widget/oa;->i:[I

    aput-object v5, v1, v2

    .line 618
    aput p2, v0, v2

    .line 619
    add-int/lit8 v2, v2, 0x1

    .line 621
    new-instance v5, Landroid/content/res/ColorStateList;

    invoke-direct {v5, v1, v0}, Landroid/content/res/ColorStateList;-><init>([[I[I)V

    return-object v5
.end method

.method private d(Landroid/content/Context;)Landroid/content/res/ColorStateList;
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .line 590
    sget v0, La/b/d/a/a;->colorAccent:I

    .line 591
    invoke-static {p1, v0}, Landroid/support/v7/widget/oa;->b(Landroid/content/Context;I)I

    move-result v0

    .line 590
    invoke-direct {p0, p1, v0}, Landroid/support/v7/widget/o;->c(Landroid/content/Context;I)Landroid/content/res/ColorStateList;

    move-result-object v0

    return-object v0
.end method

.method private d(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;
    .locals 9
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "resId"    # I

    .line 231
    iget-object v0, p0, Landroid/support/v7/widget/o;->n:Landroid/util/TypedValue;

    if-nez v0, :cond_0

    .line 232
    new-instance v0, Landroid/util/TypedValue;

    invoke-direct {v0}, Landroid/util/TypedValue;-><init>()V

    iput-object v0, p0, Landroid/support/v7/widget/o;->n:Landroid/util/TypedValue;

    .line 234
    :cond_0
    iget-object v0, p0, Landroid/support/v7/widget/o;->n:Landroid/util/TypedValue;

    .line 235
    .local v0, "tv":Landroid/util/TypedValue;
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {v1, p2, v0, v2}, Landroid/content/res/Resources;->getValue(ILandroid/util/TypedValue;Z)V

    .line 236
    invoke-static {v0}, Landroid/support/v7/widget/o;->a(Landroid/util/TypedValue;)J

    move-result-wide v3

    .line 238
    .local v3, "key":J
    invoke-direct {p0, p1, v3, v4}, Landroid/support/v7/widget/o;->a(Landroid/content/Context;J)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    .line 239
    .local v1, "dr":Landroid/graphics/drawable/Drawable;
    if-eqz v1, :cond_1

    .line 241
    return-object v1

    .line 245
    :cond_1
    sget v5, La/b/d/a/e;->abc_cab_background_top_material:I

    if-ne p2, v5, :cond_2

    .line 246
    new-instance v5, Landroid/graphics/drawable/LayerDrawable;

    const/4 v6, 0x2

    new-array v6, v6, [Landroid/graphics/drawable/Drawable;

    const/4 v7, 0x0

    sget v8, La/b/d/a/e;->abc_cab_background_internal_bg:I

    .line 247
    invoke-virtual {p0, p1, v8}, Landroid/support/v7/widget/o;->a(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object v8

    aput-object v8, v6, v7

    sget v7, La/b/d/a/e;->abc_cab_background_top_mtrl_alpha:I

    .line 248
    invoke-virtual {p0, p1, v7}, Landroid/support/v7/widget/o;->a(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object v7

    aput-object v7, v6, v2

    invoke-direct {v5, v6}, Landroid/graphics/drawable/LayerDrawable;-><init>([Landroid/graphics/drawable/Drawable;)V

    move-object v1, v5

    .line 252
    :cond_2
    if-eqz v1, :cond_3

    .line 253
    iget v2, v0, Landroid/util/TypedValue;->changingConfigurations:I

    invoke-virtual {v1, v2}, Landroid/graphics/drawable/Drawable;->setChangingConfigurations(I)V

    .line 255
    invoke-direct {p0, p1, v3, v4, v1}, Landroid/support/v7/widget/o;->a(Landroid/content/Context;JLandroid/graphics/drawable/Drawable;)Z

    .line 258
    :cond_3
    return-object v1
.end method

.method private e(Landroid/content/Context;)Landroid/content/res/ColorStateList;
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .line 580
    sget v0, La/b/d/a/a;->colorButtonNormal:I

    .line 581
    invoke-static {p1, v0}, Landroid/support/v7/widget/oa;->b(Landroid/content/Context;I)I

    move-result v0

    .line 580
    invoke-direct {p0, p1, v0}, Landroid/support/v7/widget/o;->c(Landroid/content/Context;I)Landroid/content/res/ColorStateList;

    move-result-object v0

    return-object v0
.end method

.method private e(Landroid/content/Context;I)Landroid/content/res/ColorStateList;
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "resId"    # I

    .line 559
    iget-object v0, p0, Landroid/support/v7/widget/o;->j:Ljava/util/WeakHashMap;

    const/4 v1, 0x0

    if-eqz v0, :cond_1

    .line 560
    invoke-virtual {v0, p1}, Ljava/util/WeakHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, La/b/c/f/n;

    .line 561
    .local v0, "tints":La/b/c/f/n;, "Landroid/support/v4/util/SparseArrayCompat<Landroid/content/res/ColorStateList;>;"
    if-eqz v0, :cond_0

    invoke-virtual {v0, p2}, La/b/c/f/n;->b(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/content/res/ColorStateList;

    :cond_0
    return-object v1

    .line 563
    .end local v0    # "tints":La/b/c/f/n;, "Landroid/support/v4/util/SparseArrayCompat<Landroid/content/res/ColorStateList;>;"
    :cond_1
    return-object v1
.end method

.method private f(Landroid/content/Context;)Landroid/content/res/ColorStateList;
    .locals 6
    .param p1, "context"    # Landroid/content/Context;

    .line 625
    const/4 v0, 0x3

    new-array v1, v0, [[I

    .line 626
    .local v1, "states":[[I
    new-array v0, v0, [I

    .line 627
    .local v0, "colors":[I
    const/4 v2, 0x0

    .line 629
    .local v2, "i":I
    sget v3, La/b/d/a/a;->colorSwitchThumbNormal:I

    invoke-static {p1, v3}, Landroid/support/v7/widget/oa;->c(Landroid/content/Context;I)Landroid/content/res/ColorStateList;

    move-result-object v3

    .line 632
    .local v3, "thumbColor":Landroid/content/res/ColorStateList;
    if-eqz v3, :cond_0

    invoke-virtual {v3}, Landroid/content/res/ColorStateList;->isStateful()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 637
    sget-object v4, Landroid/support/v7/widget/oa;->b:[I

    aput-object v4, v1, v2

    .line 638
    aget-object v4, v1, v2

    const/4 v5, 0x0

    invoke-virtual {v3, v4, v5}, Landroid/content/res/ColorStateList;->getColorForState([II)I

    move-result v4

    aput v4, v0, v2

    .line 639
    add-int/lit8 v2, v2, 0x1

    .line 641
    sget-object v4, Landroid/support/v7/widget/oa;->f:[I

    aput-object v4, v1, v2

    .line 642
    sget v4, La/b/d/a/a;->colorControlActivated:I

    invoke-static {p1, v4}, Landroid/support/v7/widget/oa;->b(Landroid/content/Context;I)I

    move-result v4

    aput v4, v0, v2

    .line 643
    add-int/lit8 v2, v2, 0x1

    .line 646
    sget-object v4, Landroid/support/v7/widget/oa;->i:[I

    aput-object v4, v1, v2

    .line 647
    invoke-virtual {v3}, Landroid/content/res/ColorStateList;->getDefaultColor()I

    move-result v4

    aput v4, v0, v2

    .line 648
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 653
    :cond_0
    sget-object v4, Landroid/support/v7/widget/oa;->b:[I

    aput-object v4, v1, v2

    .line 654
    sget v4, La/b/d/a/a;->colorSwitchThumbNormal:I

    invoke-static {p1, v4}, Landroid/support/v7/widget/oa;->a(Landroid/content/Context;I)I

    move-result v4

    aput v4, v0, v2

    .line 655
    add-int/lit8 v2, v2, 0x1

    .line 657
    sget-object v4, Landroid/support/v7/widget/oa;->f:[I

    aput-object v4, v1, v2

    .line 658
    sget v4, La/b/d/a/a;->colorControlActivated:I

    invoke-static {p1, v4}, Landroid/support/v7/widget/oa;->b(Landroid/content/Context;I)I

    move-result v4

    aput v4, v0, v2

    .line 659
    add-int/lit8 v2, v2, 0x1

    .line 662
    sget-object v4, Landroid/support/v7/widget/oa;->i:[I

    aput-object v4, v1, v2

    .line 663
    sget v4, La/b/d/a/a;->colorSwitchThumbNormal:I

    invoke-static {p1, v4}, Landroid/support/v7/widget/oa;->b(Landroid/content/Context;I)I

    move-result v4

    aput v4, v0, v2

    .line 664
    add-int/lit8 v2, v2, 0x1

    .line 667
    :goto_0
    new-instance v4, Landroid/content/res/ColorStateList;

    invoke-direct {v4, v1, v0}, Landroid/content/res/ColorStateList;-><init>([[I[I)V

    return-object v4
.end method

.method private f(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;
    .locals 12
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "resId"    # I

    .line 308
    iget-object v0, p0, Landroid/support/v7/widget/o;->k:La/b/c/f/b;

    const/4 v1, 0x0

    if-eqz v0, :cond_b

    invoke-virtual {v0}, La/b/c/f/m;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_b

    .line 309
    iget-object v0, p0, Landroid/support/v7/widget/o;->l:La/b/c/f/n;

    const-string v2, "appcompat_skip_skip"

    if-eqz v0, :cond_2

    .line 310
    invoke-virtual {v0, p2}, La/b/c/f/n;->b(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 311
    .local v0, "cachedTagName":Ljava/lang/String;
    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_1

    if-eqz v0, :cond_0

    iget-object v3, p0, Landroid/support/v7/widget/o;->k:La/b/c/f/b;

    .line 312
    invoke-virtual {v3, v0}, La/b/c/f/m;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    if-nez v3, :cond_0

    goto :goto_0

    .line 321
    .end local v0    # "cachedTagName":Ljava/lang/String;
    :cond_0
    goto :goto_1

    .line 319
    .restart local v0    # "cachedTagName":Ljava/lang/String;
    :cond_1
    :goto_0
    return-object v1

    .line 323
    .end local v0    # "cachedTagName":Ljava/lang/String;
    :cond_2
    new-instance v0, La/b/c/f/n;

    invoke-direct {v0}, La/b/c/f/n;-><init>()V

    iput-object v0, p0, Landroid/support/v7/widget/o;->l:La/b/c/f/n;

    .line 326
    :goto_1
    iget-object v0, p0, Landroid/support/v7/widget/o;->n:Landroid/util/TypedValue;

    if-nez v0, :cond_3

    .line 327
    new-instance v0, Landroid/util/TypedValue;

    invoke-direct {v0}, Landroid/util/TypedValue;-><init>()V

    iput-object v0, p0, Landroid/support/v7/widget/o;->n:Landroid/util/TypedValue;

    .line 329
    :cond_3
    iget-object v0, p0, Landroid/support/v7/widget/o;->n:Landroid/util/TypedValue;

    .line 330
    .local v0, "tv":Landroid/util/TypedValue;
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    .line 331
    .local v1, "res":Landroid/content/res/Resources;
    const/4 v3, 0x1

    invoke-virtual {v1, p2, v0, v3}, Landroid/content/res/Resources;->getValue(ILandroid/util/TypedValue;Z)V

    .line 333
    invoke-static {v0}, Landroid/support/v7/widget/o;->a(Landroid/util/TypedValue;)J

    move-result-wide v4

    .line 335
    .local v4, "key":J
    invoke-direct {p0, p1, v4, v5}, Landroid/support/v7/widget/o;->a(Landroid/content/Context;J)Landroid/graphics/drawable/Drawable;

    move-result-object v6

    .line 336
    .local v6, "dr":Landroid/graphics/drawable/Drawable;
    if-eqz v6, :cond_4

    .line 342
    return-object v6

    .line 345
    :cond_4
    iget-object v7, v0, Landroid/util/TypedValue;->string:Ljava/lang/CharSequence;

    if-eqz v7, :cond_9

    invoke-interface {v7}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v7

    const-string v8, ".xml"

    invoke-virtual {v7, v8}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_9

    .line 348
    :try_start_0
    invoke-virtual {v1, p2}, Landroid/content/res/Resources;->getXml(I)Landroid/content/res/XmlResourceParser;

    move-result-object v7

    .line 349
    .local v7, "parser":Lorg/xmlpull/v1/XmlPullParser;
    invoke-static {v7}, Landroid/util/Xml;->asAttributeSet(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;

    move-result-object v8

    .line 351
    .local v8, "attrs":Landroid/util/AttributeSet;
    :goto_2
    invoke-interface {v7}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v9

    move v10, v9

    .local v10, "type":I
    const/4 v11, 0x2

    if-eq v9, v11, :cond_5

    if-eq v10, v3, :cond_5

    goto :goto_2

    .line 355
    :cond_5
    if-ne v10, v11, :cond_8

    .line 359
    invoke-interface {v7}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v3

    .line 361
    .local v3, "tagName":Ljava/lang/String;
    iget-object v9, p0, Landroid/support/v7/widget/o;->l:La/b/c/f/n;

    invoke-virtual {v9, p2, v3}, La/b/c/f/n;->a(ILjava/lang/Object;)V

    .line 364
    iget-object v9, p0, Landroid/support/v7/widget/o;->k:La/b/c/f/b;

    invoke-virtual {v9, v3}, La/b/c/f/m;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Landroid/support/v7/widget/o$d;

    .line 365
    .local v9, "delegate":Landroid/support/v7/widget/o$d;
    if-eqz v9, :cond_6

    .line 366
    nop

    .line 367
    invoke-virtual {p1}, Landroid/content/Context;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v11

    .line 366
    invoke-interface {v9, p1, v7, v8, v11}, Landroid/support/v7/widget/o$d;->a(Landroid/content/Context;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/content/res/Resources$Theme;)Landroid/graphics/drawable/Drawable;

    move-result-object v11

    move-object v6, v11

    .line 369
    :cond_6
    if-eqz v6, :cond_7

    .line 371
    iget v11, v0, Landroid/util/TypedValue;->changingConfigurations:I

    invoke-virtual {v6, v11}, Landroid/graphics/drawable/Drawable;->setChangingConfigurations(I)V

    .line 372
    invoke-direct {p0, p1, v4, v5, v6}, Landroid/support/v7/widget/o;->a(Landroid/content/Context;JLandroid/graphics/drawable/Drawable;)Z

    .line 379
    .end local v3    # "tagName":Ljava/lang/String;
    .end local v7    # "parser":Lorg/xmlpull/v1/XmlPullParser;
    .end local v8    # "attrs":Landroid/util/AttributeSet;
    .end local v9    # "delegate":Landroid/support/v7/widget/o$d;
    .end local v10    # "type":I
    :cond_7
    goto :goto_3

    .line 356
    .restart local v7    # "parser":Lorg/xmlpull/v1/XmlPullParser;
    .restart local v8    # "attrs":Landroid/util/AttributeSet;
    .restart local v10    # "type":I
    :cond_8
    new-instance v3, Lorg/xmlpull/v1/XmlPullParserException;

    const-string v9, "No start tag found"

    invoke-direct {v3, v9}, Lorg/xmlpull/v1/XmlPullParserException;-><init>(Ljava/lang/String;)V

    .end local v0    # "tv":Landroid/util/TypedValue;
    .end local v1    # "res":Landroid/content/res/Resources;
    .end local v4    # "key":J
    .end local v6    # "dr":Landroid/graphics/drawable/Drawable;
    .end local p1    # "context":Landroid/content/Context;
    .end local p2    # "resId":I
    throw v3
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 377
    .end local v7    # "parser":Lorg/xmlpull/v1/XmlPullParser;
    .end local v8    # "attrs":Landroid/util/AttributeSet;
    .end local v10    # "type":I
    .restart local v0    # "tv":Landroid/util/TypedValue;
    .restart local v1    # "res":Landroid/content/res/Resources;
    .restart local v4    # "key":J
    .restart local v6    # "dr":Landroid/graphics/drawable/Drawable;
    .restart local p1    # "context":Landroid/content/Context;
    .restart local p2    # "resId":I
    :catch_0
    move-exception v3

    .line 378
    .local v3, "e":Ljava/lang/Exception;
    const-string v7, "AppCompatDrawableManag"

    const-string v8, "Exception while inflating drawable"

    invoke-static {v7, v8, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 381
    .end local v3    # "e":Ljava/lang/Exception;
    :cond_9
    :goto_3
    if-nez v6, :cond_a

    .line 384
    iget-object v3, p0, Landroid/support/v7/widget/o;->l:La/b/c/f/n;

    invoke-virtual {v3, p2, v2}, La/b/c/f/n;->a(ILjava/lang/Object;)V

    .line 386
    :cond_a
    return-object v6

    .line 389
    .end local v0    # "tv":Landroid/util/TypedValue;
    .end local v1    # "res":Landroid/content/res/Resources;
    .end local v4    # "key":J
    .end local v6    # "dr":Landroid/graphics/drawable/Drawable;
    :cond_b
    return-object v1
.end method


# virtual methods
.method public declared-synchronized a(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "resId"    # I

    monitor-enter p0

    .line 191
    const/4 v0, 0x0

    :try_start_0
    invoke-virtual {p0, p1, p2, v0}, Landroid/support/v7/widget/o;->a(Landroid/content/Context;IZ)Landroid/graphics/drawable/Drawable;

    move-result-object v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .end local p0    # "this":Landroid/support/v7/widget/o;
    .end local p1    # "context":Landroid/content/Context;
    .end local p2    # "resId":I
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method declared-synchronized a(Landroid/content/Context;IZ)Landroid/graphics/drawable/Drawable;
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "resId"    # I
    .param p3, "failIfNotKnown"    # Z

    monitor-enter p0

    .line 196
    :try_start_0
    invoke-direct {p0, p1}, Landroid/support/v7/widget/o;->b(Landroid/content/Context;)V

    .line 198
    invoke-direct {p0, p1, p2}, Landroid/support/v7/widget/o;->f(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 199
    .local v0, "drawable":Landroid/graphics/drawable/Drawable;
    if-nez v0, :cond_0

    .line 200
    invoke-direct {p0, p1, p2}, Landroid/support/v7/widget/o;->d(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    move-object v0, v1

    .line 202
    .end local p0    # "this":Landroid/support/v7/widget/o;
    :cond_0
    if-nez v0, :cond_1

    .line 203
    invoke-static {p1, p2}, La/b/c/a/a;->b(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    move-object v0, v1

    .line 206
    :cond_1
    if-eqz v0, :cond_2

    .line 208
    invoke-direct {p0, p1, p2, p3, v0}, Landroid/support/v7/widget/o;->a(Landroid/content/Context;IZLandroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    move-object v0, v1

    .line 210
    :cond_2
    if-eqz v0, :cond_3

    .line 212
    invoke-static {v0}, Landroid/support/v7/widget/M;->b(Landroid/graphics/drawable/Drawable;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 214
    :cond_3
    monitor-exit p0

    return-object v0

    .line 195
    .end local v0    # "drawable":Landroid/graphics/drawable/Drawable;
    .end local p1    # "context":Landroid/content/Context;
    .end local p2    # "resId":I
    .end local p3    # "failIfNotKnown":Z
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method declared-synchronized a(Landroid/content/Context;Landroid/support/v7/widget/Ga;I)Landroid/graphics/drawable/Drawable;
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "resources"    # Landroid/support/v7/widget/Ga;
    .param p3, "resId"    # I

    monitor-enter p0

    .line 430
    :try_start_0
    invoke-direct {p0, p1, p3}, Landroid/support/v7/widget/o;->f(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 431
    .local v0, "drawable":Landroid/graphics/drawable/Drawable;
    if-nez v0, :cond_0

    .line 432
    invoke-virtual {p2, p3}, Landroid/support/v7/widget/Ga;->a(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    move-object v0, v1

    .line 434
    .end local p0    # "this":Landroid/support/v7/widget/o;
    :cond_0
    if-eqz v0, :cond_1

    .line 435
    const/4 v1, 0x0

    invoke-direct {p0, p1, p3, v1, v0}, Landroid/support/v7/widget/o;->a(Landroid/content/Context;IZLandroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;

    move-result-object v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v1

    .line 437
    :cond_1
    const/4 v1, 0x0

    monitor-exit p0

    return-object v1

    .line 429
    .end local v0    # "drawable":Landroid/graphics/drawable/Drawable;
    .end local p1    # "context":Landroid/content/Context;
    .end local p2    # "resources":Landroid/support/v7/widget/Ga;
    .end local p3    # "resId":I
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized a(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    monitor-enter p0

    .line 218
    :try_start_0
    iget-object v0, p0, Landroid/support/v7/widget/o;->m:Ljava/util/WeakHashMap;

    invoke-virtual {v0, p1}, Ljava/util/WeakHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, La/b/c/f/h;

    .line 219
    .local v0, "cache":La/b/c/f/h;, "Landroid/support/v4/util/LongSparseArray<Ljava/lang/ref/WeakReference<Landroid/graphics/drawable/Drawable$ConstantState;>;>;"
    if-eqz v0, :cond_0

    .line 221
    invoke-virtual {v0}, La/b/c/f/h;->a()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 223
    .end local p0    # "this":Landroid/support/v7/widget/o;
    :cond_0
    monitor-exit p0

    return-void

    .line 217
    .end local v0    # "cache":La/b/c/f/h;, "Landroid/support/v4/util/LongSparseArray<Ljava/lang/ref/WeakReference<Landroid/graphics/drawable/Drawable$ConstantState;>;>;"
    .end local p1    # "context":Landroid/content/Context;
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method declared-synchronized b(Landroid/content/Context;I)Landroid/content/res/ColorStateList;
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "resId"    # I

    monitor-enter p0

    .line 522
    :try_start_0
    invoke-direct {p0, p1, p2}, Landroid/support/v7/widget/o;->e(Landroid/content/Context;I)Landroid/content/res/ColorStateList;

    move-result-object v0

    .line 524
    .local v0, "tint":Landroid/content/res/ColorStateList;
    if-nez v0, :cond_c

    .line 526
    sget v1, La/b/d/a/e;->abc_edit_text_material:I

    if-ne p2, v1, :cond_0

    .line 527
    sget v1, La/b/d/a/c;->abc_tint_edittext:I

    invoke-static {p1, v1}, La/b/d/b/a/a;->a(Landroid/content/Context;I)Landroid/content/res/ColorStateList;

    move-result-object v1

    move-object v0, v1

    goto/16 :goto_1

    .line 528
    .end local p0    # "this":Landroid/support/v7/widget/o;
    :cond_0
    sget v1, La/b/d/a/e;->abc_switch_track_mtrl_alpha:I

    if-ne p2, v1, :cond_1

    .line 529
    sget v1, La/b/d/a/c;->abc_tint_switch_track:I

    invoke-static {p1, v1}, La/b/d/b/a/a;->a(Landroid/content/Context;I)Landroid/content/res/ColorStateList;

    move-result-object v1

    move-object v0, v1

    goto/16 :goto_1

    .line 530
    :cond_1
    sget v1, La/b/d/a/e;->abc_switch_thumb_material:I

    if-ne p2, v1, :cond_2

    .line 531
    invoke-direct {p0, p1}, Landroid/support/v7/widget/o;->f(Landroid/content/Context;)Landroid/content/res/ColorStateList;

    move-result-object v1

    move-object v0, v1

    goto/16 :goto_1

    .line 532
    :cond_2
    sget v1, La/b/d/a/e;->abc_btn_default_mtrl_shape:I

    if-ne p2, v1, :cond_3

    .line 533
    invoke-direct {p0, p1}, Landroid/support/v7/widget/o;->e(Landroid/content/Context;)Landroid/content/res/ColorStateList;

    move-result-object v1

    move-object v0, v1

    goto/16 :goto_1

    .line 534
    :cond_3
    sget v1, La/b/d/a/e;->abc_btn_borderless_material:I

    if-ne p2, v1, :cond_4

    .line 535
    invoke-direct {p0, p1}, Landroid/support/v7/widget/o;->c(Landroid/content/Context;)Landroid/content/res/ColorStateList;

    move-result-object v1

    move-object v0, v1

    goto :goto_1

    .line 536
    :cond_4
    sget v1, La/b/d/a/e;->abc_btn_colored_material:I

    if-ne p2, v1, :cond_5

    .line 537
    invoke-direct {p0, p1}, Landroid/support/v7/widget/o;->d(Landroid/content/Context;)Landroid/content/res/ColorStateList;

    move-result-object v1

    move-object v0, v1

    goto :goto_1

    .line 538
    :cond_5
    sget v1, La/b/d/a/e;->abc_spinner_mtrl_am_alpha:I

    if-eq p2, v1, :cond_a

    sget v1, La/b/d/a/e;->abc_spinner_textfield_background_material:I

    if-ne p2, v1, :cond_6

    goto :goto_0

    .line 541
    :cond_6
    sget-object v1, Landroid/support/v7/widget/o;->e:[I

    invoke-static {v1, p2}, Landroid/support/v7/widget/o;->a([II)Z

    move-result v1

    if-eqz v1, :cond_7

    .line 542
    sget v1, La/b/d/a/a;->colorControlNormal:I

    invoke-static {p1, v1}, Landroid/support/v7/widget/oa;->c(Landroid/content/Context;I)Landroid/content/res/ColorStateList;

    move-result-object v1

    move-object v0, v1

    goto :goto_1

    .line 543
    :cond_7
    sget-object v1, Landroid/support/v7/widget/o;->h:[I

    invoke-static {v1, p2}, Landroid/support/v7/widget/o;->a([II)Z

    move-result v1

    if-eqz v1, :cond_8

    .line 544
    sget v1, La/b/d/a/c;->abc_tint_default:I

    invoke-static {p1, v1}, La/b/d/b/a/a;->a(Landroid/content/Context;I)Landroid/content/res/ColorStateList;

    move-result-object v1

    move-object v0, v1

    goto :goto_1

    .line 545
    :cond_8
    sget-object v1, Landroid/support/v7/widget/o;->i:[I

    invoke-static {v1, p2}, Landroid/support/v7/widget/o;->a([II)Z

    move-result v1

    if-eqz v1, :cond_9

    .line 546
    sget v1, La/b/d/a/c;->abc_tint_btn_checkable:I

    invoke-static {p1, v1}, La/b/d/b/a/a;->a(Landroid/content/Context;I)Landroid/content/res/ColorStateList;

    move-result-object v1

    move-object v0, v1

    goto :goto_1

    .line 547
    :cond_9
    sget v1, La/b/d/a/e;->abc_seekbar_thumb_material:I

    if-ne p2, v1, :cond_b

    .line 548
    sget v1, La/b/d/a/c;->abc_tint_seek_thumb:I

    invoke-static {p1, v1}, La/b/d/b/a/a;->a(Landroid/content/Context;I)Landroid/content/res/ColorStateList;

    move-result-object v1

    move-object v0, v1

    goto :goto_1

    .line 540
    :cond_a
    :goto_0
    sget v1, La/b/d/a/c;->abc_tint_spinner:I

    invoke-static {p1, v1}, La/b/d/b/a/a;->a(Landroid/content/Context;I)Landroid/content/res/ColorStateList;

    move-result-object v1

    move-object v0, v1

    .line 551
    :cond_b
    :goto_1
    if-eqz v0, :cond_c

    .line 552
    invoke-direct {p0, p1, p2, v0}, Landroid/support/v7/widget/o;->a(Landroid/content/Context;ILandroid/content/res/ColorStateList;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 555
    :cond_c
    monitor-exit p0

    return-object v0

    .line 521
    .end local v0    # "tint":Landroid/content/res/ColorStateList;
    .end local p1    # "context":Landroid/content/Context;
    .end local p2    # "resId":I
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method
