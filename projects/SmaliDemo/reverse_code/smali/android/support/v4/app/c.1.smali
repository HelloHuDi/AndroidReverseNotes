.class final Landroid/support/v4/app/c;
.super Landroid/support/v4/app/B;
.source ""

# interfaces
.implements Landroid/support/v4/app/o$a;
.implements Landroid/support/v4/app/v$h;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/support/v4/app/c$a;
    }
.end annotation


# instance fields
.field final a:Landroid/support/v4/app/v;

.field b:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Landroid/support/v4/app/c$a;",
            ">;"
        }
    .end annotation
.end field

.field c:I

.field d:I

.field e:I

.field f:I

.field g:I

.field h:I

.field i:Z

.field j:Z

.field k:Ljava/lang/String;

.field l:Z

.field m:I

.field n:I

.field o:Ljava/lang/CharSequence;

.field p:I

.field q:Ljava/lang/CharSequence;

.field r:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field s:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field t:Z

.field u:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Ljava/lang/Runnable;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/support/v4/app/v;)V
    .locals 1
    .param p1, "manager"    # Landroid/support/v4/app/v;

    .line 332
    invoke-direct {p0}, Landroid/support/v4/app/B;-><init>()V

    .line 209
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Landroid/support/v4/app/c;->b:Ljava/util/ArrayList;

    .line 217
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v4/app/c;->j:Z

    .line 220
    const/4 v0, -0x1

    iput v0, p0, Landroid/support/v4/app/c;->m:I

    .line 229
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/support/v4/app/c;->t:Z

    .line 333
    iput-object p1, p0, Landroid/support/v4/app/c;->a:Landroid/support/v4/app/v;

    .line 334
    return-void
.end method

.method private static b(Landroid/support/v4/app/c$a;)Z
    .locals 2
    .param p0, "op"    # Landroid/support/v4/app/c$a;

    .line 1009
    iget-object v0, p0, Landroid/support/v4/app/c$a;->b:Landroid/support/v4/app/i;

    .line 1010
    .local v0, "fragment":Landroid/support/v4/app/i;
    if-eqz v0, :cond_0

    iget-boolean v1, v0, Landroid/support/v4/app/i;->m:Z

    if-eqz v1, :cond_0

    iget-object v1, v0, Landroid/support/v4/app/i;->K:Landroid/view/View;

    if-eqz v1, :cond_0

    iget-boolean v1, v0, Landroid/support/v4/app/i;->D:Z

    if-nez v1, :cond_0

    iget-boolean v1, v0, Landroid/support/v4/app/i;->C:Z

    if-nez v1, :cond_0

    .line 1011
    invoke-virtual {v0}, Landroid/support/v4/app/i;->D()Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v1, 0x1

    goto :goto_0

    :cond_0
    const/4 v1, 0x0

    :goto_0
    return v1
.end method


# virtual methods
.method a(Ljava/util/ArrayList;Landroid/support/v4/app/i;)Landroid/support/v4/app/i;
    .locals 12
    .param p2, "oldPrimaryNav"    # Landroid/support/v4/app/i;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList<",
            "Landroid/support/v4/app/i;",
            ">;",
            "Landroid/support/v4/app/i;",
            ")",
            "Landroid/support/v4/app/i;"
        }
    .end annotation

    .line 888
    .local p1, "added":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v4/app/Fragment;>;"
    const/4 v0, 0x0

    .local v0, "opNum":I
    :goto_0
    iget-object v1, p0, Landroid/support/v4/app/c;->b:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-ge v0, v1, :cond_a

    .line 889
    iget-object v1, p0, Landroid/support/v4/app/c;->b:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/support/v4/app/c$a;

    .line 890
    .local v1, "op":Landroid/support/v4/app/c$a;
    iget v2, v1, Landroid/support/v4/app/c$a;->a:I

    const/4 v3, 0x1

    if-eq v2, v3, :cond_8

    const/4 v4, 0x2

    const/4 v5, 0x3

    const/16 v6, 0x9

    if-eq v2, v4, :cond_2

    if-eq v2, v5, :cond_1

    const/4 v4, 0x6

    if-eq v2, v4, :cond_1

    const/4 v4, 0x7

    if-eq v2, v4, :cond_8

    const/16 v4, 0x8

    if-eq v2, v4, :cond_0

    goto/16 :goto_4

    .line 945
    :cond_0
    iget-object v2, p0, Landroid/support/v4/app/c;->b:Ljava/util/ArrayList;

    new-instance v4, Landroid/support/v4/app/c$a;

    invoke-direct {v4, v6, p2}, Landroid/support/v4/app/c$a;-><init>(ILandroid/support/v4/app/i;)V

    invoke-virtual {v2, v0, v4}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    .line 946
    add-int/lit8 v0, v0, 0x1

    .line 948
    iget-object p2, v1, Landroid/support/v4/app/c$a;->b:Landroid/support/v4/app/i;

    goto/16 :goto_4

    .line 897
    :cond_1
    iget-object v2, v1, Landroid/support/v4/app/c$a;->b:Landroid/support/v4/app/i;

    invoke-virtual {p1, v2}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 898
    iget-object v2, v1, Landroid/support/v4/app/c$a;->b:Landroid/support/v4/app/i;

    if-ne v2, p2, :cond_9

    .line 899
    iget-object v4, p0, Landroid/support/v4/app/c;->b:Ljava/util/ArrayList;

    new-instance v5, Landroid/support/v4/app/c$a;

    invoke-direct {v5, v6, v2}, Landroid/support/v4/app/c$a;-><init>(ILandroid/support/v4/app/i;)V

    invoke-virtual {v4, v0, v5}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    .line 900
    add-int/lit8 v0, v0, 0x1

    .line 901
    const/4 p2, 0x0

    goto :goto_4

    .line 906
    :cond_2
    iget-object v2, v1, Landroid/support/v4/app/c$a;->b:Landroid/support/v4/app/i;

    .line 907
    .local v2, "f":Landroid/support/v4/app/i;
    iget v4, v2, Landroid/support/v4/app/i;->A:I

    .line 908
    .local v4, "containerId":I
    const/4 v7, 0x0

    .line 909
    .local v7, "alreadyAdded":Z
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v8

    sub-int/2addr v8, v3

    .local v8, "i":I
    :goto_1
    if-ltz v8, :cond_6

    .line 910
    invoke-virtual {p1, v8}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Landroid/support/v4/app/i;

    .line 911
    .local v9, "old":Landroid/support/v4/app/i;
    iget v10, v9, Landroid/support/v4/app/i;->A:I

    if-ne v10, v4, :cond_5

    .line 912
    if-ne v9, v2, :cond_3

    .line 913
    const/4 v7, 0x1

    goto :goto_2

    .line 917
    :cond_3
    if-ne v9, p2, :cond_4

    .line 918
    iget-object v10, p0, Landroid/support/v4/app/c;->b:Ljava/util/ArrayList;

    new-instance v11, Landroid/support/v4/app/c$a;

    invoke-direct {v11, v6, v9}, Landroid/support/v4/app/c$a;-><init>(ILandroid/support/v4/app/i;)V

    invoke-virtual {v10, v0, v11}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    .line 919
    add-int/lit8 v0, v0, 0x1

    .line 920
    const/4 p2, 0x0

    .line 922
    :cond_4
    new-instance v10, Landroid/support/v4/app/c$a;

    invoke-direct {v10, v5, v9}, Landroid/support/v4/app/c$a;-><init>(ILandroid/support/v4/app/i;)V

    .line 923
    .local v10, "removeOp":Landroid/support/v4/app/c$a;
    iget v11, v1, Landroid/support/v4/app/c$a;->c:I

    iput v11, v10, Landroid/support/v4/app/c$a;->c:I

    .line 924
    iget v11, v1, Landroid/support/v4/app/c$a;->e:I

    iput v11, v10, Landroid/support/v4/app/c$a;->e:I

    .line 925
    iget v11, v1, Landroid/support/v4/app/c$a;->d:I

    iput v11, v10, Landroid/support/v4/app/c$a;->d:I

    .line 926
    iget v11, v1, Landroid/support/v4/app/c$a;->f:I

    iput v11, v10, Landroid/support/v4/app/c$a;->f:I

    .line 927
    iget-object v11, p0, Landroid/support/v4/app/c;->b:Ljava/util/ArrayList;

    invoke-virtual {v11, v0, v10}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    .line 928
    invoke-virtual {p1, v9}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 929
    add-int/2addr v0, v3

    .line 909
    .end local v9    # "old":Landroid/support/v4/app/i;
    .end local v10    # "removeOp":Landroid/support/v4/app/c$a;
    :cond_5
    :goto_2
    add-int/lit8 v8, v8, -0x1

    goto :goto_1

    .line 933
    .end local v8    # "i":I
    :cond_6
    if-eqz v7, :cond_7

    .line 934
    iget-object v5, p0, Landroid/support/v4/app/c;->b:Ljava/util/ArrayList;

    invoke-virtual {v5, v0}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    .line 935
    add-int/lit8 v0, v0, -0x1

    goto :goto_3

    .line 937
    :cond_7
    iput v3, v1, Landroid/support/v4/app/c$a;->a:I

    .line 938
    invoke-virtual {p1, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 941
    .end local v2    # "f":Landroid/support/v4/app/i;
    .end local v4    # "containerId":I
    .end local v7    # "alreadyAdded":Z
    :goto_3
    goto :goto_4

    .line 893
    :cond_8
    iget-object v2, v1, Landroid/support/v4/app/c$a;->b:Landroid/support/v4/app/i;

    invoke-virtual {p1, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 894
    nop

    .line 888
    .end local v1    # "op":Landroid/support/v4/app/c$a;
    :cond_9
    :goto_4
    add-int/2addr v0, v3

    goto/16 :goto_0

    .line 953
    .end local v0    # "opNum":I
    :cond_a
    return-object p2
.end method

.method a()V
    .locals 7

    .line 755
    iget-object v0, p0, Landroid/support/v4/app/c;->b:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    .line 756
    .local v0, "numOps":I
    const/4 v1, 0x0

    .local v1, "opNum":I
    :goto_0
    const/4 v2, 0x1

    if-ge v1, v0, :cond_2

    .line 757
    iget-object v3, p0, Landroid/support/v4/app/c;->b:Ljava/util/ArrayList;

    invoke-virtual {v3, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/support/v4/app/c$a;

    .line 758
    .local v3, "op":Landroid/support/v4/app/c$a;
    iget-object v4, v3, Landroid/support/v4/app/c$a;->b:Landroid/support/v4/app/i;

    .line 759
    .local v4, "f":Landroid/support/v4/app/i;
    if-eqz v4, :cond_0

    .line 760
    iget v5, p0, Landroid/support/v4/app/c;->g:I

    iget v6, p0, Landroid/support/v4/app/c;->h:I

    invoke-virtual {v4, v5, v6}, Landroid/support/v4/app/i;->a(II)V

    .line 762
    :cond_0
    iget v5, v3, Landroid/support/v4/app/c$a;->a:I

    packed-switch v5, :pswitch_data_0

    .line 794
    :pswitch_0
    new-instance v2, Ljava/lang/IllegalArgumentException;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Unknown cmd: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget v6, v3, Landroid/support/v4/app/c$a;->a:I

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v2, v5}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 791
    :pswitch_1
    iget-object v5, p0, Landroid/support/v4/app/c;->a:Landroid/support/v4/app/v;

    const/4 v6, 0x0

    invoke-virtual {v5, v6}, Landroid/support/v4/app/v;->n(Landroid/support/v4/app/i;)V

    .line 792
    goto :goto_1

    .line 788
    :pswitch_2
    iget-object v5, p0, Landroid/support/v4/app/c;->a:Landroid/support/v4/app/v;

    invoke-virtual {v5, v4}, Landroid/support/v4/app/v;->n(Landroid/support/v4/app/i;)V

    .line 789
    goto :goto_1

    .line 784
    :pswitch_3
    iget v5, v3, Landroid/support/v4/app/c$a;->c:I

    invoke-virtual {v4, v5}, Landroid/support/v4/app/i;->a(I)V

    .line 785
    iget-object v5, p0, Landroid/support/v4/app/c;->a:Landroid/support/v4/app/v;

    invoke-virtual {v5, v4}, Landroid/support/v4/app/v;->a(Landroid/support/v4/app/i;)V

    .line 786
    goto :goto_1

    .line 780
    :pswitch_4
    iget v5, v3, Landroid/support/v4/app/c$a;->d:I

    invoke-virtual {v4, v5}, Landroid/support/v4/app/i;->a(I)V

    .line 781
    iget-object v5, p0, Landroid/support/v4/app/c;->a:Landroid/support/v4/app/v;

    invoke-virtual {v5, v4}, Landroid/support/v4/app/v;->c(Landroid/support/v4/app/i;)V

    .line 782
    goto :goto_1

    .line 776
    :pswitch_5
    iget v5, v3, Landroid/support/v4/app/c$a;->c:I

    invoke-virtual {v4, v5}, Landroid/support/v4/app/i;->a(I)V

    .line 777
    iget-object v5, p0, Landroid/support/v4/app/c;->a:Landroid/support/v4/app/v;

    invoke-virtual {v5, v4}, Landroid/support/v4/app/v;->o(Landroid/support/v4/app/i;)V

    .line 778
    goto :goto_1

    .line 772
    :pswitch_6
    iget v5, v3, Landroid/support/v4/app/c$a;->d:I

    invoke-virtual {v4, v5}, Landroid/support/v4/app/i;->a(I)V

    .line 773
    iget-object v5, p0, Landroid/support/v4/app/c;->a:Landroid/support/v4/app/v;

    invoke-virtual {v5, v4}, Landroid/support/v4/app/v;->e(Landroid/support/v4/app/i;)V

    .line 774
    goto :goto_1

    .line 768
    :pswitch_7
    iget v5, v3, Landroid/support/v4/app/c$a;->d:I

    invoke-virtual {v4, v5}, Landroid/support/v4/app/i;->a(I)V

    .line 769
    iget-object v5, p0, Landroid/support/v4/app/c;->a:Landroid/support/v4/app/v;

    invoke-virtual {v5, v4}, Landroid/support/v4/app/v;->k(Landroid/support/v4/app/i;)V

    .line 770
    goto :goto_1

    .line 764
    :pswitch_8
    iget v5, v3, Landroid/support/v4/app/c$a;->c:I

    invoke-virtual {v4, v5}, Landroid/support/v4/app/i;->a(I)V

    .line 765
    iget-object v5, p0, Landroid/support/v4/app/c;->a:Landroid/support/v4/app/v;

    const/4 v6, 0x0

    invoke-virtual {v5, v4, v6}, Landroid/support/v4/app/v;->a(Landroid/support/v4/app/i;Z)V

    .line 766
    nop

    .line 796
    :goto_1
    iget-boolean v5, p0, Landroid/support/v4/app/c;->t:Z

    if-nez v5, :cond_1

    iget v5, v3, Landroid/support/v4/app/c$a;->a:I

    if-eq v5, v2, :cond_1

    if-eqz v4, :cond_1

    .line 797
    iget-object v2, p0, Landroid/support/v4/app/c;->a:Landroid/support/v4/app/v;

    invoke-virtual {v2, v4}, Landroid/support/v4/app/v;->h(Landroid/support/v4/app/i;)V

    .line 756
    .end local v3    # "op":Landroid/support/v4/app/c$a;
    .end local v4    # "f":Landroid/support/v4/app/i;
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto/16 :goto_0

    .line 800
    .end local v1    # "opNum":I
    :cond_2
    iget-boolean v1, p0, Landroid/support/v4/app/c;->t:Z

    if-nez v1, :cond_3

    .line 802
    iget-object v1, p0, Landroid/support/v4/app/c;->a:Landroid/support/v4/app/v;

    iget v3, v1, Landroid/support/v4/app/v;->r:I

    invoke-virtual {v1, v3, v2}, Landroid/support/v4/app/v;->a(IZ)V

    .line 804
    :cond_3
    return-void

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_8
        :pswitch_0
        :pswitch_7
        :pswitch_6
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
    .end packed-switch
.end method

.method a(I)V
    .locals 6
    .param p1, "amt"    # I

    .line 597
    iget-boolean v0, p0, Landroid/support/v4/app/c;->i:Z

    if-nez v0, :cond_0

    .line 598
    return-void

    .line 600
    :cond_0
    sget-boolean v0, Landroid/support/v4/app/v;->a:Z

    const-string v1, "FragmentManager"

    if-eqz v0, :cond_1

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Bump nesting in "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v2, " by "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 602
    :cond_1
    iget-object v0, p0, Landroid/support/v4/app/c;->b:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    .line 603
    .local v0, "numOps":I
    const/4 v2, 0x0

    .local v2, "opNum":I
    :goto_0
    if-ge v2, v0, :cond_3

    .line 604
    iget-object v3, p0, Landroid/support/v4/app/c;->b:Ljava/util/ArrayList;

    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/support/v4/app/c$a;

    .line 605
    .local v3, "op":Landroid/support/v4/app/c$a;
    iget-object v4, v3, Landroid/support/v4/app/c$a;->b:Landroid/support/v4/app/i;

    if-eqz v4, :cond_2

    .line 606
    iget v5, v4, Landroid/support/v4/app/i;->s:I

    add-int/2addr v5, p1

    iput v5, v4, Landroid/support/v4/app/i;->s:I

    .line 607
    sget-boolean v4, Landroid/support/v4/app/v;->a:Z

    if-eqz v4, :cond_2

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Bump nesting of "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v5, v3, Landroid/support/v4/app/c$a;->b:Landroid/support/v4/app/i;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v5, " to "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v5, v3, Landroid/support/v4/app/c$a;->b:Landroid/support/v4/app/i;

    iget v5, v5, Landroid/support/v4/app/i;->s:I

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v1, v4}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 603
    .end local v3    # "op":Landroid/support/v4/app/c$a;
    :cond_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 611
    .end local v2    # "opNum":I
    :cond_3
    return-void
.end method

.method a(Landroid/support/v4/app/c$a;)V
    .locals 1
    .param p1, "op"    # Landroid/support/v4/app/c$a;

    .line 370
    iget-object v0, p0, Landroid/support/v4/app/c;->b:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 371
    iget v0, p0, Landroid/support/v4/app/c;->c:I

    iput v0, p1, Landroid/support/v4/app/c$a;->c:I

    .line 372
    iget v0, p0, Landroid/support/v4/app/c;->d:I

    iput v0, p1, Landroid/support/v4/app/c$a;->d:I

    .line 373
    iget v0, p0, Landroid/support/v4/app/c;->e:I

    iput v0, p1, Landroid/support/v4/app/c$a;->e:I

    .line 374
    iget v0, p0, Landroid/support/v4/app/c;->f:I

    iput v0, p1, Landroid/support/v4/app/c$a;->f:I

    .line 375
    return-void
.end method

.method a(Landroid/support/v4/app/i$c;)V
    .locals 3
    .param p1, "listener"    # Landroid/support/v4/app/i$c;

    .line 1000
    const/4 v0, 0x0

    .local v0, "opNum":I
    :goto_0
    iget-object v1, p0, Landroid/support/v4/app/c;->b:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-ge v0, v1, :cond_1

    .line 1001
    iget-object v1, p0, Landroid/support/v4/app/c;->b:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/support/v4/app/c$a;

    .line 1002
    .local v1, "op":Landroid/support/v4/app/c$a;
    invoke-static {v1}, Landroid/support/v4/app/c;->b(Landroid/support/v4/app/c$a;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 1003
    iget-object v2, v1, Landroid/support/v4/app/c$a;->b:Landroid/support/v4/app/i;

    invoke-virtual {v2, p1}, Landroid/support/v4/app/i;->a(Landroid/support/v4/app/i$c;)V

    .line 1000
    .end local v1    # "op":Landroid/support/v4/app/c$a;
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 1006
    .end local v0    # "opNum":I
    :cond_1
    return-void
.end method

.method public a(Ljava/lang/String;Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V
    .locals 1
    .param p1, "prefix"    # Ljava/lang/String;
    .param p2, "fd"    # Ljava/io/FileDescriptor;
    .param p3, "writer"    # Ljava/io/PrintWriter;
    .param p4, "args"    # [Ljava/lang/String;

    .line 251
    const/4 v0, 0x1

    invoke-virtual {p0, p1, p3, v0}, Landroid/support/v4/app/c;->a(Ljava/lang/String;Ljava/io/PrintWriter;Z)V

    .line 252
    return-void
.end method

.method public a(Ljava/lang/String;Ljava/io/PrintWriter;Z)V
    .locals 6
    .param p1, "prefix"    # Ljava/lang/String;
    .param p2, "writer"    # Ljava/io/PrintWriter;
    .param p3, "full"    # Z

    .line 255
    if-eqz p3, :cond_8

    .line 256
    invoke-virtual {p2, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v0, "mName="

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-object v0, p0, Landroid/support/v4/app/c;->k:Ljava/lang/String;

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 257
    const-string v0, " mIndex="

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget v0, p0, Landroid/support/v4/app/c;->m:I

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->print(I)V

    .line 258
    const-string v0, " mCommitted="

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-boolean v0, p0, Landroid/support/v4/app/c;->l:Z

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->println(Z)V

    .line 259
    iget v0, p0, Landroid/support/v4/app/c;->g:I

    if-eqz v0, :cond_0

    .line 260
    invoke-virtual {p2, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v0, "mTransition=#"

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 261
    iget v0, p0, Landroid/support/v4/app/c;->g:I

    invoke-static {v0}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 262
    const-string v0, " mTransitionStyle=#"

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 263
    iget v0, p0, Landroid/support/v4/app/c;->h:I

    invoke-static {v0}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->println(Ljava/lang/String;)V

    .line 265
    :cond_0
    iget v0, p0, Landroid/support/v4/app/c;->c:I

    if-nez v0, :cond_1

    iget v0, p0, Landroid/support/v4/app/c;->d:I

    if-eqz v0, :cond_2

    .line 266
    :cond_1
    invoke-virtual {p2, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v0, "mEnterAnim=#"

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 267
    iget v0, p0, Landroid/support/v4/app/c;->c:I

    invoke-static {v0}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 268
    const-string v0, " mExitAnim=#"

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 269
    iget v0, p0, Landroid/support/v4/app/c;->d:I

    invoke-static {v0}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->println(Ljava/lang/String;)V

    .line 271
    :cond_2
    iget v0, p0, Landroid/support/v4/app/c;->e:I

    if-nez v0, :cond_3

    iget v0, p0, Landroid/support/v4/app/c;->f:I

    if-eqz v0, :cond_4

    .line 272
    :cond_3
    invoke-virtual {p2, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v0, "mPopEnterAnim=#"

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 273
    iget v0, p0, Landroid/support/v4/app/c;->e:I

    invoke-static {v0}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 274
    const-string v0, " mPopExitAnim=#"

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 275
    iget v0, p0, Landroid/support/v4/app/c;->f:I

    invoke-static {v0}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->println(Ljava/lang/String;)V

    .line 277
    :cond_4
    iget v0, p0, Landroid/support/v4/app/c;->n:I

    if-nez v0, :cond_5

    iget-object v0, p0, Landroid/support/v4/app/c;->o:Ljava/lang/CharSequence;

    if-eqz v0, :cond_6

    .line 278
    :cond_5
    invoke-virtual {p2, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v0, "mBreadCrumbTitleRes=#"

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 279
    iget v0, p0, Landroid/support/v4/app/c;->n:I

    invoke-static {v0}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 280
    const-string v0, " mBreadCrumbTitleText="

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 281
    iget-object v0, p0, Landroid/support/v4/app/c;->o:Ljava/lang/CharSequence;

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->println(Ljava/lang/Object;)V

    .line 283
    :cond_6
    iget v0, p0, Landroid/support/v4/app/c;->p:I

    if-nez v0, :cond_7

    iget-object v0, p0, Landroid/support/v4/app/c;->q:Ljava/lang/CharSequence;

    if-eqz v0, :cond_8

    .line 284
    :cond_7
    invoke-virtual {p2, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v0, "mBreadCrumbShortTitleRes=#"

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 285
    iget v0, p0, Landroid/support/v4/app/c;->p:I

    invoke-static {v0}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 286
    const-string v0, " mBreadCrumbShortTitleText="

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 287
    iget-object v0, p0, Landroid/support/v4/app/c;->q:Ljava/lang/CharSequence;

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->println(Ljava/lang/Object;)V

    .line 291
    :cond_8
    iget-object v0, p0, Landroid/support/v4/app/c;->b:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_d

    .line 292
    invoke-virtual {p2, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v0, "Operations:"

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->println(Ljava/lang/String;)V

    .line 293
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "    "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 294
    .local v0, "innerPrefix":Ljava/lang/String;
    iget-object v1, p0, Landroid/support/v4/app/c;->b:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    .line 295
    .local v1, "numOps":I
    const/4 v2, 0x0

    .local v2, "opNum":I
    :goto_0
    if-ge v2, v1, :cond_d

    .line 296
    iget-object v3, p0, Landroid/support/v4/app/c;->b:Ljava/util/ArrayList;

    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/support/v4/app/c$a;

    .line 298
    .local v3, "op":Landroid/support/v4/app/c$a;
    iget v4, v3, Landroid/support/v4/app/c$a;->a:I

    packed-switch v4, :pswitch_data_0

    .line 309
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "cmd="

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget v5, v3, Landroid/support/v4/app/c$a;->a:I

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .local v4, "cmdStr":Ljava/lang/String;
    goto :goto_1

    .line 308
    .end local v4    # "cmdStr":Ljava/lang/String;
    :pswitch_0
    const-string v4, "UNSET_PRIMARY_NAV"

    .restart local v4    # "cmdStr":Ljava/lang/String;
    goto :goto_1

    .line 307
    .end local v4    # "cmdStr":Ljava/lang/String;
    :pswitch_1
    const-string v4, "SET_PRIMARY_NAV"

    .restart local v4    # "cmdStr":Ljava/lang/String;
    goto :goto_1

    .line 306
    .end local v4    # "cmdStr":Ljava/lang/String;
    :pswitch_2
    const-string v4, "ATTACH"

    .restart local v4    # "cmdStr":Ljava/lang/String;
    goto :goto_1

    .line 305
    .end local v4    # "cmdStr":Ljava/lang/String;
    :pswitch_3
    const-string v4, "DETACH"

    .restart local v4    # "cmdStr":Ljava/lang/String;
    goto :goto_1

    .line 304
    .end local v4    # "cmdStr":Ljava/lang/String;
    :pswitch_4
    const-string v4, "SHOW"

    .restart local v4    # "cmdStr":Ljava/lang/String;
    goto :goto_1

    .line 303
    .end local v4    # "cmdStr":Ljava/lang/String;
    :pswitch_5
    const-string v4, "HIDE"

    .restart local v4    # "cmdStr":Ljava/lang/String;
    goto :goto_1

    .line 302
    .end local v4    # "cmdStr":Ljava/lang/String;
    :pswitch_6
    const-string v4, "REMOVE"

    .restart local v4    # "cmdStr":Ljava/lang/String;
    goto :goto_1

    .line 301
    .end local v4    # "cmdStr":Ljava/lang/String;
    :pswitch_7
    const-string v4, "REPLACE"

    .restart local v4    # "cmdStr":Ljava/lang/String;
    goto :goto_1

    .line 300
    .end local v4    # "cmdStr":Ljava/lang/String;
    :pswitch_8
    const-string v4, "ADD"

    .restart local v4    # "cmdStr":Ljava/lang/String;
    goto :goto_1

    .line 299
    .end local v4    # "cmdStr":Ljava/lang/String;
    :pswitch_9
    const-string v4, "NULL"

    .line 311
    .restart local v4    # "cmdStr":Ljava/lang/String;
    :goto_1
    invoke-virtual {p2, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v5, "  Op #"

    invoke-virtual {p2, v5}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    invoke-virtual {p2, v2}, Ljava/io/PrintWriter;->print(I)V

    .line 312
    const-string v5, ": "

    invoke-virtual {p2, v5}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    invoke-virtual {p2, v4}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 313
    const-string v5, " "

    invoke-virtual {p2, v5}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-object v5, v3, Landroid/support/v4/app/c$a;->b:Landroid/support/v4/app/i;

    invoke-virtual {p2, v5}, Ljava/io/PrintWriter;->println(Ljava/lang/Object;)V

    .line 314
    if-eqz p3, :cond_c

    .line 315
    iget v5, v3, Landroid/support/v4/app/c$a;->c:I

    if-nez v5, :cond_9

    iget v5, v3, Landroid/support/v4/app/c$a;->d:I

    if-eqz v5, :cond_a

    .line 316
    :cond_9
    invoke-virtual {p2, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v5, "enterAnim=#"

    invoke-virtual {p2, v5}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 317
    iget v5, v3, Landroid/support/v4/app/c$a;->c:I

    invoke-static {v5}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p2, v5}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 318
    const-string v5, " exitAnim=#"

    invoke-virtual {p2, v5}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 319
    iget v5, v3, Landroid/support/v4/app/c$a;->d:I

    invoke-static {v5}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p2, v5}, Ljava/io/PrintWriter;->println(Ljava/lang/String;)V

    .line 321
    :cond_a
    iget v5, v3, Landroid/support/v4/app/c$a;->e:I

    if-nez v5, :cond_b

    iget v5, v3, Landroid/support/v4/app/c$a;->f:I

    if-eqz v5, :cond_c

    .line 322
    :cond_b
    invoke-virtual {p2, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v5, "popEnterAnim=#"

    invoke-virtual {p2, v5}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 323
    iget v5, v3, Landroid/support/v4/app/c$a;->e:I

    invoke-static {v5}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p2, v5}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 324
    const-string v5, " popExitAnim=#"

    invoke-virtual {p2, v5}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 325
    iget v5, v3, Landroid/support/v4/app/c$a;->f:I

    invoke-static {v5}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p2, v5}, Ljava/io/PrintWriter;->println(Ljava/lang/String;)V

    .line 295
    .end local v3    # "op":Landroid/support/v4/app/c$a;
    .end local v4    # "cmdStr":Ljava/lang/String;
    :cond_c
    add-int/lit8 v2, v2, 0x1

    goto/16 :goto_0

    .line 330
    .end local v0    # "innerPrefix":Ljava/lang/String;
    .end local v1    # "numOps":I
    .end local v2    # "opNum":I
    :cond_d
    return-void

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_9
        :pswitch_8
        :pswitch_7
        :pswitch_6
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method a(Z)V
    .locals 6
    .param p1, "moveToState"    # Z

    .line 814
    iget-object v0, p0, Landroid/support/v4/app/c;->b:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    const/4 v1, 0x1

    sub-int/2addr v0, v1

    .local v0, "opNum":I
    :goto_0
    if-ltz v0, :cond_2

    .line 815
    iget-object v2, p0, Landroid/support/v4/app/c;->b:Ljava/util/ArrayList;

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/support/v4/app/c$a;

    .line 816
    .local v2, "op":Landroid/support/v4/app/c$a;
    iget-object v3, v2, Landroid/support/v4/app/c$a;->b:Landroid/support/v4/app/i;

    .line 817
    .local v3, "f":Landroid/support/v4/app/i;
    if-eqz v3, :cond_0

    .line 818
    iget v4, p0, Landroid/support/v4/app/c;->g:I

    invoke-static {v4}, Landroid/support/v4/app/v;->d(I)I

    move-result v4

    iget v5, p0, Landroid/support/v4/app/c;->h:I

    invoke-virtual {v3, v4, v5}, Landroid/support/v4/app/i;->a(II)V

    .line 821
    :cond_0
    iget v4, v2, Landroid/support/v4/app/c$a;->a:I

    packed-switch v4, :pswitch_data_0

    .line 853
    :pswitch_0
    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Unknown cmd: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget v5, v2, Landroid/support/v4/app/c$a;->a:I

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v1, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 850
    :pswitch_1
    iget-object v4, p0, Landroid/support/v4/app/c;->a:Landroid/support/v4/app/v;

    invoke-virtual {v4, v3}, Landroid/support/v4/app/v;->n(Landroid/support/v4/app/i;)V

    .line 851
    goto :goto_1

    .line 847
    :pswitch_2
    iget-object v4, p0, Landroid/support/v4/app/c;->a:Landroid/support/v4/app/v;

    const/4 v5, 0x0

    invoke-virtual {v4, v5}, Landroid/support/v4/app/v;->n(Landroid/support/v4/app/i;)V

    .line 848
    goto :goto_1

    .line 843
    :pswitch_3
    iget v4, v2, Landroid/support/v4/app/c$a;->f:I

    invoke-virtual {v3, v4}, Landroid/support/v4/app/i;->a(I)V

    .line 844
    iget-object v4, p0, Landroid/support/v4/app/c;->a:Landroid/support/v4/app/v;

    invoke-virtual {v4, v3}, Landroid/support/v4/app/v;->c(Landroid/support/v4/app/i;)V

    .line 845
    goto :goto_1

    .line 839
    :pswitch_4
    iget v4, v2, Landroid/support/v4/app/c$a;->e:I

    invoke-virtual {v3, v4}, Landroid/support/v4/app/i;->a(I)V

    .line 840
    iget-object v4, p0, Landroid/support/v4/app/c;->a:Landroid/support/v4/app/v;

    invoke-virtual {v4, v3}, Landroid/support/v4/app/v;->a(Landroid/support/v4/app/i;)V

    .line 841
    goto :goto_1

    .line 835
    :pswitch_5
    iget v4, v2, Landroid/support/v4/app/c$a;->f:I

    invoke-virtual {v3, v4}, Landroid/support/v4/app/i;->a(I)V

    .line 836
    iget-object v4, p0, Landroid/support/v4/app/c;->a:Landroid/support/v4/app/v;

    invoke-virtual {v4, v3}, Landroid/support/v4/app/v;->e(Landroid/support/v4/app/i;)V

    .line 837
    goto :goto_1

    .line 831
    :pswitch_6
    iget v4, v2, Landroid/support/v4/app/c$a;->e:I

    invoke-virtual {v3, v4}, Landroid/support/v4/app/i;->a(I)V

    .line 832
    iget-object v4, p0, Landroid/support/v4/app/c;->a:Landroid/support/v4/app/v;

    invoke-virtual {v4, v3}, Landroid/support/v4/app/v;->o(Landroid/support/v4/app/i;)V

    .line 833
    goto :goto_1

    .line 827
    :pswitch_7
    iget v4, v2, Landroid/support/v4/app/c$a;->e:I

    invoke-virtual {v3, v4}, Landroid/support/v4/app/i;->a(I)V

    .line 828
    iget-object v4, p0, Landroid/support/v4/app/c;->a:Landroid/support/v4/app/v;

    const/4 v5, 0x0

    invoke-virtual {v4, v3, v5}, Landroid/support/v4/app/v;->a(Landroid/support/v4/app/i;Z)V

    .line 829
    goto :goto_1

    .line 823
    :pswitch_8
    iget v4, v2, Landroid/support/v4/app/c$a;->f:I

    invoke-virtual {v3, v4}, Landroid/support/v4/app/i;->a(I)V

    .line 824
    iget-object v4, p0, Landroid/support/v4/app/c;->a:Landroid/support/v4/app/v;

    invoke-virtual {v4, v3}, Landroid/support/v4/app/v;->k(Landroid/support/v4/app/i;)V

    .line 825
    nop

    .line 855
    :goto_1
    iget-boolean v4, p0, Landroid/support/v4/app/c;->t:Z

    if-nez v4, :cond_1

    iget v4, v2, Landroid/support/v4/app/c$a;->a:I

    const/4 v5, 0x3

    if-eq v4, v5, :cond_1

    if-eqz v3, :cond_1

    .line 856
    iget-object v4, p0, Landroid/support/v4/app/c;->a:Landroid/support/v4/app/v;

    invoke-virtual {v4, v3}, Landroid/support/v4/app/v;->h(Landroid/support/v4/app/i;)V

    .line 814
    .end local v2    # "op":Landroid/support/v4/app/c$a;
    .end local v3    # "f":Landroid/support/v4/app/i;
    :cond_1
    add-int/lit8 v0, v0, -0x1

    goto/16 :goto_0

    .line 859
    .end local v0    # "opNum":I
    :cond_2
    iget-boolean v0, p0, Landroid/support/v4/app/c;->t:Z

    if-nez v0, :cond_3

    if-eqz p1, :cond_3

    .line 860
    iget-object v0, p0, Landroid/support/v4/app/c;->a:Landroid/support/v4/app/v;

    iget v2, v0, Landroid/support/v4/app/v;->r:I

    invoke-virtual {v0, v2, v1}, Landroid/support/v4/app/v;->a(IZ)V

    .line 862
    :cond_3
    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_8
        :pswitch_0
        :pswitch_7
        :pswitch_6
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
    .end packed-switch
.end method

.method a(Ljava/util/ArrayList;II)Z
    .locals 12
    .param p2, "startIndex"    # I
    .param p3, "endIndex"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList<",
            "Landroid/support/v4/app/c;",
            ">;II)Z"
        }
    .end annotation

    .line 723
    .local p1, "records":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v4/app/BackStackRecord;>;"
    const/4 v0, 0x0

    if-ne p3, p2, :cond_0

    .line 724
    return v0

    .line 726
    :cond_0
    iget-object v1, p0, Landroid/support/v4/app/c;->b:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    .line 727
    .local v1, "numOps":I
    const/4 v2, -0x1

    .line 728
    .local v2, "lastContainer":I
    const/4 v3, 0x0

    .local v3, "opNum":I
    :goto_0
    if-ge v3, v1, :cond_6

    .line 729
    iget-object v4, p0, Landroid/support/v4/app/c;->b:Ljava/util/ArrayList;

    invoke-virtual {v4, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/support/v4/app/c$a;

    .line 730
    .local v4, "op":Landroid/support/v4/app/c$a;
    iget-object v5, v4, Landroid/support/v4/app/c$a;->b:Landroid/support/v4/app/i;

    if-eqz v5, :cond_1

    iget v5, v5, Landroid/support/v4/app/i;->A:I

    goto :goto_1

    :cond_1
    const/4 v5, 0x0

    .line 731
    .local v5, "container":I
    :goto_1
    if-eqz v5, :cond_5

    if-eq v5, v2, :cond_5

    .line 732
    move v2, v5

    .line 733
    move v6, p2

    .local v6, "i":I
    :goto_2
    if-ge v6, p3, :cond_5

    .line 734
    invoke-virtual {p1, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Landroid/support/v4/app/c;

    .line 735
    .local v7, "record":Landroid/support/v4/app/c;
    iget-object v8, v7, Landroid/support/v4/app/c;->b:Ljava/util/ArrayList;

    invoke-virtual {v8}, Ljava/util/ArrayList;->size()I

    move-result v8

    .line 736
    .local v8, "numThoseOps":I
    const/4 v9, 0x0

    .local v9, "thoseOpIndex":I
    :goto_3
    if-ge v9, v8, :cond_4

    .line 737
    iget-object v10, v7, Landroid/support/v4/app/c;->b:Ljava/util/ArrayList;

    invoke-virtual {v10, v9}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Landroid/support/v4/app/c$a;

    .line 738
    .local v10, "thatOp":Landroid/support/v4/app/c$a;
    iget-object v11, v10, Landroid/support/v4/app/c$a;->b:Landroid/support/v4/app/i;

    if-eqz v11, :cond_2

    iget v11, v11, Landroid/support/v4/app/i;->A:I

    goto :goto_4

    :cond_2
    const/4 v11, 0x0

    .line 740
    .local v11, "thatContainer":I
    :goto_4
    if-ne v11, v5, :cond_3

    .line 741
    const/4 v0, 0x1

    return v0

    .line 736
    .end local v10    # "thatOp":Landroid/support/v4/app/c$a;
    .end local v11    # "thatContainer":I
    :cond_3
    add-int/lit8 v9, v9, 0x1

    goto :goto_3

    .line 733
    .end local v7    # "record":Landroid/support/v4/app/c;
    .end local v8    # "numThoseOps":I
    .end local v9    # "thoseOpIndex":I
    :cond_4
    add-int/lit8 v6, v6, 0x1

    goto :goto_2

    .line 728
    .end local v4    # "op":Landroid/support/v4/app/c$a;
    .end local v5    # "container":I
    .end local v6    # "i":I
    :cond_5
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 747
    .end local v3    # "opNum":I
    :cond_6
    return v0
.end method

.method public a(Ljava/util/ArrayList;Ljava/util/ArrayList;)Z
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList<",
            "Landroid/support/v4/app/c;",
            ">;",
            "Ljava/util/ArrayList<",
            "Ljava/lang/Boolean;",
            ">;)Z"
        }
    .end annotation

    .line 698
    .local p1, "records":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v4/app/BackStackRecord;>;"
    .local p2, "isRecordPop":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/Boolean;>;"
    sget-boolean v0, Landroid/support/v4/app/v;->a:Z

    if-eqz v0, :cond_0

    .line 699
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Run: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v1, "FragmentManager"

    invoke-static {v1, v0}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 702
    :cond_0
    invoke-virtual {p1, p0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 703
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 704
    iget-boolean v0, p0, Landroid/support/v4/app/c;->i:Z

    if-eqz v0, :cond_1

    .line 705
    iget-object v0, p0, Landroid/support/v4/app/c;->a:Landroid/support/v4/app/v;

    invoke-virtual {v0, p0}, Landroid/support/v4/app/v;->a(Landroid/support/v4/app/c;)V

    .line 707
    :cond_1
    const/4 v0, 0x1

    return v0
.end method

.method b(Ljava/util/ArrayList;Landroid/support/v4/app/i;)Landroid/support/v4/app/i;
    .locals 4
    .param p2, "oldPrimaryNav"    # Landroid/support/v4/app/i;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList<",
            "Landroid/support/v4/app/i;",
            ">;",
            "Landroid/support/v4/app/i;",
            ")",
            "Landroid/support/v4/app/i;"
        }
    .end annotation

    .line 967
    .local p1, "added":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v4/app/Fragment;>;"
    const/4 v0, 0x0

    .local v0, "opNum":I
    :goto_0
    iget-object v1, p0, Landroid/support/v4/app/c;->b:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-ge v0, v1, :cond_2

    .line 968
    iget-object v1, p0, Landroid/support/v4/app/c;->b:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/support/v4/app/c$a;

    .line 969
    .local v1, "op":Landroid/support/v4/app/c$a;
    iget v2, v1, Landroid/support/v4/app/c$a;->a:I

    const/4 v3, 0x1

    if-eq v2, v3, :cond_1

    const/4 v3, 0x3

    if-eq v2, v3, :cond_0

    packed-switch v2, :pswitch_data_0

    goto :goto_1

    .line 979
    :pswitch_0
    iget-object p2, v1, Landroid/support/v4/app/c$a;->b:Landroid/support/v4/app/i;

    .line 980
    goto :goto_1

    .line 982
    :pswitch_1
    const/4 p2, 0x0

    goto :goto_1

    .line 976
    :cond_0
    :pswitch_2
    iget-object v2, v1, Landroid/support/v4/app/c$a;->b:Landroid/support/v4/app/i;

    invoke-virtual {p1, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 977
    goto :goto_1

    .line 972
    :cond_1
    :pswitch_3
    iget-object v2, v1, Landroid/support/v4/app/c$a;->b:Landroid/support/v4/app/i;

    invoke-virtual {p1, v2}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 973
    nop

    .line 967
    .end local v1    # "op":Landroid/support/v4/app/c$a;
    :goto_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 986
    .end local v0    # "opNum":I
    :cond_2
    return-object p2

    :pswitch_data_0
    .packed-switch 0x6
        :pswitch_2
        :pswitch_3
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public b()Ljava/lang/String;
    .locals 1

    .line 1017
    iget-object v0, p0, Landroid/support/v4/app/c;->k:Ljava/lang/String;

    return-object v0
.end method

.method b(I)Z
    .locals 5
    .param p1, "containerId"    # I

    .line 711
    iget-object v0, p0, Landroid/support/v4/app/c;->b:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    .line 712
    .local v0, "numOps":I
    const/4 v1, 0x0

    .local v1, "opNum":I
    :goto_0
    const/4 v2, 0x0

    if-ge v1, v0, :cond_2

    .line 713
    iget-object v3, p0, Landroid/support/v4/app/c;->b:Ljava/util/ArrayList;

    invoke-virtual {v3, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/support/v4/app/c$a;

    .line 714
    .local v3, "op":Landroid/support/v4/app/c$a;
    iget-object v4, v3, Landroid/support/v4/app/c$a;->b:Landroid/support/v4/app/i;

    if-eqz v4, :cond_0

    iget v2, v4, Landroid/support/v4/app/i;->A:I

    .line 715
    .local v2, "fragContainer":I
    :cond_0
    if-eqz v2, :cond_1

    if-ne v2, p1, :cond_1

    .line 716
    const/4 v4, 0x1

    return v4

    .line 712
    .end local v2    # "fragContainer":I
    .end local v3    # "op":Landroid/support/v4/app/c$a;
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 719
    .end local v1    # "opNum":I
    :cond_2
    return v2
.end method

.method c()Z
    .locals 3

    .line 990
    const/4 v0, 0x0

    .local v0, "opNum":I
    :goto_0
    iget-object v1, p0, Landroid/support/v4/app/c;->b:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-ge v0, v1, :cond_1

    .line 991
    iget-object v1, p0, Landroid/support/v4/app/c;->b:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/support/v4/app/c$a;

    .line 992
    .local v1, "op":Landroid/support/v4/app/c$a;
    invoke-static {v1}, Landroid/support/v4/app/c;->b(Landroid/support/v4/app/c$a;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 993
    const/4 v2, 0x1

    return v2

    .line 990
    .end local v1    # "op":Landroid/support/v4/app/c$a;
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 996
    .end local v0    # "opNum":I
    :cond_1
    const/4 v0, 0x0

    return v0
.end method

.method public d()V
    .locals 3

    .line 627
    iget-object v0, p0, Landroid/support/v4/app/c;->u:Ljava/util/ArrayList;

    if-eqz v0, :cond_1

    .line 628
    const/4 v1, 0x0

    .local v1, "i":I
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    .local v0, "N":I
    :goto_0
    if-ge v1, v0, :cond_0

    .line 629
    iget-object v2, p0, Landroid/support/v4/app/c;->u:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Runnable;

    invoke-interface {v2}, Ljava/lang/Runnable;->run()V

    .line 628
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 631
    .end local v0    # "N":I
    .end local v1    # "i":I
    :cond_0
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/support/v4/app/c;->u:Ljava/util/ArrayList;

    .line 633
    :cond_1
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .line 235
    new-instance v0, Ljava/lang/StringBuilder;

    const/16 v1, 0x80

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 236
    .local v0, "sb":Ljava/lang/StringBuilder;
    const-string v1, "BackStackEntry{"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 237
    invoke-static {p0}, Ljava/lang/System;->identityHashCode(Ljava/lang/Object;)I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 238
    iget v1, p0, Landroid/support/v4/app/c;->m:I

    if-ltz v1, :cond_0

    .line 239
    const-string v1, " #"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 240
    iget v1, p0, Landroid/support/v4/app/c;->m:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 242
    :cond_0
    iget-object v1, p0, Landroid/support/v4/app/c;->k:Ljava/lang/String;

    if-eqz v1, :cond_1

    .line 243
    const-string v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 244
    iget-object v1, p0, Landroid/support/v4/app/c;->k:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 246
    :cond_1
    const-string v1, "}"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 247
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method
