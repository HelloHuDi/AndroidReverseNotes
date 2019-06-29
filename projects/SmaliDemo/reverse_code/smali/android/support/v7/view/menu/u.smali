.class public Landroid/support/v7/view/menu/u;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Landroid/support/v7/view/menu/n;


# instance fields
.field private final a:Landroid/content/Context;

.field private final b:Landroid/support/v7/view/menu/l;

.field private final c:Z

.field private final d:I

.field private final e:I

.field private f:Landroid/view/View;

.field private g:I

.field private h:Z

.field private i:Landroid/support/v7/view/menu/v$a;

.field private j:Landroid/support/v7/view/menu/s;

.field private k:Landroid/widget/PopupWindow$OnDismissListener;

.field private final l:Landroid/widget/PopupWindow$OnDismissListener;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/support/v7/view/menu/l;Landroid/view/View;ZI)V
    .locals 7
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "menu"    # Landroid/support/v7/view/menu/l;
    .param p3, "anchorView"    # Landroid/view/View;
    .param p4, "overflowOnly"    # Z
    .param p5, "popupStyleAttr"    # I

    .line 79
    const/4 v6, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move v4, p4

    move v5, p5

    invoke-direct/range {v0 .. v6}, Landroid/support/v7/view/menu/u;-><init>(Landroid/content/Context;Landroid/support/v7/view/menu/l;Landroid/view/View;ZII)V

    .line 80
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/support/v7/view/menu/l;Landroid/view/View;ZII)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "menu"    # Landroid/support/v7/view/menu/l;
    .param p3, "anchorView"    # Landroid/view/View;
    .param p4, "overflowOnly"    # Z
    .param p5, "popupStyleAttr"    # I
    .param p6, "popupStyleRes"    # I

    .line 84
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 60
    const v0, 0x800003

    iput v0, p0, Landroid/support/v7/view/menu/u;->g:I

    .line 334
    new-instance v0, Landroid/support/v7/view/menu/t;

    invoke-direct {v0, p0}, Landroid/support/v7/view/menu/t;-><init>(Landroid/support/v7/view/menu/u;)V

    iput-object v0, p0, Landroid/support/v7/view/menu/u;->l:Landroid/widget/PopupWindow$OnDismissListener;

    .line 85
    iput-object p1, p0, Landroid/support/v7/view/menu/u;->a:Landroid/content/Context;

    .line 86
    iput-object p2, p0, Landroid/support/v7/view/menu/u;->b:Landroid/support/v7/view/menu/l;

    .line 87
    iput-object p3, p0, Landroid/support/v7/view/menu/u;->f:Landroid/view/View;

    .line 88
    iput-boolean p4, p0, Landroid/support/v7/view/menu/u;->c:Z

    .line 89
    iput p5, p0, Landroid/support/v7/view/menu/u;->d:I

    .line 90
    iput p6, p0, Landroid/support/v7/view/menu/u;->e:I

    .line 91
    return-void
.end method

.method private a(IIZZ)V
    .locals 9
    .param p1, "xOffset"    # I
    .param p2, "yOffset"    # I
    .param p3, "useOffsets"    # Z
    .param p4, "showTitle"    # Z

    .line 263
    invoke-virtual {p0}, Landroid/support/v7/view/menu/u;->b()Landroid/support/v7/view/menu/s;

    move-result-object v0

    .line 264
    .local v0, "popup":Landroid/support/v7/view/menu/s;
    invoke-virtual {v0, p4}, Landroid/support/v7/view/menu/s;->c(Z)V

    .line 266
    if-eqz p3, :cond_1

    .line 270
    iget v1, p0, Landroid/support/v7/view/menu/u;->g:I

    iget-object v2, p0, Landroid/support/v7/view/menu/u;->f:Landroid/view/View;

    .line 271
    invoke-static {v2}, La/b/c/g/u;->d(Landroid/view/View;)I

    move-result v2

    .line 270
    invoke-static {v1, v2}, La/b/c/g/f;->a(II)I

    move-result v1

    and-int/lit8 v1, v1, 0x7

    .line 272
    .local v1, "hgrav":I
    const/4 v2, 0x5

    if-ne v1, v2, :cond_0

    .line 273
    iget-object v2, p0, Landroid/support/v7/view/menu/u;->f:Landroid/view/View;

    invoke-virtual {v2}, Landroid/view/View;->getWidth()I

    move-result v2

    sub-int/2addr p1, v2

    .line 276
    :cond_0
    invoke-virtual {v0, p1}, Landroid/support/v7/view/menu/s;->b(I)V

    .line 277
    invoke-virtual {v0, p2}, Landroid/support/v7/view/menu/s;->c(I)V

    .line 283
    iget-object v2, p0, Landroid/support/v7/view/menu/u;->a:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v2

    iget v2, v2, Landroid/util/DisplayMetrics;->density:F

    .line 284
    .local v2, "density":F
    const/high16 v3, 0x42400000    # 48.0f

    mul-float v3, v3, v2

    const/high16 v4, 0x40000000    # 2.0f

    div-float/2addr v3, v4

    float-to-int v3, v3

    .line 285
    .local v3, "halfSize":I
    new-instance v4, Landroid/graphics/Rect;

    sub-int v5, p1, v3

    sub-int v6, p2, v3

    add-int v7, p1, v3

    add-int v8, p2, v3

    invoke-direct {v4, v5, v6, v7, v8}, Landroid/graphics/Rect;-><init>(IIII)V

    .line 287
    .local v4, "epicenter":Landroid/graphics/Rect;
    invoke-virtual {v0, v4}, Landroid/support/v7/view/menu/s;->a(Landroid/graphics/Rect;)V

    .line 290
    .end local v1    # "hgrav":I
    .end local v2    # "density":F
    .end local v3    # "halfSize":I
    .end local v4    # "epicenter":Landroid/graphics/Rect;
    :cond_1
    invoke-interface {v0}, Landroid/support/v7/view/menu/z;->c()V

    .line 291
    return-void
.end method

.method private g()Landroid/support/v7/view/menu/s;
    .locals 14

    .line 224
    iget-object v0, p0, Landroid/support/v7/view/menu/u;->a:Landroid/content/Context;

    const-string v1, "window"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/WindowManager;

    .line 226
    .local v0, "windowManager":Landroid/view/WindowManager;
    invoke-interface {v0}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v1

    .line 227
    .local v1, "display":Landroid/view/Display;
    new-instance v2, Landroid/graphics/Point;

    invoke-direct {v2}, Landroid/graphics/Point;-><init>()V

    .line 229
    .local v2, "displaySize":Landroid/graphics/Point;
    sget v3, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v4, 0x11

    if-lt v3, v4, :cond_0

    .line 230
    invoke-virtual {v1, v2}, Landroid/view/Display;->getRealSize(Landroid/graphics/Point;)V

    goto :goto_0

    .line 232
    :cond_0
    invoke-virtual {v1, v2}, Landroid/view/Display;->getSize(Landroid/graphics/Point;)V

    .line 235
    :goto_0
    iget v3, v2, Landroid/graphics/Point;->x:I

    iget v4, v2, Landroid/graphics/Point;->y:I

    invoke-static {v3, v4}, Ljava/lang/Math;->min(II)I

    move-result v3

    .line 236
    .local v3, "smallestWidth":I
    iget-object v4, p0, Landroid/support/v7/view/menu/u;->a:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, La/b/d/a/d;->abc_cascading_menus_min_smallest_width:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v4

    .line 238
    .local v4, "minSmallestWidthCascading":I
    if-lt v3, v4, :cond_1

    const/4 v5, 0x1

    goto :goto_1

    :cond_1
    const/4 v5, 0x0

    .line 241
    .local v5, "enableCascadingSubmenus":Z
    :goto_1
    if-eqz v5, :cond_2

    .line 242
    new-instance v12, Landroid/support/v7/view/menu/i;

    iget-object v7, p0, Landroid/support/v7/view/menu/u;->a:Landroid/content/Context;

    iget-object v8, p0, Landroid/support/v7/view/menu/u;->f:Landroid/view/View;

    iget v9, p0, Landroid/support/v7/view/menu/u;->d:I

    iget v10, p0, Landroid/support/v7/view/menu/u;->e:I

    iget-boolean v11, p0, Landroid/support/v7/view/menu/u;->c:Z

    move-object v6, v12

    invoke-direct/range {v6 .. v11}, Landroid/support/v7/view/menu/i;-><init>(Landroid/content/Context;Landroid/view/View;IIZ)V

    .local v6, "popup":Landroid/support/v7/view/menu/s;
    goto :goto_2

    .line 245
    .end local v6    # "popup":Landroid/support/v7/view/menu/s;
    :cond_2
    new-instance v6, Landroid/support/v7/view/menu/C;

    iget-object v8, p0, Landroid/support/v7/view/menu/u;->a:Landroid/content/Context;

    iget-object v9, p0, Landroid/support/v7/view/menu/u;->b:Landroid/support/v7/view/menu/l;

    iget-object v10, p0, Landroid/support/v7/view/menu/u;->f:Landroid/view/View;

    iget v11, p0, Landroid/support/v7/view/menu/u;->d:I

    iget v12, p0, Landroid/support/v7/view/menu/u;->e:I

    iget-boolean v13, p0, Landroid/support/v7/view/menu/u;->c:Z

    move-object v7, v6

    invoke-direct/range {v7 .. v13}, Landroid/support/v7/view/menu/C;-><init>(Landroid/content/Context;Landroid/support/v7/view/menu/l;Landroid/view/View;IIZ)V

    .line 250
    .restart local v6    # "popup":Landroid/support/v7/view/menu/s;
    :goto_2
    iget-object v7, p0, Landroid/support/v7/view/menu/u;->b:Landroid/support/v7/view/menu/l;

    invoke-virtual {v6, v7}, Landroid/support/v7/view/menu/s;->a(Landroid/support/v7/view/menu/l;)V

    .line 251
    iget-object v7, p0, Landroid/support/v7/view/menu/u;->l:Landroid/widget/PopupWindow$OnDismissListener;

    invoke-virtual {v6, v7}, Landroid/support/v7/view/menu/s;->a(Landroid/widget/PopupWindow$OnDismissListener;)V

    .line 254
    iget-object v7, p0, Landroid/support/v7/view/menu/u;->f:Landroid/view/View;

    invoke-virtual {v6, v7}, Landroid/support/v7/view/menu/s;->a(Landroid/view/View;)V

    .line 255
    iget-object v7, p0, Landroid/support/v7/view/menu/u;->i:Landroid/support/v7/view/menu/v$a;

    invoke-interface {v6, v7}, Landroid/support/v7/view/menu/v;->a(Landroid/support/v7/view/menu/v$a;)V

    .line 256
    iget-boolean v7, p0, Landroid/support/v7/view/menu/u;->h:Z

    invoke-virtual {v6, v7}, Landroid/support/v7/view/menu/s;->b(Z)V

    .line 257
    iget v7, p0, Landroid/support/v7/view/menu/u;->g:I

    invoke-virtual {v6, v7}, Landroid/support/v7/view/menu/s;->a(I)V

    .line 259
    return-object v6
.end method


# virtual methods
.method public a()V
    .locals 1

    .line 298
    invoke-virtual {p0}, Landroid/support/v7/view/menu/u;->c()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 299
    iget-object v0, p0, Landroid/support/v7/view/menu/u;->j:Landroid/support/v7/view/menu/s;

    invoke-interface {v0}, Landroid/support/v7/view/menu/z;->dismiss()V

    .line 301
    :cond_0
    return-void
.end method

.method public a(I)V
    .locals 0
    .param p1, "gravity"    # I

    .line 132
    iput p1, p0, Landroid/support/v7/view/menu/u;->g:I

    .line 133
    return-void
.end method

.method public a(Landroid/support/v7/view/menu/v$a;)V
    .locals 1
    .param p1, "cb"    # Landroid/support/v7/view/menu/v$a;

    .line 325
    iput-object p1, p0, Landroid/support/v7/view/menu/u;->i:Landroid/support/v7/view/menu/v$a;

    .line 326
    iget-object v0, p0, Landroid/support/v7/view/menu/u;->j:Landroid/support/v7/view/menu/s;

    if-eqz v0, :cond_0

    .line 327
    invoke-interface {v0, p1}, Landroid/support/v7/view/menu/v;->a(Landroid/support/v7/view/menu/v$a;)V

    .line 329
    :cond_0
    return-void
.end method

.method public a(Landroid/view/View;)V
    .locals 0
    .param p1, "anchor"    # Landroid/view/View;

    .line 105
    iput-object p1, p0, Landroid/support/v7/view/menu/u;->f:Landroid/view/View;

    .line 106
    return-void
.end method

.method public a(Landroid/widget/PopupWindow$OnDismissListener;)V
    .locals 0
    .param p1, "listener"    # Landroid/widget/PopupWindow$OnDismissListener;

    .line 94
    iput-object p1, p0, Landroid/support/v7/view/menu/u;->k:Landroid/widget/PopupWindow$OnDismissListener;

    .line 95
    return-void
.end method

.method public a(Z)V
    .locals 1
    .param p1, "forceShowIcon"    # Z

    .line 118
    iput-boolean p1, p0, Landroid/support/v7/view/menu/u;->h:Z

    .line 119
    iget-object v0, p0, Landroid/support/v7/view/menu/u;->j:Landroid/support/v7/view/menu/s;

    if-eqz v0, :cond_0

    .line 120
    invoke-virtual {v0, p1}, Landroid/support/v7/view/menu/s;->b(Z)V

    .line 122
    :cond_0
    return-void
.end method

.method public a(II)Z
    .locals 2
    .param p1, "x"    # I
    .param p2, "y"    # I

    .line 205
    invoke-virtual {p0}, Landroid/support/v7/view/menu/u;->c()Z

    move-result v0

    const/4 v1, 0x1

    if-eqz v0, :cond_0

    .line 206
    return v1

    .line 209
    :cond_0
    iget-object v0, p0, Landroid/support/v7/view/menu/u;->f:Landroid/view/View;

    if-nez v0, :cond_1

    .line 210
    const/4 v0, 0x0

    return v0

    .line 213
    :cond_1
    invoke-direct {p0, p1, p2, v1, v1}, Landroid/support/v7/view/menu/u;->a(IIZZ)V

    .line 214
    return v1
.end method

.method public b()Landroid/support/v7/view/menu/s;
    .locals 1

    .line 156
    iget-object v0, p0, Landroid/support/v7/view/menu/u;->j:Landroid/support/v7/view/menu/s;

    if-nez v0, :cond_0

    .line 157
    invoke-direct {p0}, Landroid/support/v7/view/menu/u;->g()Landroid/support/v7/view/menu/s;

    move-result-object v0

    iput-object v0, p0, Landroid/support/v7/view/menu/u;->j:Landroid/support/v7/view/menu/s;

    .line 159
    :cond_0
    iget-object v0, p0, Landroid/support/v7/view/menu/u;->j:Landroid/support/v7/view/menu/s;

    return-object v0
.end method

.method public c()Z
    .locals 1

    .line 320
    iget-object v0, p0, Landroid/support/v7/view/menu/u;->j:Landroid/support/v7/view/menu/s;

    if-eqz v0, :cond_0

    invoke-interface {v0}, Landroid/support/v7/view/menu/z;->b()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method protected d()V
    .locals 1

    .line 312
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/support/v7/view/menu/u;->j:Landroid/support/v7/view/menu/s;

    .line 314
    iget-object v0, p0, Landroid/support/v7/view/menu/u;->k:Landroid/widget/PopupWindow$OnDismissListener;

    if-eqz v0, :cond_0

    .line 315
    invoke-interface {v0}, Landroid/widget/PopupWindow$OnDismissListener;->onDismiss()V

    .line 317
    :cond_0
    return-void
.end method

.method public e()V
    .locals 2

    .line 143
    invoke-virtual {p0}, Landroid/support/v7/view/menu/u;->f()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 146
    return-void

    .line 144
    :cond_0
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "MenuPopupHelper cannot be used without an anchor"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public f()Z
    .locals 3

    .line 169
    invoke-virtual {p0}, Landroid/support/v7/view/menu/u;->c()Z

    move-result v0

    const/4 v1, 0x1

    if-eqz v0, :cond_0

    .line 170
    return v1

    .line 173
    :cond_0
    iget-object v0, p0, Landroid/support/v7/view/menu/u;->f:Landroid/view/View;

    const/4 v2, 0x0

    if-nez v0, :cond_1

    .line 174
    return v2

    .line 177
    :cond_1
    invoke-direct {p0, v2, v2, v2, v2}, Landroid/support/v7/view/menu/u;->a(IIZZ)V

    .line 178
    return v1
.end method
