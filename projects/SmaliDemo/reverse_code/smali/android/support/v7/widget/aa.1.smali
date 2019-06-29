.class public Landroid/support/v7/widget/aa;
.super Landroid/widget/HorizontalScrollView;
.source ""

# interfaces
.implements Landroid/widget/AdapterView$OnItemSelectedListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/support/v7/widget/aa$b;,
        Landroid/support/v7/widget/aa$a;,
        Landroid/support/v7/widget/aa$c;
    }
.end annotation


# static fields
.field private static final a:Landroid/view/animation/Interpolator;


# instance fields
.field b:Ljava/lang/Runnable;

.field private c:Landroid/support/v7/widget/aa$b;

.field d:Landroid/support/v7/widget/Q;

.field private e:Landroid/widget/Spinner;

.field private f:Z

.field g:I

.field h:I

.field private i:I

.field private j:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 77
    new-instance v0, Landroid/view/animation/DecelerateInterpolator;

    invoke-direct {v0}, Landroid/view/animation/DecelerateInterpolator;-><init>()V

    sput-object v0, Landroid/support/v7/widget/aa;->a:Landroid/view/animation/Interpolator;

    return-void
.end method

.method private a()Landroid/widget/Spinner;
    .locals 4

    .line 214
    new-instance v0, Landroid/support/v7/widget/C;

    invoke-virtual {p0}, Landroid/widget/HorizontalScrollView;->getContext()Landroid/content/Context;

    move-result-object v1

    sget v2, La/b/d/a/a;->actionDropDownStyle:I

    const/4 v3, 0x0

    invoke-direct {v0, v1, v3, v2}, Landroid/support/v7/widget/C;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 216
    .local v0, "spinner":Landroid/widget/Spinner;
    new-instance v1, Landroid/support/v7/widget/Q$a;

    const/4 v2, -0x2

    const/4 v3, -0x1

    invoke-direct {v1, v2, v3}, Landroid/support/v7/widget/Q$a;-><init>(II)V

    invoke-virtual {v0, v1}, Landroid/widget/Spinner;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 219
    invoke-virtual {v0, p0}, Landroid/widget/Spinner;->setOnItemSelectedListener(Landroid/widget/AdapterView$OnItemSelectedListener;)V

    .line 220
    return-object v0
.end method

.method private b()Z
    .locals 1

    .line 146
    iget-object v0, p0, Landroid/support/v7/widget/aa;->e:Landroid/widget/Spinner;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/widget/Spinner;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    if-ne v0, p0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method private c()V
    .locals 4

    .line 154
    invoke-direct {p0}, Landroid/support/v7/widget/aa;->b()Z

    move-result v0

    if-eqz v0, :cond_0

    return-void

    .line 156
    :cond_0
    iget-object v0, p0, Landroid/support/v7/widget/aa;->e:Landroid/widget/Spinner;

    if-nez v0, :cond_1

    .line 157
    invoke-direct {p0}, Landroid/support/v7/widget/aa;->a()Landroid/widget/Spinner;

    move-result-object v0

    iput-object v0, p0, Landroid/support/v7/widget/aa;->e:Landroid/widget/Spinner;

    .line 159
    :cond_1
    iget-object v0, p0, Landroid/support/v7/widget/aa;->d:Landroid/support/v7/widget/Q;

    invoke-virtual {p0, v0}, Landroid/widget/HorizontalScrollView;->removeView(Landroid/view/View;)V

    .line 160
    iget-object v0, p0, Landroid/support/v7/widget/aa;->e:Landroid/widget/Spinner;

    new-instance v1, Landroid/view/ViewGroup$LayoutParams;

    const/4 v2, -0x2

    const/4 v3, -0x1

    invoke-direct {v1, v2, v3}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    invoke-virtual {p0, v0, v1}, Landroid/widget/HorizontalScrollView;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 162
    iget-object v0, p0, Landroid/support/v7/widget/aa;->e:Landroid/widget/Spinner;

    invoke-virtual {v0}, Landroid/widget/Spinner;->getAdapter()Landroid/widget/SpinnerAdapter;

    move-result-object v0

    if-nez v0, :cond_2

    .line 163
    iget-object v0, p0, Landroid/support/v7/widget/aa;->e:Landroid/widget/Spinner;

    new-instance v1, Landroid/support/v7/widget/aa$a;

    invoke-direct {v1, p0}, Landroid/support/v7/widget/aa$a;-><init>(Landroid/support/v7/widget/aa;)V

    invoke-virtual {v0, v1}, Landroid/widget/Spinner;->setAdapter(Landroid/widget/SpinnerAdapter;)V

    .line 165
    :cond_2
    iget-object v0, p0, Landroid/support/v7/widget/aa;->b:Ljava/lang/Runnable;

    if-eqz v0, :cond_3

    .line 166
    invoke-virtual {p0, v0}, Landroid/widget/HorizontalScrollView;->removeCallbacks(Ljava/lang/Runnable;)Z

    .line 167
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/support/v7/widget/aa;->b:Ljava/lang/Runnable;

    .line 169
    :cond_3
    iget-object v0, p0, Landroid/support/v7/widget/aa;->e:Landroid/widget/Spinner;

    iget v1, p0, Landroid/support/v7/widget/aa;->j:I

    invoke-virtual {v0, v1}, Landroid/widget/Spinner;->setSelection(I)V

    .line 170
    return-void
.end method

.method private d()Z
    .locals 5

    .line 173
    invoke-direct {p0}, Landroid/support/v7/widget/aa;->b()Z

    move-result v0

    const/4 v1, 0x0

    if-nez v0, :cond_0

    return v1

    .line 175
    :cond_0
    iget-object v0, p0, Landroid/support/v7/widget/aa;->e:Landroid/widget/Spinner;

    invoke-virtual {p0, v0}, Landroid/widget/HorizontalScrollView;->removeView(Landroid/view/View;)V

    .line 176
    iget-object v0, p0, Landroid/support/v7/widget/aa;->d:Landroid/support/v7/widget/Q;

    new-instance v2, Landroid/view/ViewGroup$LayoutParams;

    const/4 v3, -0x2

    const/4 v4, -0x1

    invoke-direct {v2, v3, v4}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    invoke-virtual {p0, v0, v2}, Landroid/widget/HorizontalScrollView;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 178
    iget-object v0, p0, Landroid/support/v7/widget/aa;->e:Landroid/widget/Spinner;

    invoke-virtual {v0}, Landroid/widget/Spinner;->getSelectedItemPosition()I

    move-result v0

    invoke-virtual {p0, v0}, Landroid/support/v7/widget/aa;->setTabSelected(I)V

    .line 179
    return v1
.end method


# virtual methods
.method a(Landroid/support/v7/app/a$c;Z)Landroid/support/v7/widget/aa$c;
    .locals 4
    .param p1, "tab"    # Landroid/support/v7/app/a$c;
    .param p2, "forAdapter"    # Z

    .line 293
    new-instance v0, Landroid/support/v7/widget/aa$c;

    invoke-virtual {p0}, Landroid/widget/HorizontalScrollView;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, p0, v1, p1, p2}, Landroid/support/v7/widget/aa$c;-><init>(Landroid/support/v7/widget/aa;Landroid/content/Context;Landroid/support/v7/app/a$c;Z)V

    .line 294
    .local v0, "tabView":Landroid/support/v7/widget/aa$c;
    if-eqz p2, :cond_0

    .line 295
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 296
    new-instance v1, Landroid/widget/AbsListView$LayoutParams;

    const/4 v2, -0x1

    iget v3, p0, Landroid/support/v7/widget/aa;->i:I

    invoke-direct {v1, v2, v3}, Landroid/widget/AbsListView$LayoutParams;-><init>(II)V

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    goto :goto_0

    .line 299
    :cond_0
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setFocusable(Z)V

    .line 301
    iget-object v1, p0, Landroid/support/v7/widget/aa;->c:Landroid/support/v7/widget/aa$b;

    if-nez v1, :cond_1

    .line 302
    new-instance v1, Landroid/support/v7/widget/aa$b;

    invoke-direct {v1, p0}, Landroid/support/v7/widget/aa$b;-><init>(Landroid/support/v7/widget/aa;)V

    iput-object v1, p0, Landroid/support/v7/widget/aa;->c:Landroid/support/v7/widget/aa$b;

    .line 304
    :cond_1
    iget-object v1, p0, Landroid/support/v7/widget/aa;->c:Landroid/support/v7/widget/aa$b;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 306
    :goto_0
    return-object v0
.end method

.method public a(I)V
    .locals 2
    .param p1, "position"    # I

    .line 260
    iget-object v0, p0, Landroid/support/v7/widget/aa;->d:Landroid/support/v7/widget/Q;

    invoke-virtual {v0, p1}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 261
    .local v0, "tabView":Landroid/view/View;
    iget-object v1, p0, Landroid/support/v7/widget/aa;->b:Ljava/lang/Runnable;

    if-eqz v1, :cond_0

    .line 262
    invoke-virtual {p0, v1}, Landroid/widget/HorizontalScrollView;->removeCallbacks(Ljava/lang/Runnable;)Z

    .line 264
    :cond_0
    new-instance v1, Landroid/support/v7/widget/Z;

    invoke-direct {v1, p0, v0}, Landroid/support/v7/widget/Z;-><init>(Landroid/support/v7/widget/aa;Landroid/view/View;)V

    iput-object v1, p0, Landroid/support/v7/widget/aa;->b:Ljava/lang/Runnable;

    .line 272
    iget-object v1, p0, Landroid/support/v7/widget/aa;->b:Ljava/lang/Runnable;

    invoke-virtual {p0, v1}, Landroid/widget/HorizontalScrollView;->post(Ljava/lang/Runnable;)Z

    .line 273
    return-void
.end method

.method public onAttachedToWindow()V
    .locals 1

    .line 277
    invoke-super {p0}, Landroid/widget/HorizontalScrollView;->onAttachedToWindow()V

    .line 278
    iget-object v0, p0, Landroid/support/v7/widget/aa;->b:Ljava/lang/Runnable;

    if-eqz v0, :cond_0

    .line 280
    invoke-virtual {p0, v0}, Landroid/widget/HorizontalScrollView;->post(Ljava/lang/Runnable;)Z

    .line 282
    :cond_0
    return-void
.end method

.method protected onConfigurationChanged(Landroid/content/res/Configuration;)V
    .locals 2
    .param p1, "newConfig"    # Landroid/content/res/Configuration;

    .line 225
    invoke-super {p0, p1}, Landroid/widget/HorizontalScrollView;->onConfigurationChanged(Landroid/content/res/Configuration;)V

    .line 227
    invoke-virtual {p0}, Landroid/widget/HorizontalScrollView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, La/b/d/d/a;->a(Landroid/content/Context;)La/b/d/d/a;

    move-result-object v0

    .line 230
    .local v0, "abp":La/b/d/d/a;
    invoke-virtual {v0}, La/b/d/d/a;->e()I

    move-result v1

    invoke-virtual {p0, v1}, Landroid/support/v7/widget/aa;->setContentHeight(I)V

    .line 231
    invoke-virtual {v0}, La/b/d/d/a;->d()I

    move-result v1

    iput v1, p0, Landroid/support/v7/widget/aa;->h:I

    .line 232
    return-void
.end method

.method public onDetachedFromWindow()V
    .locals 1

    .line 286
    invoke-super {p0}, Landroid/widget/HorizontalScrollView;->onDetachedFromWindow()V

    .line 287
    iget-object v0, p0, Landroid/support/v7/widget/aa;->b:Ljava/lang/Runnable;

    if-eqz v0, :cond_0

    .line 288
    invoke-virtual {p0, v0}, Landroid/widget/HorizontalScrollView;->removeCallbacks(Ljava/lang/Runnable;)Z

    .line 290
    :cond_0
    return-void
.end method

.method public onItemSelected(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 2
    .param p2, "view"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView<",
            "*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .line 371
    .local p1, "adapterView":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    move-object v0, p2

    check-cast v0, Landroid/support/v7/widget/aa$c;

    .line 372
    .local v0, "tabView":Landroid/support/v7/widget/aa$c;
    invoke-virtual {v0}, Landroid/support/v7/widget/aa$c;->a()Landroid/support/v7/app/a$c;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v7/app/a$c;->e()V

    .line 373
    return-void
.end method

.method public onMeasure(II)V
    .locals 8
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .line 97
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v0

    .line 98
    .local v0, "widthMode":I
    const/4 v1, 0x1

    const/4 v2, 0x0

    const/high16 v3, 0x40000000    # 2.0f

    if-ne v0, v3, :cond_0

    const/4 v4, 0x1

    goto :goto_0

    :cond_0
    const/4 v4, 0x0

    .line 99
    .local v4, "lockedExpanded":Z
    :goto_0
    invoke-virtual {p0, v4}, Landroid/widget/HorizontalScrollView;->setFillViewport(Z)V

    .line 101
    iget-object v5, p0, Landroid/support/v7/widget/aa;->d:Landroid/support/v7/widget/Q;

    invoke-virtual {v5}, Landroid/view/ViewGroup;->getChildCount()I

    move-result v5

    .line 102
    .local v5, "childCount":I
    if-le v5, v1, :cond_3

    if-eq v0, v3, :cond_1

    const/high16 v6, -0x80000000

    if-ne v0, v6, :cond_3

    .line 104
    :cond_1
    const/4 v6, 0x2

    if-le v5, v6, :cond_2

    .line 105
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v6

    int-to-float v6, v6

    const v7, 0x3ecccccd    # 0.4f

    mul-float v6, v6, v7

    float-to-int v6, v6

    iput v6, p0, Landroid/support/v7/widget/aa;->g:I

    goto :goto_1

    .line 107
    :cond_2
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v7

    div-int/2addr v7, v6

    iput v7, p0, Landroid/support/v7/widget/aa;->g:I

    .line 109
    :goto_1
    iget v6, p0, Landroid/support/v7/widget/aa;->g:I

    iget v7, p0, Landroid/support/v7/widget/aa;->h:I

    invoke-static {v6, v7}, Ljava/lang/Math;->min(II)I

    move-result v6

    iput v6, p0, Landroid/support/v7/widget/aa;->g:I

    goto :goto_2

    .line 111
    :cond_3
    const/4 v6, -0x1

    iput v6, p0, Landroid/support/v7/widget/aa;->g:I

    .line 114
    :goto_2
    iget v6, p0, Landroid/support/v7/widget/aa;->i:I

    invoke-static {v6, v3}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result p2

    .line 116
    if-nez v4, :cond_4

    iget-boolean v3, p0, Landroid/support/v7/widget/aa;->f:Z

    if-eqz v3, :cond_4

    goto :goto_3

    :cond_4
    const/4 v1, 0x0

    .line 118
    .local v1, "canCollapse":Z
    :goto_3
    if-eqz v1, :cond_6

    .line 120
    iget-object v3, p0, Landroid/support/v7/widget/aa;->d:Landroid/support/v7/widget/Q;

    invoke-virtual {v3, v2, p2}, Landroid/view/ViewGroup;->measure(II)V

    .line 121
    iget-object v2, p0, Landroid/support/v7/widget/aa;->d:Landroid/support/v7/widget/Q;

    invoke-virtual {v2}, Landroid/view/ViewGroup;->getMeasuredWidth()I

    move-result v2

    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v3

    if-le v2, v3, :cond_5

    .line 122
    invoke-direct {p0}, Landroid/support/v7/widget/aa;->c()V

    goto :goto_4

    .line 124
    :cond_5
    invoke-direct {p0}, Landroid/support/v7/widget/aa;->d()Z

    goto :goto_4

    .line 127
    :cond_6
    invoke-direct {p0}, Landroid/support/v7/widget/aa;->d()Z

    .line 130
    :goto_4
    invoke-virtual {p0}, Landroid/widget/HorizontalScrollView;->getMeasuredWidth()I

    move-result v2

    .line 131
    .local v2, "oldWidth":I
    invoke-super {p0, p1, p2}, Landroid/widget/HorizontalScrollView;->onMeasure(II)V

    .line 132
    invoke-virtual {p0}, Landroid/widget/HorizontalScrollView;->getMeasuredWidth()I

    move-result v3

    .line 134
    .local v3, "newWidth":I
    if-eqz v4, :cond_7

    if-eq v2, v3, :cond_7

    .line 136
    iget v6, p0, Landroid/support/v7/widget/aa;->j:I

    invoke-virtual {p0, v6}, Landroid/support/v7/widget/aa;->setTabSelected(I)V

    .line 138
    :cond_7
    return-void
.end method

.method public onNothingSelected(Landroid/widget/AdapterView;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView<",
            "*>;)V"
        }
    .end annotation

    .line 378
    .local p1, "adapterView":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    return-void
.end method

.method public setAllowCollapse(Z)V
    .locals 0
    .param p1, "allowCollapse"    # Z

    .line 150
    iput-boolean p1, p0, Landroid/support/v7/widget/aa;->f:Z

    .line 151
    return-void
.end method

.method public setContentHeight(I)V
    .locals 0
    .param p1, "contentHeight"    # I

    .line 199
    iput p1, p0, Landroid/support/v7/widget/aa;->i:I

    .line 200
    invoke-virtual {p0}, Landroid/widget/HorizontalScrollView;->requestLayout()V

    .line 201
    return-void
.end method

.method public setTabSelected(I)V
    .locals 4
    .param p1, "position"    # I

    .line 183
    iput p1, p0, Landroid/support/v7/widget/aa;->j:I

    .line 184
    iget-object v0, p0, Landroid/support/v7/widget/aa;->d:Landroid/support/v7/widget/Q;

    invoke-virtual {v0}, Landroid/view/ViewGroup;->getChildCount()I

    move-result v0

    .line 185
    .local v0, "tabCount":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v0, :cond_2

    .line 186
    iget-object v2, p0, Landroid/support/v7/widget/aa;->d:Landroid/support/v7/widget/Q;

    invoke-virtual {v2, v1}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    .line 187
    .local v2, "child":Landroid/view/View;
    if-ne v1, p1, :cond_0

    const/4 v3, 0x1

    goto :goto_1

    :cond_0
    const/4 v3, 0x0

    .line 188
    .local v3, "isSelected":Z
    :goto_1
    invoke-virtual {v2, v3}, Landroid/view/View;->setSelected(Z)V

    .line 189
    if-eqz v3, :cond_1

    .line 190
    invoke-virtual {p0, p1}, Landroid/support/v7/widget/aa;->a(I)V

    .line 185
    .end local v2    # "child":Landroid/view/View;
    .end local v3    # "isSelected":Z
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 193
    .end local v1    # "i":I
    :cond_2
    iget-object v1, p0, Landroid/support/v7/widget/aa;->e:Landroid/widget/Spinner;

    if-eqz v1, :cond_3

    if-ltz p1, :cond_3

    .line 194
    invoke-virtual {v1, p1}, Landroid/widget/Spinner;->setSelection(I)V

    .line 196
    :cond_3
    return-void
.end method
