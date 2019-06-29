.class public Landroid/support/v7/widget/Aa;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Landroid/support/v7/widget/L;


# instance fields
.field a:Landroid/support/v7/widget/Toolbar;

.field private b:I

.field private c:Landroid/view/View;

.field private d:Landroid/view/View;

.field private e:Landroid/graphics/drawable/Drawable;

.field private f:Landroid/graphics/drawable/Drawable;

.field private g:Landroid/graphics/drawable/Drawable;

.field private h:Z

.field i:Ljava/lang/CharSequence;

.field private j:Ljava/lang/CharSequence;

.field private k:Ljava/lang/CharSequence;

.field l:Landroid/view/Window$Callback;

.field m:Z

.field private n:Landroid/support/v7/widget/g;

.field private o:I

.field private p:I

.field private q:Landroid/graphics/drawable/Drawable;


# direct methods
.method public constructor <init>(Landroid/support/v7/widget/Toolbar;Z)V
    .locals 2
    .param p1, "toolbar"    # Landroid/support/v7/widget/Toolbar;
    .param p2, "style"    # Z

    .line 96
    sget v0, La/b/d/a/h;->abc_action_bar_up_description:I

    sget v1, La/b/d/a/e;->abc_ic_ab_back_material:I

    invoke-direct {p0, p1, p2, v0, v1}, Landroid/support/v7/widget/Aa;-><init>(Landroid/support/v7/widget/Toolbar;ZII)V

    .line 98
    return-void
.end method

.method public constructor <init>(Landroid/support/v7/widget/Toolbar;ZII)V
    .locals 16
    .param p1, "toolbar"    # Landroid/support/v7/widget/Toolbar;
    .param p2, "style"    # Z
    .param p3, "defaultNavigationContentDescription"    # I
    .param p4, "defaultNavigationIcon"    # I

    .line 101
    move-object/from16 v0, p0

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 90
    const/4 v1, 0x0

    iput v1, v0, Landroid/support/v7/widget/Aa;->o:I

    .line 92
    iput v1, v0, Landroid/support/v7/widget/Aa;->p:I

    .line 102
    move-object/from16 v2, p1

    iput-object v2, v0, Landroid/support/v7/widget/Aa;->a:Landroid/support/v7/widget/Toolbar;

    .line 103
    invoke-virtual/range {p1 .. p1}, Landroid/support/v7/widget/Toolbar;->getTitle()Ljava/lang/CharSequence;

    move-result-object v3

    iput-object v3, v0, Landroid/support/v7/widget/Aa;->i:Ljava/lang/CharSequence;

    .line 104
    invoke-virtual/range {p1 .. p1}, Landroid/support/v7/widget/Toolbar;->getSubtitle()Ljava/lang/CharSequence;

    move-result-object v3

    iput-object v3, v0, Landroid/support/v7/widget/Aa;->j:Ljava/lang/CharSequence;

    .line 105
    iget-object v3, v0, Landroid/support/v7/widget/Aa;->i:Ljava/lang/CharSequence;

    if-eqz v3, :cond_0

    const/4 v3, 0x1

    goto :goto_0

    :cond_0
    const/4 v3, 0x0

    :goto_0
    iput-boolean v3, v0, Landroid/support/v7/widget/Aa;->h:Z

    .line 106
    invoke-virtual/range {p1 .. p1}, Landroid/support/v7/widget/Toolbar;->getNavigationIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v3

    iput-object v3, v0, Landroid/support/v7/widget/Aa;->g:Landroid/graphics/drawable/Drawable;

    .line 107
    invoke-virtual/range {p1 .. p1}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v3

    const/4 v4, 0x0

    sget-object v5, La/b/d/a/j;->ActionBar:[I

    sget v6, La/b/d/a/a;->actionBarStyle:I

    invoke-static {v3, v4, v5, v6, v1}, Landroid/support/v7/widget/ta;->a(Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroid/support/v7/widget/ta;

    move-result-object v3

    .line 109
    .local v3, "a":Landroid/support/v7/widget/ta;
    sget v4, La/b/d/a/j;->ActionBar_homeAsUpIndicator:I

    invoke-virtual {v3, v4}, Landroid/support/v7/widget/ta;->b(I)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    iput-object v4, v0, Landroid/support/v7/widget/Aa;->q:Landroid/graphics/drawable/Drawable;

    .line 110
    if-eqz p2, :cond_d

    .line 111
    sget v4, La/b/d/a/j;->ActionBar_title:I

    invoke-virtual {v3, v4}, Landroid/support/v7/widget/ta;->e(I)Ljava/lang/CharSequence;

    move-result-object v4

    .line 112
    .local v4, "title":Ljava/lang/CharSequence;
    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_1

    .line 113
    invoke-virtual {v0, v4}, Landroid/support/v7/widget/Aa;->c(Ljava/lang/CharSequence;)V

    .line 116
    :cond_1
    sget v5, La/b/d/a/j;->ActionBar_subtitle:I

    invoke-virtual {v3, v5}, Landroid/support/v7/widget/ta;->e(I)Ljava/lang/CharSequence;

    move-result-object v5

    .line 117
    .local v5, "subtitle":Ljava/lang/CharSequence;
    invoke-static {v5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_2

    .line 118
    invoke-virtual {v0, v5}, Landroid/support/v7/widget/Aa;->b(Ljava/lang/CharSequence;)V

    .line 121
    :cond_2
    sget v6, La/b/d/a/j;->ActionBar_logo:I

    invoke-virtual {v3, v6}, Landroid/support/v7/widget/ta;->b(I)Landroid/graphics/drawable/Drawable;

    move-result-object v6

    .line 122
    .local v6, "logo":Landroid/graphics/drawable/Drawable;
    if-eqz v6, :cond_3

    .line 123
    invoke-virtual {v0, v6}, Landroid/support/v7/widget/Aa;->a(Landroid/graphics/drawable/Drawable;)V

    .line 126
    :cond_3
    sget v7, La/b/d/a/j;->ActionBar_icon:I

    invoke-virtual {v3, v7}, Landroid/support/v7/widget/ta;->b(I)Landroid/graphics/drawable/Drawable;

    move-result-object v7

    .line 127
    .local v7, "icon":Landroid/graphics/drawable/Drawable;
    if-eqz v7, :cond_4

    .line 128
    invoke-virtual {v0, v7}, Landroid/support/v7/widget/Aa;->setIcon(Landroid/graphics/drawable/Drawable;)V

    .line 130
    :cond_4
    iget-object v8, v0, Landroid/support/v7/widget/Aa;->g:Landroid/graphics/drawable/Drawable;

    if-nez v8, :cond_5

    iget-object v8, v0, Landroid/support/v7/widget/Aa;->q:Landroid/graphics/drawable/Drawable;

    if-eqz v8, :cond_5

    .line 131
    invoke-virtual {v0, v8}, Landroid/support/v7/widget/Aa;->b(Landroid/graphics/drawable/Drawable;)V

    .line 133
    :cond_5
    sget v8, La/b/d/a/j;->ActionBar_displayOptions:I

    invoke-virtual {v3, v8, v1}, Landroid/support/v7/widget/ta;->d(II)I

    move-result v8

    invoke-virtual {v0, v8}, Landroid/support/v7/widget/Aa;->a(I)V

    .line 135
    sget v8, La/b/d/a/j;->ActionBar_customNavigationLayout:I

    invoke-virtual {v3, v8, v1}, Landroid/support/v7/widget/ta;->g(II)I

    move-result v8

    .line 137
    .local v8, "customNavId":I
    if-eqz v8, :cond_6

    .line 138
    iget-object v9, v0, Landroid/support/v7/widget/Aa;->a:Landroid/support/v7/widget/Toolbar;

    invoke-virtual {v9}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v9

    invoke-static {v9}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v9

    iget-object v10, v0, Landroid/support/v7/widget/Aa;->a:Landroid/support/v7/widget/Toolbar;

    invoke-virtual {v9, v8, v10, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v9

    invoke-virtual {v0, v9}, Landroid/support/v7/widget/Aa;->a(Landroid/view/View;)V

    .line 140
    iget v9, v0, Landroid/support/v7/widget/Aa;->b:I

    or-int/lit8 v9, v9, 0x10

    invoke-virtual {v0, v9}, Landroid/support/v7/widget/Aa;->a(I)V

    .line 143
    :cond_6
    sget v9, La/b/d/a/j;->ActionBar_height:I

    invoke-virtual {v3, v9, v1}, Landroid/support/v7/widget/ta;->f(II)I

    move-result v9

    .line 144
    .local v9, "height":I
    if-lez v9, :cond_7

    .line 145
    iget-object v10, v0, Landroid/support/v7/widget/Aa;->a:Landroid/support/v7/widget/Toolbar;

    invoke-virtual {v10}, Landroid/view/ViewGroup;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v10

    .line 146
    .local v10, "lp":Landroid/view/ViewGroup$LayoutParams;
    iput v9, v10, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 147
    iget-object v11, v0, Landroid/support/v7/widget/Aa;->a:Landroid/support/v7/widget/Toolbar;

    invoke-virtual {v11, v10}, Landroid/view/ViewGroup;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 150
    .end local v10    # "lp":Landroid/view/ViewGroup$LayoutParams;
    :cond_7
    sget v10, La/b/d/a/j;->ActionBar_contentInsetStart:I

    const/4 v11, -0x1

    invoke-virtual {v3, v10, v11}, Landroid/support/v7/widget/ta;->b(II)I

    move-result v10

    .line 152
    .local v10, "contentInsetStart":I
    sget v12, La/b/d/a/j;->ActionBar_contentInsetEnd:I

    invoke-virtual {v3, v12, v11}, Landroid/support/v7/widget/ta;->b(II)I

    move-result v11

    .line 154
    .local v11, "contentInsetEnd":I
    if-gez v10, :cond_8

    if-ltz v11, :cond_9

    .line 155
    :cond_8
    iget-object v12, v0, Landroid/support/v7/widget/Aa;->a:Landroid/support/v7/widget/Toolbar;

    invoke-static {v10, v1}, Ljava/lang/Math;->max(II)I

    move-result v13

    .line 156
    invoke-static {v11, v1}, Ljava/lang/Math;->max(II)I

    move-result v14

    .line 155
    invoke-virtual {v12, v13, v14}, Landroid/support/v7/widget/Toolbar;->a(II)V

    .line 159
    :cond_9
    sget v12, La/b/d/a/j;->ActionBar_titleTextStyle:I

    invoke-virtual {v3, v12, v1}, Landroid/support/v7/widget/ta;->g(II)I

    move-result v12

    .line 160
    .local v12, "titleTextStyle":I
    if-eqz v12, :cond_a

    .line 161
    iget-object v13, v0, Landroid/support/v7/widget/Aa;->a:Landroid/support/v7/widget/Toolbar;

    invoke-virtual {v13}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v14

    invoke-virtual {v13, v14, v12}, Landroid/support/v7/widget/Toolbar;->b(Landroid/content/Context;I)V

    .line 164
    :cond_a
    sget v13, La/b/d/a/j;->ActionBar_subtitleTextStyle:I

    invoke-virtual {v3, v13, v1}, Landroid/support/v7/widget/ta;->g(II)I

    move-result v13

    .line 166
    .local v13, "subtitleTextStyle":I
    if-eqz v13, :cond_b

    .line 167
    iget-object v14, v0, Landroid/support/v7/widget/Aa;->a:Landroid/support/v7/widget/Toolbar;

    invoke-virtual {v14}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v15

    invoke-virtual {v14, v15, v13}, Landroid/support/v7/widget/Toolbar;->a(Landroid/content/Context;I)V

    .line 170
    :cond_b
    sget v14, La/b/d/a/j;->ActionBar_popupTheme:I

    invoke-virtual {v3, v14, v1}, Landroid/support/v7/widget/ta;->g(II)I

    move-result v1

    .line 171
    .local v1, "popupTheme":I
    if-eqz v1, :cond_c

    .line 172
    iget-object v14, v0, Landroid/support/v7/widget/Aa;->a:Landroid/support/v7/widget/Toolbar;

    invoke-virtual {v14, v1}, Landroid/support/v7/widget/Toolbar;->setPopupTheme(I)V

    .line 174
    .end local v1    # "popupTheme":I
    .end local v4    # "title":Ljava/lang/CharSequence;
    .end local v5    # "subtitle":Ljava/lang/CharSequence;
    .end local v6    # "logo":Landroid/graphics/drawable/Drawable;
    .end local v7    # "icon":Landroid/graphics/drawable/Drawable;
    .end local v8    # "customNavId":I
    .end local v9    # "height":I
    .end local v10    # "contentInsetStart":I
    .end local v11    # "contentInsetEnd":I
    .end local v12    # "titleTextStyle":I
    .end local v13    # "subtitleTextStyle":I
    :cond_c
    goto :goto_1

    .line 175
    :cond_d
    invoke-direct/range {p0 .. p0}, Landroid/support/v7/widget/Aa;->o()I

    move-result v1

    iput v1, v0, Landroid/support/v7/widget/Aa;->b:I

    .line 177
    :goto_1
    invoke-virtual {v3}, Landroid/support/v7/widget/ta;->a()V

    .line 179
    move/from16 v1, p3

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/Aa;->d(I)V

    .line 180
    iget-object v4, v0, Landroid/support/v7/widget/Aa;->a:Landroid/support/v7/widget/Toolbar;

    invoke-virtual {v4}, Landroid/support/v7/widget/Toolbar;->getNavigationContentDescription()Ljava/lang/CharSequence;

    move-result-object v4

    iput-object v4, v0, Landroid/support/v7/widget/Aa;->k:Ljava/lang/CharSequence;

    .line 182
    iget-object v4, v0, Landroid/support/v7/widget/Aa;->a:Landroid/support/v7/widget/Toolbar;

    new-instance v5, Landroid/support/v7/widget/ya;

    invoke-direct {v5, v0}, Landroid/support/v7/widget/ya;-><init>(Landroid/support/v7/widget/Aa;)V

    invoke-virtual {v4, v5}, Landroid/support/v7/widget/Toolbar;->setNavigationOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 192
    return-void
.end method

.method private d(Ljava/lang/CharSequence;)V
    .locals 1
    .param p1, "title"    # Ljava/lang/CharSequence;

    .line 260
    iput-object p1, p0, Landroid/support/v7/widget/Aa;->i:Ljava/lang/CharSequence;

    .line 261
    iget v0, p0, Landroid/support/v7/widget/Aa;->b:I

    and-int/lit8 v0, v0, 0x8

    if-eqz v0, :cond_0

    .line 262
    iget-object v0, p0, Landroid/support/v7/widget/Aa;->a:Landroid/support/v7/widget/Toolbar;

    invoke-virtual {v0, p1}, Landroid/support/v7/widget/Toolbar;->setTitle(Ljava/lang/CharSequence;)V

    .line 264
    :cond_0
    return-void
.end method

.method private o()I
    .locals 2

    .line 206
    const/16 v0, 0xb

    .line 208
    .local v0, "opts":I
    iget-object v1, p0, Landroid/support/v7/widget/Aa;->a:Landroid/support/v7/widget/Toolbar;

    invoke-virtual {v1}, Landroid/support/v7/widget/Toolbar;->getNavigationIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 209
    or-int/lit8 v0, v0, 0x4

    .line 210
    iget-object v1, p0, Landroid/support/v7/widget/Aa;->a:Landroid/support/v7/widget/Toolbar;

    invoke-virtual {v1}, Landroid/support/v7/widget/Toolbar;->getNavigationIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v1

    iput-object v1, p0, Landroid/support/v7/widget/Aa;->q:Landroid/graphics/drawable/Drawable;

    .line 212
    :cond_0
    return v0
.end method

.method private p()V
    .locals 2

    .line 630
    iget v0, p0, Landroid/support/v7/widget/Aa;->b:I

    and-int/lit8 v0, v0, 0x4

    if-eqz v0, :cond_1

    .line 631
    iget-object v0, p0, Landroid/support/v7/widget/Aa;->k:Ljava/lang/CharSequence;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 632
    iget-object v0, p0, Landroid/support/v7/widget/Aa;->a:Landroid/support/v7/widget/Toolbar;

    iget v1, p0, Landroid/support/v7/widget/Aa;->p:I

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/Toolbar;->setNavigationContentDescription(I)V

    goto :goto_0

    .line 634
    :cond_0
    iget-object v0, p0, Landroid/support/v7/widget/Aa;->a:Landroid/support/v7/widget/Toolbar;

    iget-object v1, p0, Landroid/support/v7/widget/Aa;->k:Ljava/lang/CharSequence;

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/Toolbar;->setNavigationContentDescription(Ljava/lang/CharSequence;)V

    .line 637
    :cond_1
    :goto_0
    return-void
.end method

.method private q()V
    .locals 2

    .line 611
    iget v0, p0, Landroid/support/v7/widget/Aa;->b:I

    and-int/lit8 v0, v0, 0x4

    if-eqz v0, :cond_1

    .line 612
    iget-object v0, p0, Landroid/support/v7/widget/Aa;->a:Landroid/support/v7/widget/Toolbar;

    iget-object v1, p0, Landroid/support/v7/widget/Aa;->g:Landroid/graphics/drawable/Drawable;

    if-eqz v1, :cond_0

    goto :goto_0

    :cond_0
    iget-object v1, p0, Landroid/support/v7/widget/Aa;->q:Landroid/graphics/drawable/Drawable;

    :goto_0
    invoke-virtual {v0, v1}, Landroid/support/v7/widget/Toolbar;->setNavigationIcon(Landroid/graphics/drawable/Drawable;)V

    goto :goto_1

    .line 614
    :cond_1
    iget-object v0, p0, Landroid/support/v7/widget/Aa;->a:Landroid/support/v7/widget/Toolbar;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/Toolbar;->setNavigationIcon(Landroid/graphics/drawable/Drawable;)V

    .line 616
    :goto_1
    return-void
.end method

.method private r()V
    .locals 3

    .line 322
    const/4 v0, 0x0

    .line 323
    .local v0, "logo":Landroid/graphics/drawable/Drawable;
    iget v1, p0, Landroid/support/v7/widget/Aa;->b:I

    and-int/lit8 v2, v1, 0x2

    if-eqz v2, :cond_2

    .line 324
    and-int/lit8 v1, v1, 0x1

    if-eqz v1, :cond_1

    .line 325
    iget-object v1, p0, Landroid/support/v7/widget/Aa;->f:Landroid/graphics/drawable/Drawable;

    if-eqz v1, :cond_0

    goto :goto_0

    :cond_0
    iget-object v1, p0, Landroid/support/v7/widget/Aa;->e:Landroid/graphics/drawable/Drawable;

    :goto_0
    move-object v0, v1

    goto :goto_1

    .line 327
    :cond_1
    iget-object v0, p0, Landroid/support/v7/widget/Aa;->e:Landroid/graphics/drawable/Drawable;

    .line 330
    :cond_2
    :goto_1
    iget-object v1, p0, Landroid/support/v7/widget/Aa;->a:Landroid/support/v7/widget/Toolbar;

    invoke-virtual {v1, v0}, Landroid/support/v7/widget/Toolbar;->setLogo(Landroid/graphics/drawable/Drawable;)V

    .line 331
    return-void
.end method


# virtual methods
.method public a(IJ)La/b/c/g/A;
    .locals 2
    .param p1, "visibility"    # I
    .param p2, "duration"    # J

    .line 566
    iget-object v0, p0, Landroid/support/v7/widget/Aa;->a:Landroid/support/v7/widget/Toolbar;

    invoke-static {v0}, La/b/c/g/u;->a(Landroid/view/View;)La/b/c/g/A;

    move-result-object v0

    if-nez p1, :cond_0

    const/high16 v1, 0x3f800000    # 1.0f

    goto :goto_0

    :cond_0
    const/4 v1, 0x0

    .line 567
    :goto_0
    invoke-virtual {v0, v1}, La/b/c/g/A;->a(F)La/b/c/g/A;

    .line 568
    invoke-virtual {v0, p2, p3}, La/b/c/g/A;->a(J)La/b/c/g/A;

    new-instance v1, Landroid/support/v7/widget/za;

    invoke-direct {v1, p0, p1}, Landroid/support/v7/widget/za;-><init>(Landroid/support/v7/widget/Aa;I)V

    .line 569
    invoke-virtual {v0, v1}, La/b/c/g/A;->a(La/b/c/g/B;)La/b/c/g/A;

    return-object v0
.end method

.method public a(I)V
    .locals 4
    .param p1, "newOpts"    # I

    .line 385
    iget v0, p0, Landroid/support/v7/widget/Aa;->b:I

    .line 386
    .local v0, "oldOpts":I
    xor-int v1, v0, p1

    .line 387
    .local v1, "changed":I
    iput p1, p0, Landroid/support/v7/widget/Aa;->b:I

    .line 388
    if-eqz v1, :cond_6

    .line 389
    and-int/lit8 v2, v1, 0x4

    if-eqz v2, :cond_1

    .line 390
    and-int/lit8 v2, p1, 0x4

    if-eqz v2, :cond_0

    .line 391
    invoke-direct {p0}, Landroid/support/v7/widget/Aa;->p()V

    .line 393
    :cond_0
    invoke-direct {p0}, Landroid/support/v7/widget/Aa;->q()V

    .line 396
    :cond_1
    and-int/lit8 v2, v1, 0x3

    if-eqz v2, :cond_2

    .line 397
    invoke-direct {p0}, Landroid/support/v7/widget/Aa;->r()V

    .line 400
    :cond_2
    and-int/lit8 v2, v1, 0x8

    if-eqz v2, :cond_4

    .line 401
    and-int/lit8 v2, p1, 0x8

    if-eqz v2, :cond_3

    .line 402
    iget-object v2, p0, Landroid/support/v7/widget/Aa;->a:Landroid/support/v7/widget/Toolbar;

    iget-object v3, p0, Landroid/support/v7/widget/Aa;->i:Ljava/lang/CharSequence;

    invoke-virtual {v2, v3}, Landroid/support/v7/widget/Toolbar;->setTitle(Ljava/lang/CharSequence;)V

    .line 403
    iget-object v2, p0, Landroid/support/v7/widget/Aa;->a:Landroid/support/v7/widget/Toolbar;

    iget-object v3, p0, Landroid/support/v7/widget/Aa;->j:Ljava/lang/CharSequence;

    invoke-virtual {v2, v3}, Landroid/support/v7/widget/Toolbar;->setSubtitle(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 405
    :cond_3
    iget-object v2, p0, Landroid/support/v7/widget/Aa;->a:Landroid/support/v7/widget/Toolbar;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/support/v7/widget/Toolbar;->setTitle(Ljava/lang/CharSequence;)V

    .line 406
    iget-object v2, p0, Landroid/support/v7/widget/Aa;->a:Landroid/support/v7/widget/Toolbar;

    invoke-virtual {v2, v3}, Landroid/support/v7/widget/Toolbar;->setSubtitle(Ljava/lang/CharSequence;)V

    .line 410
    :cond_4
    :goto_0
    and-int/lit8 v2, v1, 0x10

    if-eqz v2, :cond_6

    iget-object v2, p0, Landroid/support/v7/widget/Aa;->d:Landroid/view/View;

    if-eqz v2, :cond_6

    .line 411
    and-int/lit8 v3, p1, 0x10

    if-eqz v3, :cond_5

    .line 412
    iget-object v3, p0, Landroid/support/v7/widget/Aa;->a:Landroid/support/v7/widget/Toolbar;

    invoke-virtual {v3, v2}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    goto :goto_1

    .line 414
    :cond_5
    iget-object v3, p0, Landroid/support/v7/widget/Aa;->a:Landroid/support/v7/widget/Toolbar;

    invoke-virtual {v3, v2}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    .line 418
    :cond_6
    :goto_1
    return-void
.end method

.method public a(Landroid/graphics/drawable/Drawable;)V
    .locals 0
    .param p1, "d"    # Landroid/graphics/drawable/Drawable;

    .line 317
    iput-object p1, p0, Landroid/support/v7/widget/Aa;->f:Landroid/graphics/drawable/Drawable;

    .line 318
    invoke-direct {p0}, Landroid/support/v7/widget/Aa;->r()V

    .line 319
    return-void
.end method

.method public a(Landroid/support/v7/widget/aa;)V
    .locals 3
    .param p1, "tabView"    # Landroid/support/v7/widget/aa;

    .line 422
    iget-object v0, p0, Landroid/support/v7/widget/Aa;->c:Landroid/view/View;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    iget-object v1, p0, Landroid/support/v7/widget/Aa;->a:Landroid/support/v7/widget/Toolbar;

    if-ne v0, v1, :cond_0

    .line 423
    iget-object v0, p0, Landroid/support/v7/widget/Aa;->c:Landroid/view/View;

    invoke-virtual {v1, v0}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    .line 425
    :cond_0
    iput-object p1, p0, Landroid/support/v7/widget/Aa;->c:Landroid/view/View;

    .line 426
    if-eqz p1, :cond_1

    iget v0, p0, Landroid/support/v7/widget/Aa;->o:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_1

    .line 427
    iget-object v0, p0, Landroid/support/v7/widget/Aa;->a:Landroid/support/v7/widget/Toolbar;

    iget-object v1, p0, Landroid/support/v7/widget/Aa;->c:Landroid/view/View;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/ViewGroup;->addView(Landroid/view/View;I)V

    .line 428
    iget-object v0, p0, Landroid/support/v7/widget/Aa;->c:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/Toolbar$b;

    .line 429
    .local v0, "lp":Landroid/support/v7/widget/Toolbar$b;
    const/4 v1, -0x2

    iput v1, v0, Landroid/view/ViewGroup$MarginLayoutParams;->width:I

    .line 430
    iput v1, v0, Landroid/view/ViewGroup$MarginLayoutParams;->height:I

    .line 431
    const v1, 0x800053

    iput v1, v0, Landroid/support/v7/app/a$a;->a:I

    .line 432
    const/4 v1, 0x1

    invoke-virtual {p1, v1}, Landroid/support/v7/widget/aa;->setAllowCollapse(Z)V

    .line 434
    .end local v0    # "lp":Landroid/support/v7/widget/Toolbar$b;
    :cond_1
    return-void
.end method

.method public a(Landroid/view/Menu;Landroid/support/v7/view/menu/v$a;)V
    .locals 3
    .param p1, "menu"    # Landroid/view/Menu;
    .param p2, "cb"    # Landroid/support/v7/view/menu/v$a;

    .line 365
    iget-object v0, p0, Landroid/support/v7/widget/Aa;->n:Landroid/support/v7/widget/g;

    if-nez v0, :cond_0

    .line 366
    new-instance v0, Landroid/support/v7/widget/g;

    iget-object v1, p0, Landroid/support/v7/widget/Aa;->a:Landroid/support/v7/widget/Toolbar;

    invoke-virtual {v1}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/support/v7/widget/g;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Landroid/support/v7/widget/Aa;->n:Landroid/support/v7/widget/g;

    .line 367
    iget-object v0, p0, Landroid/support/v7/widget/Aa;->n:Landroid/support/v7/widget/g;

    sget v1, La/b/d/a/f;->action_menu_presenter:I

    invoke-virtual {v0, v1}, Landroid/support/v7/view/menu/b;->a(I)V

    .line 369
    :cond_0
    iget-object v0, p0, Landroid/support/v7/widget/Aa;->n:Landroid/support/v7/widget/g;

    invoke-virtual {v0, p2}, Landroid/support/v7/view/menu/b;->a(Landroid/support/v7/view/menu/v$a;)V

    .line 370
    iget-object v0, p0, Landroid/support/v7/widget/Aa;->a:Landroid/support/v7/widget/Toolbar;

    move-object v1, p1

    check-cast v1, Landroid/support/v7/view/menu/l;

    iget-object v2, p0, Landroid/support/v7/widget/Aa;->n:Landroid/support/v7/widget/g;

    invoke-virtual {v0, v1, v2}, Landroid/support/v7/widget/Toolbar;->a(Landroid/support/v7/view/menu/l;Landroid/support/v7/widget/g;)V

    .line 371
    return-void
.end method

.method public a(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .line 540
    iget-object v0, p0, Landroid/support/v7/widget/Aa;->d:Landroid/view/View;

    if-eqz v0, :cond_0

    iget v1, p0, Landroid/support/v7/widget/Aa;->b:I

    and-int/lit8 v1, v1, 0x10

    if-eqz v1, :cond_0

    .line 541
    iget-object v1, p0, Landroid/support/v7/widget/Aa;->a:Landroid/support/v7/widget/Toolbar;

    invoke-virtual {v1, v0}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    .line 543
    :cond_0
    iput-object p1, p0, Landroid/support/v7/widget/Aa;->d:Landroid/view/View;

    .line 544
    if-eqz p1, :cond_1

    iget v0, p0, Landroid/support/v7/widget/Aa;->b:I

    and-int/lit8 v0, v0, 0x10

    if-eqz v0, :cond_1

    .line 545
    iget-object v0, p0, Landroid/support/v7/widget/Aa;->a:Landroid/support/v7/widget/Toolbar;

    iget-object v1, p0, Landroid/support/v7/widget/Aa;->d:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 547
    :cond_1
    return-void
.end method

.method public a(Ljava/lang/CharSequence;)V
    .locals 0
    .param p1, "description"    # Ljava/lang/CharSequence;

    .line 620
    iput-object p1, p0, Landroid/support/v7/widget/Aa;->k:Ljava/lang/CharSequence;

    .line 621
    invoke-direct {p0}, Landroid/support/v7/widget/Aa;->p()V

    .line 622
    return-void
.end method

.method public a(Z)V
    .locals 0
    .param p1, "enable"    # Z

    .line 454
    return-void
.end method

.method public a()Z
    .locals 1

    .line 340
    iget-object v0, p0, Landroid/support/v7/widget/Aa;->a:Landroid/support/v7/widget/Toolbar;

    invoke-virtual {v0}, Landroid/support/v7/widget/Toolbar;->i()Z

    move-result v0

    return v0
.end method

.method public b()V
    .locals 1

    .line 360
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v7/widget/Aa;->m:Z

    .line 361
    return-void
.end method

.method public b(I)V
    .locals 1
    .param p1, "resId"    # I

    .line 312
    if-eqz p1, :cond_0

    invoke-virtual {p0}, Landroid/support/v7/widget/Aa;->k()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0, p1}, La/b/d/b/a/a;->b(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    invoke-virtual {p0, v0}, Landroid/support/v7/widget/Aa;->a(Landroid/graphics/drawable/Drawable;)V

    .line 313
    return-void
.end method

.method public b(Landroid/graphics/drawable/Drawable;)V
    .locals 0
    .param p1, "icon"    # Landroid/graphics/drawable/Drawable;

    .line 593
    iput-object p1, p0, Landroid/support/v7/widget/Aa;->g:Landroid/graphics/drawable/Drawable;

    .line 594
    invoke-direct {p0}, Landroid/support/v7/widget/Aa;->q()V

    .line 595
    return-void
.end method

.method public b(Ljava/lang/CharSequence;)V
    .locals 1
    .param p1, "subtitle"    # Ljava/lang/CharSequence;

    .line 273
    iput-object p1, p0, Landroid/support/v7/widget/Aa;->j:Ljava/lang/CharSequence;

    .line 274
    iget v0, p0, Landroid/support/v7/widget/Aa;->b:I

    and-int/lit8 v0, v0, 0x8

    if-eqz v0, :cond_0

    .line 275
    iget-object v0, p0, Landroid/support/v7/widget/Aa;->a:Landroid/support/v7/widget/Toolbar;

    invoke-virtual {v0, p1}, Landroid/support/v7/widget/Toolbar;->setSubtitle(Ljava/lang/CharSequence;)V

    .line 277
    :cond_0
    return-void
.end method

.method public b(Z)V
    .locals 1
    .param p1, "collapsible"    # Z

    .line 448
    iget-object v0, p0, Landroid/support/v7/widget/Aa;->a:Landroid/support/v7/widget/Toolbar;

    invoke-virtual {v0, p1}, Landroid/support/v7/widget/Toolbar;->setCollapsible(Z)V

    .line 449
    return-void
.end method

.method public c(I)V
    .locals 1
    .param p1, "visible"    # I

    .line 661
    iget-object v0, p0, Landroid/support/v7/widget/Aa;->a:Landroid/support/v7/widget/Toolbar;

    invoke-virtual {v0, p1}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 662
    return-void
.end method

.method public c(Ljava/lang/CharSequence;)V
    .locals 1
    .param p1, "title"    # Ljava/lang/CharSequence;

    .line 255
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v7/widget/Aa;->h:Z

    .line 256
    invoke-direct {p0, p1}, Landroid/support/v7/widget/Aa;->d(Ljava/lang/CharSequence;)V

    .line 257
    return-void
.end method

.method public c()Z
    .locals 1

    .line 335
    iget-object v0, p0, Landroid/support/v7/widget/Aa;->a:Landroid/support/v7/widget/Toolbar;

    invoke-virtual {v0}, Landroid/support/v7/widget/Toolbar;->b()Z

    move-result v0

    return v0
.end method

.method public collapseActionView()V
    .locals 1

    .line 232
    iget-object v0, p0, Landroid/support/v7/widget/Aa;->a:Landroid/support/v7/widget/Toolbar;

    invoke-virtual {v0}, Landroid/support/v7/widget/Toolbar;->c()V

    .line 233
    return-void
.end method

.method public d(I)V
    .locals 1
    .param p1, "defaultNavigationContentDescription"    # I

    .line 196
    iget v0, p0, Landroid/support/v7/widget/Aa;->p:I

    if-ne p1, v0, :cond_0

    .line 197
    return-void

    .line 199
    :cond_0
    iput p1, p0, Landroid/support/v7/widget/Aa;->p:I

    .line 200
    iget-object v0, p0, Landroid/support/v7/widget/Aa;->a:Landroid/support/v7/widget/Toolbar;

    invoke-virtual {v0}, Landroid/support/v7/widget/Toolbar;->getNavigationContentDescription()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 201
    iget v0, p0, Landroid/support/v7/widget/Aa;->p:I

    invoke-virtual {p0, v0}, Landroid/support/v7/widget/Aa;->e(I)V

    .line 203
    :cond_1
    return-void
.end method

.method public d()Z
    .locals 1

    .line 345
    iget-object v0, p0, Landroid/support/v7/widget/Aa;->a:Landroid/support/v7/widget/Toolbar;

    invoke-virtual {v0}, Landroid/support/v7/widget/Toolbar;->h()Z

    move-result v0

    return v0
.end method

.method public e(I)V
    .locals 1
    .param p1, "resId"    # I

    .line 626
    if-nez p1, :cond_0

    const/4 v0, 0x0

    goto :goto_0

    :cond_0
    invoke-virtual {p0}, Landroid/support/v7/widget/Aa;->k()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    :goto_0
    invoke-virtual {p0, v0}, Landroid/support/v7/widget/Aa;->a(Ljava/lang/CharSequence;)V

    .line 627
    return-void
.end method

.method public e()Z
    .locals 1

    .line 355
    iget-object v0, p0, Landroid/support/v7/widget/Aa;->a:Landroid/support/v7/widget/Toolbar;

    invoke-virtual {v0}, Landroid/support/v7/widget/Toolbar;->g()Z

    move-result v0

    return v0
.end method

.method public f()Z
    .locals 1

    .line 350
    iget-object v0, p0, Landroid/support/v7/widget/Aa;->a:Landroid/support/v7/widget/Toolbar;

    invoke-virtual {v0}, Landroid/support/v7/widget/Toolbar;->k()Z

    move-result v0

    return v0
.end method

.method public g()V
    .locals 1

    .line 375
    iget-object v0, p0, Landroid/support/v7/widget/Aa;->a:Landroid/support/v7/widget/Toolbar;

    invoke-virtual {v0}, Landroid/support/v7/widget/Toolbar;->d()V

    .line 376
    return-void
.end method

.method public getTitle()Ljava/lang/CharSequence;
    .locals 1

    .line 250
    iget-object v0, p0, Landroid/support/v7/widget/Aa;->a:Landroid/support/v7/widget/Toolbar;

    invoke-virtual {v0}, Landroid/support/v7/widget/Toolbar;->getTitle()Ljava/lang/CharSequence;

    move-result-object v0

    return-object v0
.end method

.method public h()Z
    .locals 1

    .line 227
    iget-object v0, p0, Landroid/support/v7/widget/Aa;->a:Landroid/support/v7/widget/Toolbar;

    invoke-virtual {v0}, Landroid/support/v7/widget/Toolbar;->f()Z

    move-result v0

    return v0
.end method

.method public i()I
    .locals 1

    .line 458
    iget v0, p0, Landroid/support/v7/widget/Aa;->o:I

    return v0
.end method

.method public j()Landroid/view/ViewGroup;
    .locals 1

    .line 217
    iget-object v0, p0, Landroid/support/v7/widget/Aa;->a:Landroid/support/v7/widget/Toolbar;

    return-object v0
.end method

.method public k()Landroid/content/Context;
    .locals 1

    .line 222
    iget-object v0, p0, Landroid/support/v7/widget/Aa;->a:Landroid/support/v7/widget/Toolbar;

    invoke-virtual {v0}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v0

    return-object v0
.end method

.method public l()I
    .locals 1

    .line 380
    iget v0, p0, Landroid/support/v7/widget/Aa;->b:I

    return v0
.end method

.method public m()V
    .locals 2

    .line 281
    const-string v0, "ToolbarWidgetWrapper"

    const-string v1, "Progress display unsupported"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 282
    return-void
.end method

.method public n()V
    .locals 2

    .line 286
    const-string v0, "ToolbarWidgetWrapper"

    const-string v1, "Progress display unsupported"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 287
    return-void
.end method

.method public setIcon(I)V
    .locals 1
    .param p1, "resId"    # I

    .line 301
    if-eqz p1, :cond_0

    invoke-virtual {p0}, Landroid/support/v7/widget/Aa;->k()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0, p1}, La/b/d/b/a/a;->b(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    invoke-virtual {p0, v0}, Landroid/support/v7/widget/Aa;->setIcon(Landroid/graphics/drawable/Drawable;)V

    .line 302
    return-void
.end method

.method public setIcon(Landroid/graphics/drawable/Drawable;)V
    .locals 0
    .param p1, "d"    # Landroid/graphics/drawable/Drawable;

    .line 306
    iput-object p1, p0, Landroid/support/v7/widget/Aa;->e:Landroid/graphics/drawable/Drawable;

    .line 307
    invoke-direct {p0}, Landroid/support/v7/widget/Aa;->r()V

    .line 308
    return-void
.end method

.method public setWindowCallback(Landroid/view/Window$Callback;)V
    .locals 0
    .param p1, "cb"    # Landroid/view/Window$Callback;

    .line 237
    iput-object p1, p0, Landroid/support/v7/widget/Aa;->l:Landroid/view/Window$Callback;

    .line 238
    return-void
.end method

.method public setWindowTitle(Ljava/lang/CharSequence;)V
    .locals 1
    .param p1, "title"    # Ljava/lang/CharSequence;

    .line 243
    iget-boolean v0, p0, Landroid/support/v7/widget/Aa;->h:Z

    if-nez v0, :cond_0

    .line 244
    invoke-direct {p0, p1}, Landroid/support/v7/widget/Aa;->d(Ljava/lang/CharSequence;)V

    .line 246
    :cond_0
    return-void
.end method
