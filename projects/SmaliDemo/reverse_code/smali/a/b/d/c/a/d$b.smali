.class abstract La/b/d/c/a/d$b;
.super Landroid/graphics/drawable/Drawable$ConstantState;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = La/b/d/c/a/d;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x408
    name = "b"
.end annotation


# instance fields
.field A:I

.field B:I

.field C:Z

.field D:Landroid/graphics/ColorFilter;

.field E:Z

.field F:Landroid/content/res/ColorStateList;

.field G:Landroid/graphics/PorterDuff$Mode;

.field H:Z

.field I:Z

.field final a:La/b/d/c/a/d;

.field b:Landroid/content/res/Resources;

.field c:I

.field d:I

.field e:I

.field f:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray<",
            "Landroid/graphics/drawable/Drawable$ConstantState;",
            ">;"
        }
    .end annotation
.end field

.field g:[Landroid/graphics/drawable/Drawable;

.field h:I

.field i:Z

.field j:Z

.field k:Landroid/graphics/Rect;

.field l:Z

.field m:Z

.field n:I

.field o:I

.field p:I

.field q:I

.field r:Z

.field s:I

.field t:Z

.field u:Z

.field v:Z

.field w:Z

.field x:Z

.field y:Z

.field z:I


# direct methods
.method constructor <init>(La/b/d/c/a/d$b;La/b/d/c/a/d;Landroid/content/res/Resources;)V
    .locals 7
    .param p1, "orig"    # La/b/d/c/a/d$b;
    .param p2, "owner"    # La/b/d/c/a/d;
    .param p3, "res"    # Landroid/content/res/Resources;

    .line 687
    invoke-direct {p0}, Landroid/graphics/drawable/Drawable$ConstantState;-><init>()V

    .line 652
    const/16 v0, 0xa0

    iput v0, p0, La/b/d/c/a/d$b;->c:I

    .line 658
    const/4 v0, 0x0

    iput-boolean v0, p0, La/b/d/c/a/d$b;->i:Z

    .line 661
    iput-boolean v0, p0, La/b/d/c/a/d$b;->l:Z

    .line 673
    const/4 v1, 0x1

    iput-boolean v1, p0, La/b/d/c/a/d$b;->x:Z

    .line 676
    iput v0, p0, La/b/d/c/a/d$b;->A:I

    .line 677
    iput v0, p0, La/b/d/c/a/d$b;->B:I

    .line 688
    iput-object p2, p0, La/b/d/c/a/d$b;->a:La/b/d/c/a/d;

    .line 689
    if-eqz p3, :cond_0

    move-object v2, p3

    goto :goto_0

    :cond_0
    if-eqz p1, :cond_1

    iget-object v2, p1, La/b/d/c/a/d$b;->b:Landroid/content/res/Resources;

    goto :goto_0

    :cond_1
    const/4 v2, 0x0

    :goto_0
    iput-object v2, p0, La/b/d/c/a/d$b;->b:Landroid/content/res/Resources;

    .line 690
    if-eqz p1, :cond_2

    iget v2, p1, La/b/d/c/a/d$b;->c:I

    goto :goto_1

    :cond_2
    const/4 v2, 0x0

    :goto_1
    invoke-static {p3, v2}, La/b/d/c/a/d;->a(Landroid/content/res/Resources;I)I

    move-result v2

    iput v2, p0, La/b/d/c/a/d$b;->c:I

    .line 691
    if-eqz p1, :cond_b

    .line 692
    iget v0, p1, La/b/d/c/a/d$b;->d:I

    iput v0, p0, La/b/d/c/a/d$b;->d:I

    .line 693
    iget v0, p1, La/b/d/c/a/d$b;->e:I

    iput v0, p0, La/b/d/c/a/d$b;->e:I

    .line 694
    iput-boolean v1, p0, La/b/d/c/a/d$b;->v:Z

    .line 695
    iput-boolean v1, p0, La/b/d/c/a/d$b;->w:Z

    .line 696
    iget-boolean v0, p1, La/b/d/c/a/d$b;->i:Z

    iput-boolean v0, p0, La/b/d/c/a/d$b;->i:Z

    .line 697
    iget-boolean v0, p1, La/b/d/c/a/d$b;->l:Z

    iput-boolean v0, p0, La/b/d/c/a/d$b;->l:Z

    .line 698
    iget-boolean v0, p1, La/b/d/c/a/d$b;->x:Z

    iput-boolean v0, p0, La/b/d/c/a/d$b;->x:Z

    .line 699
    iget-boolean v0, p1, La/b/d/c/a/d$b;->y:Z

    iput-boolean v0, p0, La/b/d/c/a/d$b;->y:Z

    .line 700
    iget v0, p1, La/b/d/c/a/d$b;->z:I

    iput v0, p0, La/b/d/c/a/d$b;->z:I

    .line 701
    iget v0, p1, La/b/d/c/a/d$b;->A:I

    iput v0, p0, La/b/d/c/a/d$b;->A:I

    .line 702
    iget v0, p1, La/b/d/c/a/d$b;->B:I

    iput v0, p0, La/b/d/c/a/d$b;->B:I

    .line 703
    iget-boolean v0, p1, La/b/d/c/a/d$b;->C:Z

    iput-boolean v0, p0, La/b/d/c/a/d$b;->C:Z

    .line 704
    iget-object v0, p1, La/b/d/c/a/d$b;->D:Landroid/graphics/ColorFilter;

    iput-object v0, p0, La/b/d/c/a/d$b;->D:Landroid/graphics/ColorFilter;

    .line 705
    iget-boolean v0, p1, La/b/d/c/a/d$b;->E:Z

    iput-boolean v0, p0, La/b/d/c/a/d$b;->E:Z

    .line 706
    iget-object v0, p1, La/b/d/c/a/d$b;->F:Landroid/content/res/ColorStateList;

    iput-object v0, p0, La/b/d/c/a/d$b;->F:Landroid/content/res/ColorStateList;

    .line 707
    iget-object v0, p1, La/b/d/c/a/d$b;->G:Landroid/graphics/PorterDuff$Mode;

    iput-object v0, p0, La/b/d/c/a/d$b;->G:Landroid/graphics/PorterDuff$Mode;

    .line 708
    iget-boolean v0, p1, La/b/d/c/a/d$b;->H:Z

    iput-boolean v0, p0, La/b/d/c/a/d$b;->H:Z

    .line 709
    iget-boolean v0, p1, La/b/d/c/a/d$b;->I:Z

    iput-boolean v0, p0, La/b/d/c/a/d$b;->I:Z

    .line 710
    iget v0, p1, La/b/d/c/a/d$b;->c:I

    iget v2, p0, La/b/d/c/a/d$b;->c:I

    if-ne v0, v2, :cond_4

    .line 711
    iget-boolean v0, p1, La/b/d/c/a/d$b;->j:Z

    if-eqz v0, :cond_3

    .line 712
    new-instance v0, Landroid/graphics/Rect;

    iget-object v2, p1, La/b/d/c/a/d$b;->k:Landroid/graphics/Rect;

    invoke-direct {v0, v2}, Landroid/graphics/Rect;-><init>(Landroid/graphics/Rect;)V

    iput-object v0, p0, La/b/d/c/a/d$b;->k:Landroid/graphics/Rect;

    .line 713
    iput-boolean v1, p0, La/b/d/c/a/d$b;->j:Z

    .line 715
    :cond_3
    iget-boolean v0, p1, La/b/d/c/a/d$b;->m:Z

    if-eqz v0, :cond_4

    .line 716
    iget v0, p1, La/b/d/c/a/d$b;->n:I

    iput v0, p0, La/b/d/c/a/d$b;->n:I

    .line 717
    iget v0, p1, La/b/d/c/a/d$b;->o:I

    iput v0, p0, La/b/d/c/a/d$b;->o:I

    .line 718
    iget v0, p1, La/b/d/c/a/d$b;->p:I

    iput v0, p0, La/b/d/c/a/d$b;->p:I

    .line 719
    iget v0, p1, La/b/d/c/a/d$b;->q:I

    iput v0, p0, La/b/d/c/a/d$b;->q:I

    .line 720
    iput-boolean v1, p0, La/b/d/c/a/d$b;->m:Z

    .line 723
    :cond_4
    iget-boolean v0, p1, La/b/d/c/a/d$b;->r:Z

    if-eqz v0, :cond_5

    .line 724
    iget v0, p1, La/b/d/c/a/d$b;->s:I

    iput v0, p0, La/b/d/c/a/d$b;->s:I

    .line 725
    iput-boolean v1, p0, La/b/d/c/a/d$b;->r:Z

    .line 727
    :cond_5
    iget-boolean v0, p1, La/b/d/c/a/d$b;->t:Z

    if-eqz v0, :cond_6

    .line 728
    iget-boolean v0, p1, La/b/d/c/a/d$b;->u:Z

    iput-boolean v0, p0, La/b/d/c/a/d$b;->u:Z

    .line 729
    iput-boolean v1, p0, La/b/d/c/a/d$b;->t:Z

    .line 733
    :cond_6
    iget-object v0, p1, La/b/d/c/a/d$b;->g:[Landroid/graphics/drawable/Drawable;

    .line 734
    .local v0, "origDr":[Landroid/graphics/drawable/Drawable;
    array-length v1, v0

    new-array v1, v1, [Landroid/graphics/drawable/Drawable;

    iput-object v1, p0, La/b/d/c/a/d$b;->g:[Landroid/graphics/drawable/Drawable;

    .line 735
    iget v1, p1, La/b/d/c/a/d$b;->h:I

    iput v1, p0, La/b/d/c/a/d$b;->h:I

    .line 736
    iget-object v1, p1, La/b/d/c/a/d$b;->f:Landroid/util/SparseArray;

    .line 737
    .local v1, "origDf":Landroid/util/SparseArray;, "Landroid/util/SparseArray<Landroid/graphics/drawable/Drawable$ConstantState;>;"
    if-eqz v1, :cond_7

    .line 738
    invoke-virtual {v1}, Landroid/util/SparseArray;->clone()Landroid/util/SparseArray;

    move-result-object v2

    iput-object v2, p0, La/b/d/c/a/d$b;->f:Landroid/util/SparseArray;

    goto :goto_2

    .line 740
    :cond_7
    new-instance v2, Landroid/util/SparseArray;

    iget v3, p0, La/b/d/c/a/d$b;->h:I

    invoke-direct {v2, v3}, Landroid/util/SparseArray;-><init>(I)V

    iput-object v2, p0, La/b/d/c/a/d$b;->f:Landroid/util/SparseArray;

    .line 745
    :goto_2
    iget v2, p0, La/b/d/c/a/d$b;->h:I

    .line 746
    .local v2, "count":I
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_3
    if-ge v3, v2, :cond_a

    .line 747
    aget-object v4, v0, v3

    if-eqz v4, :cond_9

    .line 748
    aget-object v4, v0, v3

    invoke-virtual {v4}, Landroid/graphics/drawable/Drawable;->getConstantState()Landroid/graphics/drawable/Drawable$ConstantState;

    move-result-object v4

    .line 749
    .local v4, "cs":Landroid/graphics/drawable/Drawable$ConstantState;
    if-eqz v4, :cond_8

    .line 750
    iget-object v5, p0, La/b/d/c/a/d$b;->f:Landroid/util/SparseArray;

    invoke-virtual {v5, v3, v4}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    goto :goto_4

    .line 752
    :cond_8
    iget-object v5, p0, La/b/d/c/a/d$b;->g:[Landroid/graphics/drawable/Drawable;

    aget-object v6, v0, v3

    aput-object v6, v5, v3

    .line 746
    .end local v4    # "cs":Landroid/graphics/drawable/Drawable$ConstantState;
    :cond_9
    :goto_4
    add-int/lit8 v3, v3, 0x1

    goto :goto_3

    .line 756
    .end local v0    # "origDr":[Landroid/graphics/drawable/Drawable;
    .end local v1    # "origDf":Landroid/util/SparseArray;, "Landroid/util/SparseArray<Landroid/graphics/drawable/Drawable$ConstantState;>;"
    .end local v2    # "count":I
    .end local v3    # "i":I
    :cond_a
    goto :goto_5

    .line 757
    :cond_b
    const/16 v1, 0xa

    new-array v1, v1, [Landroid/graphics/drawable/Drawable;

    iput-object v1, p0, La/b/d/c/a/d$b;->g:[Landroid/graphics/drawable/Drawable;

    .line 758
    iput v0, p0, La/b/d/c/a/d$b;->h:I

    .line 760
    :goto_5
    return-void
.end method

.method private b(Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;
    .locals 2
    .param p1, "child"    # Landroid/graphics/drawable/Drawable;

    .line 817
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x17

    if-lt v0, v1, :cond_0

    .line 818
    iget v0, p0, La/b/d/c/a/d$b;->z:I

    invoke-virtual {p1, v0}, Landroid/graphics/drawable/Drawable;->setLayoutDirection(I)Z

    .line 820
    :cond_0
    invoke-virtual {p1}, Landroid/graphics/drawable/Drawable;->mutate()Landroid/graphics/drawable/Drawable;

    move-result-object p1

    .line 821
    iget-object v0, p0, La/b/d/c/a/d$b;->a:La/b/d/c/a/d;

    invoke-virtual {p1, v0}, Landroid/graphics/drawable/Drawable;->setCallback(Landroid/graphics/drawable/Drawable$Callback;)V

    .line 822
    return-object p1
.end method

.method private n()V
    .locals 6

    .line 805
    iget-object v0, p0, La/b/d/c/a/d$b;->f:Landroid/util/SparseArray;

    if-eqz v0, :cond_1

    .line 806
    invoke-virtual {v0}, Landroid/util/SparseArray;->size()I

    move-result v0

    .line 807
    .local v0, "futureCount":I
    const/4 v1, 0x0

    .local v1, "keyIndex":I
    :goto_0
    if-ge v1, v0, :cond_0

    .line 808
    iget-object v2, p0, La/b/d/c/a/d$b;->f:Landroid/util/SparseArray;

    invoke-virtual {v2, v1}, Landroid/util/SparseArray;->keyAt(I)I

    move-result v2

    .line 809
    .local v2, "index":I
    iget-object v3, p0, La/b/d/c/a/d$b;->f:Landroid/util/SparseArray;

    invoke-virtual {v3, v1}, Landroid/util/SparseArray;->valueAt(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/graphics/drawable/Drawable$ConstantState;

    .line 810
    .local v3, "cs":Landroid/graphics/drawable/Drawable$ConstantState;
    iget-object v4, p0, La/b/d/c/a/d$b;->g:[Landroid/graphics/drawable/Drawable;

    iget-object v5, p0, La/b/d/c/a/d$b;->b:Landroid/content/res/Resources;

    invoke-virtual {v3, v5}, Landroid/graphics/drawable/Drawable$ConstantState;->newDrawable(Landroid/content/res/Resources;)Landroid/graphics/drawable/Drawable;

    move-result-object v5

    invoke-direct {p0, v5}, La/b/d/c/a/d$b;->b(Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;

    move-result-object v5

    aput-object v5, v4, v2

    .line 807
    .end local v2    # "index":I
    .end local v3    # "cs":Landroid/graphics/drawable/Drawable$ConstantState;
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 812
    .end local v1    # "keyIndex":I
    :cond_0
    const/4 v1, 0x0

    iput-object v1, p0, La/b/d/c/a/d$b;->f:Landroid/util/SparseArray;

    .line 814
    .end local v0    # "futureCount":I
    :cond_1
    return-void
.end method


# virtual methods
.method public final a(Landroid/graphics/drawable/Drawable;)I
    .locals 4
    .param p1, "dr"    # Landroid/graphics/drawable/Drawable;

    .line 774
    iget v0, p0, La/b/d/c/a/d$b;->h:I

    .line 775
    .local v0, "pos":I
    iget-object v1, p0, La/b/d/c/a/d$b;->g:[Landroid/graphics/drawable/Drawable;

    array-length v1, v1

    if-lt v0, v1, :cond_0

    .line 776
    add-int/lit8 v1, v0, 0xa

    invoke-virtual {p0, v0, v1}, La/b/d/c/a/d$b;->a(II)V

    .line 778
    :cond_0
    invoke-virtual {p1}, Landroid/graphics/drawable/Drawable;->mutate()Landroid/graphics/drawable/Drawable;

    .line 779
    const/4 v1, 0x1

    const/4 v2, 0x0

    invoke-virtual {p1, v2, v1}, Landroid/graphics/drawable/Drawable;->setVisible(ZZ)Z

    .line 780
    iget-object v3, p0, La/b/d/c/a/d$b;->a:La/b/d/c/a/d;

    invoke-virtual {p1, v3}, Landroid/graphics/drawable/Drawable;->setCallback(Landroid/graphics/drawable/Drawable$Callback;)V

    .line 781
    iget-object v3, p0, La/b/d/c/a/d$b;->g:[Landroid/graphics/drawable/Drawable;

    aput-object p1, v3, v0

    .line 782
    iget v3, p0, La/b/d/c/a/d$b;->h:I

    add-int/2addr v3, v1

    iput v3, p0, La/b/d/c/a/d$b;->h:I

    .line 783
    iget v1, p0, La/b/d/c/a/d$b;->e:I

    invoke-virtual {p1}, Landroid/graphics/drawable/Drawable;->getChangingConfigurations()I

    move-result v3

    or-int/2addr v1, v3

    iput v1, p0, La/b/d/c/a/d$b;->e:I

    .line 784
    invoke-virtual {p0}, La/b/d/c/a/d$b;->k()V

    .line 785
    const/4 v1, 0x0

    iput-object v1, p0, La/b/d/c/a/d$b;->k:Landroid/graphics/Rect;

    .line 786
    iput-boolean v2, p0, La/b/d/c/a/d$b;->j:Z

    .line 787
    iput-boolean v2, p0, La/b/d/c/a/d$b;->m:Z

    .line 788
    iput-boolean v2, p0, La/b/d/c/a/d$b;->v:Z

    .line 789
    return v0
.end method

.method public final a(I)Landroid/graphics/drawable/Drawable;
    .locals 6
    .param p1, "index"    # I

    .line 833
    iget-object v0, p0, La/b/d/c/a/d$b;->g:[Landroid/graphics/drawable/Drawable;

    aget-object v0, v0, p1

    .line 834
    .local v0, "result":Landroid/graphics/drawable/Drawable;
    if-eqz v0, :cond_0

    .line 835
    return-object v0

    .line 838
    :cond_0
    iget-object v1, p0, La/b/d/c/a/d$b;->f:Landroid/util/SparseArray;

    const/4 v2, 0x0

    if-eqz v1, :cond_2

    .line 839
    invoke-virtual {v1, p1}, Landroid/util/SparseArray;->indexOfKey(I)I

    move-result v1

    .line 840
    .local v1, "keyIndex":I
    if-ltz v1, :cond_2

    .line 841
    iget-object v3, p0, La/b/d/c/a/d$b;->f:Landroid/util/SparseArray;

    invoke-virtual {v3, v1}, Landroid/util/SparseArray;->valueAt(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/graphics/drawable/Drawable$ConstantState;

    .line 842
    .local v3, "cs":Landroid/graphics/drawable/Drawable$ConstantState;
    iget-object v4, p0, La/b/d/c/a/d$b;->b:Landroid/content/res/Resources;

    invoke-virtual {v3, v4}, Landroid/graphics/drawable/Drawable$ConstantState;->newDrawable(Landroid/content/res/Resources;)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-direct {p0, v4}, La/b/d/c/a/d$b;->b(Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    .line 843
    .local v4, "prepared":Landroid/graphics/drawable/Drawable;
    iget-object v5, p0, La/b/d/c/a/d$b;->g:[Landroid/graphics/drawable/Drawable;

    aput-object v4, v5, p1

    .line 844
    iget-object v5, p0, La/b/d/c/a/d$b;->f:Landroid/util/SparseArray;

    invoke-virtual {v5, v1}, Landroid/util/SparseArray;->removeAt(I)V

    .line 845
    iget-object v5, p0, La/b/d/c/a/d$b;->f:Landroid/util/SparseArray;

    invoke-virtual {v5}, Landroid/util/SparseArray;->size()I

    move-result v5

    if-nez v5, :cond_1

    .line 846
    iput-object v2, p0, La/b/d/c/a/d$b;->f:Landroid/util/SparseArray;

    .line 848
    :cond_1
    return-object v4

    .line 851
    .end local v1    # "keyIndex":I
    .end local v3    # "cs":Landroid/graphics/drawable/Drawable$ConstantState;
    .end local v4    # "prepared":Landroid/graphics/drawable/Drawable;
    :cond_2
    return-object v2
.end method

.method public a(II)V
    .locals 3
    .param p1, "oldSize"    # I
    .param p2, "newSize"    # I

    .line 1127
    new-array v0, p2, [Landroid/graphics/drawable/Drawable;

    .line 1128
    .local v0, "newDrawables":[Landroid/graphics/drawable/Drawable;
    iget-object v1, p0, La/b/d/c/a/d$b;->g:[Landroid/graphics/drawable/Drawable;

    const/4 v2, 0x0

    invoke-static {v1, v2, v0, v2, p1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 1129
    iput-object v0, p0, La/b/d/c/a/d$b;->g:[Landroid/graphics/drawable/Drawable;

    .line 1130
    return-void
.end method

.method final a(Landroid/content/res/Resources$Theme;)V
    .locals 5
    .param p1, "theme"    # Landroid/content/res/Resources$Theme;

    .line 898
    if-eqz p1, :cond_2

    .line 899
    invoke-direct {p0}, La/b/d/c/a/d$b;->n()V

    .line 900
    iget v0, p0, La/b/d/c/a/d$b;->h:I

    .line 901
    .local v0, "count":I
    iget-object v1, p0, La/b/d/c/a/d$b;->g:[Landroid/graphics/drawable/Drawable;

    .line 902
    .local v1, "drawables":[Landroid/graphics/drawable/Drawable;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    if-ge v2, v0, :cond_1

    .line 903
    aget-object v3, v1, v2

    if-eqz v3, :cond_0

    aget-object v3, v1, v2

    invoke-virtual {v3}, Landroid/graphics/drawable/Drawable;->canApplyTheme()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 904
    aget-object v3, v1, v2

    invoke-virtual {v3, p1}, Landroid/graphics/drawable/Drawable;->applyTheme(Landroid/content/res/Resources$Theme;)V

    .line 906
    iget v3, p0, La/b/d/c/a/d$b;->e:I

    aget-object v4, v1, v2

    invoke-virtual {v4}, Landroid/graphics/drawable/Drawable;->getChangingConfigurations()I

    move-result v4

    or-int/2addr v3, v4

    iput v3, p0, La/b/d/c/a/d$b;->e:I

    .line 902
    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 909
    .end local v2    # "i":I
    :cond_1
    invoke-virtual {p1}, Landroid/content/res/Resources$Theme;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {p0, v2}, La/b/d/c/a/d$b;->a(Landroid/content/res/Resources;)V

    .line 911
    .end local v0    # "count":I
    .end local v1    # "drawables":[Landroid/graphics/drawable/Drawable;
    :cond_2
    return-void
.end method

.method final a(Landroid/content/res/Resources;)V
    .locals 3
    .param p1, "res"    # Landroid/content/res/Resources;

    .line 882
    if-eqz p1, :cond_0

    .line 883
    iput-object p1, p0, La/b/d/c/a/d$b;->b:Landroid/content/res/Resources;

    .line 886
    iget v0, p0, La/b/d/c/a/d$b;->c:I

    invoke-static {p1, v0}, La/b/d/c/a/d;->a(Landroid/content/res/Resources;I)I

    move-result v0

    .line 887
    .local v0, "targetDensity":I
    iget v1, p0, La/b/d/c/a/d$b;->c:I

    .line 888
    .local v1, "sourceDensity":I
    iput v0, p0, La/b/d/c/a/d$b;->c:I

    .line 889
    if-eq v1, v0, :cond_0

    .line 890
    const/4 v2, 0x0

    iput-boolean v2, p0, La/b/d/c/a/d$b;->m:Z

    .line 891
    iput-boolean v2, p0, La/b/d/c/a/d$b;->j:Z

    .line 894
    .end local v0    # "targetDensity":I
    .end local v1    # "sourceDensity":I
    :cond_0
    return-void
.end method

.method public final a(Z)V
    .locals 0
    .param p1, "constant"    # Z

    .line 996
    iput-boolean p1, p0, La/b/d/c/a/d$b;->l:Z

    .line 997
    return-void
.end method

.method public declared-synchronized a()Z
    .locals 5

    monitor-enter p0

    .line 1136
    :try_start_0
    iget-boolean v0, p0, La/b/d/c/a/d$b;->v:Z

    if-eqz v0, :cond_0

    .line 1137
    iget-boolean v0, p0, La/b/d/c/a/d$b;->w:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return v0

    .line 1139
    .end local p0    # "this":La/b/d/c/a/d$b;
    :cond_0
    :try_start_1
    invoke-direct {p0}, La/b/d/c/a/d$b;->n()V

    .line 1140
    const/4 v0, 0x1

    iput-boolean v0, p0, La/b/d/c/a/d$b;->v:Z

    .line 1141
    iget v1, p0, La/b/d/c/a/d$b;->h:I

    .line 1142
    .local v1, "count":I
    iget-object v2, p0, La/b/d/c/a/d$b;->g:[Landroid/graphics/drawable/Drawable;

    .line 1143
    .local v2, "drawables":[Landroid/graphics/drawable/Drawable;
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    if-ge v3, v1, :cond_2

    .line 1144
    aget-object v4, v2, v3

    invoke-virtual {v4}, Landroid/graphics/drawable/Drawable;->getConstantState()Landroid/graphics/drawable/Drawable$ConstantState;

    move-result-object v4

    if-nez v4, :cond_1

    .line 1145
    const/4 v0, 0x0

    iput-boolean v0, p0, La/b/d/c/a/d$b;->w:Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 1146
    monitor-exit p0

    return v0

    .line 1143
    :cond_1
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 1149
    .end local v3    # "i":I
    :cond_2
    :try_start_2
    iput-boolean v0, p0, La/b/d/c/a/d$b;->w:Z
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 1150
    monitor-exit p0

    return v0

    .line 1135
    .end local v1    # "count":I
    .end local v2    # "drawables":[Landroid/graphics/drawable/Drawable;
    :catchall_0
    move-exception v0

    monitor-exit p0

    goto :goto_2

    :goto_1
    throw v0

    :goto_2
    goto :goto_1
.end method

.method protected b()V
    .locals 6

    .line 1047
    const/4 v0, 0x1

    iput-boolean v0, p0, La/b/d/c/a/d$b;->m:Z

    .line 1048
    invoke-direct {p0}, La/b/d/c/a/d$b;->n()V

    .line 1049
    iget v0, p0, La/b/d/c/a/d$b;->h:I

    .line 1050
    .local v0, "count":I
    iget-object v1, p0, La/b/d/c/a/d$b;->g:[Landroid/graphics/drawable/Drawable;

    .line 1051
    .local v1, "drawables":[Landroid/graphics/drawable/Drawable;
    const/4 v2, -0x1

    iput v2, p0, La/b/d/c/a/d$b;->o:I

    iput v2, p0, La/b/d/c/a/d$b;->n:I

    .line 1052
    const/4 v2, 0x0

    iput v2, p0, La/b/d/c/a/d$b;->q:I

    iput v2, p0, La/b/d/c/a/d$b;->p:I

    .line 1053
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    if-ge v2, v0, :cond_4

    .line 1054
    aget-object v3, v1, v2

    .line 1055
    .local v3, "dr":Landroid/graphics/drawable/Drawable;
    invoke-virtual {v3}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v4

    .line 1056
    .local v4, "s":I
    iget v5, p0, La/b/d/c/a/d$b;->n:I

    if-le v4, v5, :cond_0

    iput v4, p0, La/b/d/c/a/d$b;->n:I

    .line 1057
    :cond_0
    invoke-virtual {v3}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v4

    .line 1058
    iget v5, p0, La/b/d/c/a/d$b;->o:I

    if-le v4, v5, :cond_1

    iput v4, p0, La/b/d/c/a/d$b;->o:I

    .line 1059
    :cond_1
    invoke-virtual {v3}, Landroid/graphics/drawable/Drawable;->getMinimumWidth()I

    move-result v4

    .line 1060
    iget v5, p0, La/b/d/c/a/d$b;->p:I

    if-le v4, v5, :cond_2

    iput v4, p0, La/b/d/c/a/d$b;->p:I

    .line 1061
    :cond_2
    invoke-virtual {v3}, Landroid/graphics/drawable/Drawable;->getMinimumHeight()I

    move-result v4

    .line 1062
    iget v5, p0, La/b/d/c/a/d$b;->q:I

    if-le v4, v5, :cond_3

    iput v4, p0, La/b/d/c/a/d$b;->q:I

    .line 1053
    .end local v3    # "dr":Landroid/graphics/drawable/Drawable;
    .end local v4    # "s":I
    :cond_3
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 1064
    .end local v2    # "i":I
    :cond_4
    return-void
.end method

.method public final b(I)V
    .locals 0
    .param p1, "duration"    # I

    .line 1067
    iput p1, p0, La/b/d/c/a/d$b;->A:I

    .line 1068
    return-void
.end method

.method public final b(Z)V
    .locals 0
    .param p1, "variable"    # Z

    .line 964
    iput-boolean p1, p0, La/b/d/c/a/d$b;->i:Z

    .line 965
    return-void
.end method

.method final b(II)Z
    .locals 7
    .param p1, "layoutDirection"    # I
    .param p2, "currentIndex"    # I

    .line 855
    const/4 v0, 0x0

    .line 858
    .local v0, "changed":Z
    iget v1, p0, La/b/d/c/a/d$b;->h:I

    .line 859
    .local v1, "count":I
    iget-object v2, p0, La/b/d/c/a/d$b;->g:[Landroid/graphics/drawable/Drawable;

    .line 860
    .local v2, "drawables":[Landroid/graphics/drawable/Drawable;
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    if-ge v3, v1, :cond_2

    .line 861
    aget-object v4, v2, v3

    if-eqz v4, :cond_1

    .line 862
    const/4 v4, 0x0

    .line 863
    .local v4, "childChanged":Z
    sget v5, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v6, 0x17

    if-lt v5, v6, :cond_0

    .line 864
    aget-object v5, v2, v3

    invoke-virtual {v5, p1}, Landroid/graphics/drawable/Drawable;->setLayoutDirection(I)Z

    move-result v4

    .line 866
    :cond_0
    if-ne v3, p2, :cond_1

    .line 867
    move v0, v4

    .line 860
    .end local v4    # "childChanged":Z
    :cond_1
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 871
    .end local v3    # "i":I
    :cond_2
    iput p1, p0, La/b/d/c/a/d$b;->z:I

    .line 872
    return v0
.end method

.method final c()I
    .locals 1

    .line 801
    iget-object v0, p0, La/b/d/c/a/d$b;->g:[Landroid/graphics/drawable/Drawable;

    array-length v0, v0

    return v0
.end method

.method public final c(I)V
    .locals 0
    .param p1, "duration"    # I

    .line 1075
    iput p1, p0, La/b/d/c/a/d$b;->B:I

    .line 1076
    return-void
.end method

.method public canApplyTheme()Z
    .locals 7

    .line 916
    iget v0, p0, La/b/d/c/a/d$b;->h:I

    .line 917
    .local v0, "count":I
    iget-object v1, p0, La/b/d/c/a/d$b;->g:[Landroid/graphics/drawable/Drawable;

    .line 918
    .local v1, "drawables":[Landroid/graphics/drawable/Drawable;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    if-ge v2, v0, :cond_2

    .line 919
    aget-object v3, v1, v2

    .line 920
    .local v3, "d":Landroid/graphics/drawable/Drawable;
    const/4 v4, 0x1

    if-eqz v3, :cond_0

    .line 921
    invoke-virtual {v3}, Landroid/graphics/drawable/Drawable;->canApplyTheme()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 922
    return v4

    .line 925
    :cond_0
    iget-object v5, p0, La/b/d/c/a/d$b;->f:Landroid/util/SparseArray;

    invoke-virtual {v5, v2}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroid/graphics/drawable/Drawable$ConstantState;

    .line 926
    .local v5, "future":Landroid/graphics/drawable/Drawable$ConstantState;
    if-eqz v5, :cond_1

    invoke-virtual {v5}, Landroid/graphics/drawable/Drawable$ConstantState;->canApplyTheme()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 927
    return v4

    .line 918
    .end local v3    # "d":Landroid/graphics/drawable/Drawable;
    .end local v5    # "future":Landroid/graphics/drawable/Drawable$ConstantState;
    :cond_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 931
    .end local v2    # "i":I
    :cond_2
    const/4 v2, 0x0

    return v2
.end method

.method public final d()I
    .locals 1

    .line 826
    iget v0, p0, La/b/d/c/a/d$b;->h:I

    return v0
.end method

.method public final e()I
    .locals 1

    .line 1020
    iget-boolean v0, p0, La/b/d/c/a/d$b;->m:Z

    if-nez v0, :cond_0

    .line 1021
    invoke-virtual {p0}, La/b/d/c/a/d$b;->b()V

    .line 1023
    :cond_0
    iget v0, p0, La/b/d/c/a/d$b;->o:I

    return v0
.end method

.method public final f()I
    .locals 1

    .line 1040
    iget-boolean v0, p0, La/b/d/c/a/d$b;->m:Z

    if-nez v0, :cond_0

    .line 1041
    invoke-virtual {p0}, La/b/d/c/a/d$b;->b()V

    .line 1043
    :cond_0
    iget v0, p0, La/b/d/c/a/d$b;->q:I

    return v0
.end method

.method public final g()I
    .locals 1

    .line 1030
    iget-boolean v0, p0, La/b/d/c/a/d$b;->m:Z

    if-nez v0, :cond_0

    .line 1031
    invoke-virtual {p0}, La/b/d/c/a/d$b;->b()V

    .line 1033
    :cond_0
    iget v0, p0, La/b/d/c/a/d$b;->p:I

    return v0
.end method

.method public getChangingConfigurations()I
    .locals 2

    .line 764
    iget v0, p0, La/b/d/c/a/d$b;->d:I

    iget v1, p0, La/b/d/c/a/d$b;->e:I

    or-int/2addr v0, v1

    return v0
.end method

.method public final h()Landroid/graphics/Rect;
    .locals 7

    .line 971
    iget-boolean v0, p0, La/b/d/c/a/d$b;->i:Z

    if-eqz v0, :cond_0

    .line 972
    const/4 v0, 0x0

    return-object v0

    .line 974
    :cond_0
    iget-object v0, p0, La/b/d/c/a/d$b;->k:Landroid/graphics/Rect;

    if-nez v0, :cond_8

    iget-boolean v0, p0, La/b/d/c/a/d$b;->j:Z

    if-eqz v0, :cond_1

    goto :goto_1

    .line 977
    :cond_1
    invoke-direct {p0}, La/b/d/c/a/d$b;->n()V

    .line 978
    const/4 v0, 0x0

    .line 979
    .local v0, "r":Landroid/graphics/Rect;
    new-instance v1, Landroid/graphics/Rect;

    invoke-direct {v1}, Landroid/graphics/Rect;-><init>()V

    .line 980
    .local v1, "t":Landroid/graphics/Rect;
    iget v2, p0, La/b/d/c/a/d$b;->h:I

    .line 981
    .local v2, "count":I
    iget-object v3, p0, La/b/d/c/a/d$b;->g:[Landroid/graphics/drawable/Drawable;

    .line 982
    .local v3, "drawables":[Landroid/graphics/drawable/Drawable;
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_0
    if-ge v4, v2, :cond_7

    .line 983
    aget-object v5, v3, v4

    invoke-virtual {v5, v1}, Landroid/graphics/drawable/Drawable;->getPadding(Landroid/graphics/Rect;)Z

    move-result v5

    if-eqz v5, :cond_6

    .line 984
    if-nez v0, :cond_2

    new-instance v5, Landroid/graphics/Rect;

    const/4 v6, 0x0

    invoke-direct {v5, v6, v6, v6, v6}, Landroid/graphics/Rect;-><init>(IIII)V

    move-object v0, v5

    .line 985
    :cond_2
    iget v5, v1, Landroid/graphics/Rect;->left:I

    iget v6, v0, Landroid/graphics/Rect;->left:I

    if-le v5, v6, :cond_3

    iput v5, v0, Landroid/graphics/Rect;->left:I

    .line 986
    :cond_3
    iget v5, v1, Landroid/graphics/Rect;->top:I

    iget v6, v0, Landroid/graphics/Rect;->top:I

    if-le v5, v6, :cond_4

    iput v5, v0, Landroid/graphics/Rect;->top:I

    .line 987
    :cond_4
    iget v5, v1, Landroid/graphics/Rect;->right:I

    iget v6, v0, Landroid/graphics/Rect;->right:I

    if-le v5, v6, :cond_5

    iput v5, v0, Landroid/graphics/Rect;->right:I

    .line 988
    :cond_5
    iget v5, v1, Landroid/graphics/Rect;->bottom:I

    iget v6, v0, Landroid/graphics/Rect;->bottom:I

    if-le v5, v6, :cond_6

    iput v5, v0, Landroid/graphics/Rect;->bottom:I

    .line 982
    :cond_6
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 991
    .end local v4    # "i":I
    :cond_7
    const/4 v4, 0x1

    iput-boolean v4, p0, La/b/d/c/a/d$b;->j:Z

    .line 992
    iput-object v0, p0, La/b/d/c/a/d$b;->k:Landroid/graphics/Rect;

    return-object v0

    .line 975
    .end local v0    # "r":Landroid/graphics/Rect;
    .end local v1    # "t":Landroid/graphics/Rect;
    .end local v2    # "count":I
    .end local v3    # "drawables":[Landroid/graphics/drawable/Drawable;
    :cond_8
    :goto_1
    iget-object v0, p0, La/b/d/c/a/d$b;->k:Landroid/graphics/Rect;

    return-object v0
.end method

.method public final i()I
    .locals 1

    .line 1010
    iget-boolean v0, p0, La/b/d/c/a/d$b;->m:Z

    if-nez v0, :cond_0

    .line 1011
    invoke-virtual {p0}, La/b/d/c/a/d$b;->b()V

    .line 1013
    :cond_0
    iget v0, p0, La/b/d/c/a/d$b;->n:I

    return v0
.end method

.method public final j()I
    .locals 5

    .line 1086
    iget-boolean v0, p0, La/b/d/c/a/d$b;->r:Z

    if-eqz v0, :cond_0

    .line 1087
    iget v0, p0, La/b/d/c/a/d$b;->s:I

    return v0

    .line 1089
    :cond_0
    invoke-direct {p0}, La/b/d/c/a/d$b;->n()V

    .line 1090
    iget v0, p0, La/b/d/c/a/d$b;->h:I

    .line 1091
    .local v0, "count":I
    iget-object v1, p0, La/b/d/c/a/d$b;->g:[Landroid/graphics/drawable/Drawable;

    .line 1092
    .local v1, "drawables":[Landroid/graphics/drawable/Drawable;
    if-lez v0, :cond_1

    const/4 v2, 0x0

    aget-object v2, v1, v2

    invoke-virtual {v2}, Landroid/graphics/drawable/Drawable;->getOpacity()I

    move-result v2

    goto :goto_0

    :cond_1
    const/4 v2, -0x2

    .line 1093
    .local v2, "op":I
    :goto_0
    const/4 v3, 0x1

    .local v3, "i":I
    :goto_1
    if-ge v3, v0, :cond_2

    .line 1094
    aget-object v4, v1, v3

    invoke-virtual {v4}, Landroid/graphics/drawable/Drawable;->getOpacity()I

    move-result v4

    invoke-static {v2, v4}, Landroid/graphics/drawable/Drawable;->resolveOpacity(II)I

    move-result v2

    .line 1093
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 1096
    .end local v3    # "i":I
    :cond_2
    iput v2, p0, La/b/d/c/a/d$b;->s:I

    .line 1097
    const/4 v3, 0x1

    iput-boolean v3, p0, La/b/d/c/a/d$b;->r:Z

    .line 1098
    return v2
.end method

.method k()V
    .locals 1

    .line 796
    const/4 v0, 0x0

    iput-boolean v0, p0, La/b/d/c/a/d$b;->r:Z

    .line 797
    iput-boolean v0, p0, La/b/d/c/a/d$b;->t:Z

    .line 798
    return-void
.end method

.method public final l()Z
    .locals 1

    .line 1003
    iget-boolean v0, p0, La/b/d/c/a/d$b;->l:Z

    return v0
.end method

.method abstract m()V
.end method
