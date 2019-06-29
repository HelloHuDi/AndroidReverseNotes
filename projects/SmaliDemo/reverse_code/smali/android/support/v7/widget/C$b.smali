.class Landroid/support/v7/widget/C$b;
.super Landroid/support/v7/widget/U;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v7/widget/C;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "b"
.end annotation


# instance fields
.field private K:Ljava/lang/CharSequence;

.field L:Landroid/widget/ListAdapter;

.field private final M:Landroid/graphics/Rect;

.field final synthetic N:Landroid/support/v7/widget/C;


# direct methods
.method public constructor <init>(Landroid/support/v7/widget/C;Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 1
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "attrs"    # Landroid/util/AttributeSet;
    .param p4, "defStyleAttr"    # I

    .line 722
    iput-object p1, p0, Landroid/support/v7/widget/C$b;->N:Landroid/support/v7/widget/C;

    .line 723
    invoke-direct {p0, p2, p3, p4}, Landroid/support/v7/widget/U;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 720
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Landroid/support/v7/widget/C$b;->M:Landroid/graphics/Rect;

    .line 725
    invoke-virtual {p0, p1}, Landroid/support/v7/widget/U;->a(Landroid/view/View;)V

    .line 726
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Landroid/support/v7/widget/U;->a(Z)V

    .line 727
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Landroid/support/v7/widget/U;->f(I)V

    .line 729
    new-instance v0, Landroid/support/v7/widget/D;

    invoke-direct {v0, p0, p1}, Landroid/support/v7/widget/D;-><init>(Landroid/support/v7/widget/C$b;Landroid/support/v7/widget/C;)V

    invoke-virtual {p0, v0}, Landroid/support/v7/widget/U;->a(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 740
    return-void
.end method

.method static synthetic a(Landroid/support/v7/widget/C$b;)V
    .locals 0
    .param p0, "x0"    # Landroid/support/v7/widget/C$b;

    .line 717
    invoke-super {p0}, Landroid/support/v7/widget/U;->c()V

    return-void
.end method


# virtual methods
.method public a(Landroid/widget/ListAdapter;)V
    .locals 0
    .param p1, "adapter"    # Landroid/widget/ListAdapter;

    .line 744
    invoke-super {p0, p1}, Landroid/support/v7/widget/U;->a(Landroid/widget/ListAdapter;)V

    .line 745
    iput-object p1, p0, Landroid/support/v7/widget/C$b;->L:Landroid/widget/ListAdapter;

    .line 746
    return-void
.end method

.method public a(Ljava/lang/CharSequence;)V
    .locals 0
    .param p1, "hintText"    # Ljava/lang/CharSequence;

    .line 754
    iput-object p1, p0, Landroid/support/v7/widget/C$b;->K:Ljava/lang/CharSequence;

    .line 755
    return-void
.end method

.method b(Landroid/view/View;)Z
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .line 849
    invoke-static {p1}, La/b/c/g/u;->j(Landroid/view/View;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/v7/widget/C$b;->M:Landroid/graphics/Rect;

    invoke-virtual {p1, v0}, Landroid/view/View;->getGlobalVisibleRect(Landroid/graphics/Rect;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public c()V
    .locals 5

    .line 796
    invoke-virtual {p0}, Landroid/support/v7/widget/U;->b()Z

    move-result v0

    .line 798
    .local v0, "wasShowing":Z
    invoke-virtual {p0}, Landroid/support/v7/widget/C$b;->l()V

    .line 800
    const/4 v1, 0x2

    invoke-virtual {p0, v1}, Landroid/support/v7/widget/U;->e(I)V

    .line 801
    invoke-super {p0}, Landroid/support/v7/widget/U;->c()V

    .line 802
    invoke-virtual {p0}, Landroid/support/v7/widget/U;->d()Landroid/widget/ListView;

    move-result-object v1

    .line 803
    .local v1, "listView":Landroid/widget/ListView;
    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Landroid/widget/ListView;->setChoiceMode(I)V

    .line 804
    iget-object v2, p0, Landroid/support/v7/widget/C$b;->N:Landroid/support/v7/widget/C;

    invoke-virtual {v2}, Landroid/widget/Spinner;->getSelectedItemPosition()I

    move-result v2

    invoke-virtual {p0, v2}, Landroid/support/v7/widget/U;->g(I)V

    .line 806
    if-eqz v0, :cond_0

    .line 809
    return-void

    .line 815
    :cond_0
    iget-object v2, p0, Landroid/support/v7/widget/C$b;->N:Landroid/support/v7/widget/C;

    invoke-virtual {v2}, Landroid/widget/Spinner;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v2

    .line 816
    .local v2, "vto":Landroid/view/ViewTreeObserver;
    if-eqz v2, :cond_1

    .line 817
    new-instance v3, Landroid/support/v7/widget/E;

    invoke-direct {v3, p0}, Landroid/support/v7/widget/E;-><init>(Landroid/support/v7/widget/C$b;)V

    .line 832
    .local v3, "layoutListener":Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;
    invoke-virtual {v2, v3}, Landroid/view/ViewTreeObserver;->addOnGlobalLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    .line 833
    new-instance v4, Landroid/support/v7/widget/F;

    invoke-direct {v4, p0, v3}, Landroid/support/v7/widget/F;-><init>(Landroid/support/v7/widget/C$b;Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    invoke-virtual {p0, v4}, Landroid/support/v7/widget/U;->a(Landroid/widget/PopupWindow$OnDismissListener;)V

    .line 843
    .end local v3    # "layoutListener":Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;
    :cond_1
    return-void
.end method

.method l()V
    .locals 9

    .line 758
    invoke-virtual {p0}, Landroid/support/v7/widget/U;->f()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 759
    .local v0, "background":Landroid/graphics/drawable/Drawable;
    const/4 v1, 0x0

    .line 760
    .local v1, "hOffset":I
    if-eqz v0, :cond_1

    .line 761
    iget-object v2, p0, Landroid/support/v7/widget/C$b;->N:Landroid/support/v7/widget/C;

    iget-object v2, v2, Landroid/support/v7/widget/C;->i:Landroid/graphics/Rect;

    invoke-virtual {v0, v2}, Landroid/graphics/drawable/Drawable;->getPadding(Landroid/graphics/Rect;)Z

    .line 762
    iget-object v2, p0, Landroid/support/v7/widget/C$b;->N:Landroid/support/v7/widget/C;

    invoke-static {v2}, Landroid/support/v7/widget/Ha;->a(Landroid/view/View;)Z

    move-result v2

    if-eqz v2, :cond_0

    iget-object v2, p0, Landroid/support/v7/widget/C$b;->N:Landroid/support/v7/widget/C;

    iget-object v2, v2, Landroid/support/v7/widget/C;->i:Landroid/graphics/Rect;

    iget v2, v2, Landroid/graphics/Rect;->right:I

    goto :goto_0

    :cond_0
    iget-object v2, p0, Landroid/support/v7/widget/C$b;->N:Landroid/support/v7/widget/C;

    iget-object v2, v2, Landroid/support/v7/widget/C;->i:Landroid/graphics/Rect;

    iget v2, v2, Landroid/graphics/Rect;->left:I

    neg-int v2, v2

    :goto_0
    move v1, v2

    goto :goto_1

    .line 765
    :cond_1
    iget-object v2, p0, Landroid/support/v7/widget/C$b;->N:Landroid/support/v7/widget/C;

    iget-object v2, v2, Landroid/support/v7/widget/C;->i:Landroid/graphics/Rect;

    const/4 v3, 0x0

    iput v3, v2, Landroid/graphics/Rect;->right:I

    iput v3, v2, Landroid/graphics/Rect;->left:I

    .line 768
    :goto_1
    iget-object v2, p0, Landroid/support/v7/widget/C$b;->N:Landroid/support/v7/widget/C;

    invoke-virtual {v2}, Landroid/widget/Spinner;->getPaddingLeft()I

    move-result v2

    .line 769
    .local v2, "spinnerPaddingLeft":I
    iget-object v3, p0, Landroid/support/v7/widget/C$b;->N:Landroid/support/v7/widget/C;

    invoke-virtual {v3}, Landroid/widget/Spinner;->getPaddingRight()I

    move-result v3

    .line 770
    .local v3, "spinnerPaddingRight":I
    iget-object v4, p0, Landroid/support/v7/widget/C$b;->N:Landroid/support/v7/widget/C;

    invoke-virtual {v4}, Landroid/widget/Spinner;->getWidth()I

    move-result v4

    .line 771
    .local v4, "spinnerWidth":I
    iget-object v5, p0, Landroid/support/v7/widget/C$b;->N:Landroid/support/v7/widget/C;

    iget v6, v5, Landroid/support/v7/widget/C;->h:I

    const/4 v7, -0x2

    if-ne v6, v7, :cond_3

    .line 772
    iget-object v6, p0, Landroid/support/v7/widget/C$b;->L:Landroid/widget/ListAdapter;

    check-cast v6, Landroid/widget/SpinnerAdapter;

    .line 773
    invoke-virtual {p0}, Landroid/support/v7/widget/U;->f()Landroid/graphics/drawable/Drawable;

    move-result-object v7

    .line 772
    invoke-virtual {v5, v6, v7}, Landroid/support/v7/widget/C;->a(Landroid/widget/SpinnerAdapter;Landroid/graphics/drawable/Drawable;)I

    move-result v5

    .line 774
    .local v5, "contentWidth":I
    iget-object v6, p0, Landroid/support/v7/widget/C$b;->N:Landroid/support/v7/widget/C;

    invoke-virtual {v6}, Landroid/widget/Spinner;->getContext()Landroid/content/Context;

    move-result-object v6

    invoke-virtual {v6}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    .line 775
    invoke-virtual {v6}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v6

    iget v6, v6, Landroid/util/DisplayMetrics;->widthPixels:I

    iget-object v7, p0, Landroid/support/v7/widget/C$b;->N:Landroid/support/v7/widget/C;

    iget-object v7, v7, Landroid/support/v7/widget/C;->i:Landroid/graphics/Rect;

    iget v8, v7, Landroid/graphics/Rect;->left:I

    sub-int/2addr v6, v8

    iget v7, v7, Landroid/graphics/Rect;->right:I

    sub-int/2addr v6, v7

    .line 776
    .local v6, "contentWidthLimit":I
    if-le v5, v6, :cond_2

    .line 777
    move v5, v6

    .line 779
    :cond_2
    sub-int v7, v4, v2

    sub-int/2addr v7, v3

    invoke-static {v5, v7}, Ljava/lang/Math;->max(II)I

    move-result v7

    invoke-virtual {p0, v7}, Landroid/support/v7/widget/U;->b(I)V

    .line 781
    .end local v5    # "contentWidth":I
    .end local v6    # "contentWidthLimit":I
    goto :goto_2

    :cond_3
    const/4 v5, -0x1

    if-ne v6, v5, :cond_4

    .line 782
    sub-int v5, v4, v2

    sub-int/2addr v5, v3

    invoke-virtual {p0, v5}, Landroid/support/v7/widget/U;->b(I)V

    goto :goto_2

    .line 784
    :cond_4
    invoke-virtual {p0, v6}, Landroid/support/v7/widget/U;->b(I)V

    .line 786
    :goto_2
    iget-object v5, p0, Landroid/support/v7/widget/C$b;->N:Landroid/support/v7/widget/C;

    invoke-static {v5}, Landroid/support/v7/widget/Ha;->a(Landroid/view/View;)Z

    move-result v5

    if-eqz v5, :cond_5

    .line 787
    sub-int v5, v4, v3

    invoke-virtual {p0}, Landroid/support/v7/widget/U;->i()I

    move-result v6

    sub-int/2addr v5, v6

    add-int/2addr v1, v5

    goto :goto_3

    .line 789
    :cond_5
    add-int/2addr v1, v2

    .line 791
    :goto_3
    invoke-virtual {p0, v1}, Landroid/support/v7/widget/U;->d(I)V

    .line 792
    return-void
.end method

.method public m()Ljava/lang/CharSequence;
    .locals 1

    .line 749
    iget-object v0, p0, Landroid/support/v7/widget/C$b;->K:Ljava/lang/CharSequence;

    return-object v0
.end method
