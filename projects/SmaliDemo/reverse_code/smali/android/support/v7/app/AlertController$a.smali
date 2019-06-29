.class public Landroid/support/v7/app/AlertController$a;
.super Ljava/lang/Object;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v7/app/AlertController;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "a"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/support/v7/app/AlertController$a$a;
    }
.end annotation


# instance fields
.field public A:I

.field public B:I

.field public C:I

.field public D:I

.field public E:Z

.field public F:[Z

.field public G:Z

.field public H:Z

.field public I:I

.field public J:Landroid/content/DialogInterface$OnMultiChoiceClickListener;

.field public K:Landroid/database/Cursor;

.field public L:Ljava/lang/String;

.field public M:Ljava/lang/String;

.field public N:Landroid/widget/AdapterView$OnItemSelectedListener;

.field public O:Landroid/support/v7/app/AlertController$a$a;

.field public P:Z

.field public final a:Landroid/content/Context;

.field public final b:Landroid/view/LayoutInflater;

.field public c:I

.field public d:Landroid/graphics/drawable/Drawable;

.field public e:I

.field public f:Ljava/lang/CharSequence;

.field public g:Landroid/view/View;

.field public h:Ljava/lang/CharSequence;

.field public i:Ljava/lang/CharSequence;

.field public j:Landroid/graphics/drawable/Drawable;

.field public k:Landroid/content/DialogInterface$OnClickListener;

.field public l:Ljava/lang/CharSequence;

.field public m:Landroid/graphics/drawable/Drawable;

.field public n:Landroid/content/DialogInterface$OnClickListener;

.field public o:Ljava/lang/CharSequence;

.field public p:Landroid/graphics/drawable/Drawable;

.field public q:Landroid/content/DialogInterface$OnClickListener;

.field public r:Z

.field public s:Landroid/content/DialogInterface$OnCancelListener;

.field public t:Landroid/content/DialogInterface$OnDismissListener;

.field public u:Landroid/content/DialogInterface$OnKeyListener;

.field public v:[Ljava/lang/CharSequence;

.field public w:Landroid/widget/ListAdapter;

.field public x:Landroid/content/DialogInterface$OnClickListener;

.field public y:I

.field public z:Landroid/view/View;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .line 924
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 869
    const/4 v0, 0x0

    iput v0, p0, Landroid/support/v7/app/AlertController$a;->c:I

    .line 871
    iput v0, p0, Landroid/support/v7/app/AlertController$a;->e:I

    .line 897
    iput-boolean v0, p0, Landroid/support/v7/app/AlertController$a;->E:Z

    .line 901
    const/4 v0, -0x1

    iput v0, p0, Landroid/support/v7/app/AlertController$a;->I:I

    .line 909
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v7/app/AlertController$a;->P:Z

    .line 925
    iput-object p1, p0, Landroid/support/v7/app/AlertController$a;->a:Landroid/content/Context;

    .line 926
    iput-boolean v0, p0, Landroid/support/v7/app/AlertController$a;->r:Z

    .line 927
    const-string v0, "layout_inflater"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/LayoutInflater;

    iput-object v0, p0, Landroid/support/v7/app/AlertController$a;->b:Landroid/view/LayoutInflater;

    .line 928
    return-void
.end method

.method private b(Landroid/support/v7/app/AlertController;)V
    .locals 11
    .param p1, "dialog"    # Landroid/support/v7/app/AlertController;

    .line 988
    iget-object v0, p0, Landroid/support/v7/app/AlertController$a;->b:Landroid/view/LayoutInflater;

    iget v1, p1, Landroid/support/v7/app/AlertController;->L:I

    .line 989
    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/v7/app/AlertController$RecycleListView;

    .line 992
    .local v0, "listView":Landroid/support/v7/app/AlertController$RecycleListView;
    iget-boolean v1, p0, Landroid/support/v7/app/AlertController$a;->G:Z

    const/4 v8, 0x1

    if-eqz v1, :cond_1

    .line 993
    iget-object v4, p0, Landroid/support/v7/app/AlertController$a;->K:Landroid/database/Cursor;

    if-nez v4, :cond_0

    .line 994
    new-instance v9, Landroid/support/v7/app/h;

    iget-object v3, p0, Landroid/support/v7/app/AlertController$a;->a:Landroid/content/Context;

    iget v4, p1, Landroid/support/v7/app/AlertController;->M:I

    const v5, 0x1020014

    iget-object v6, p0, Landroid/support/v7/app/AlertController$a;->v:[Ljava/lang/CharSequence;

    move-object v1, v9

    move-object v2, p0

    move-object v7, v0

    invoke-direct/range {v1 .. v7}, Landroid/support/v7/app/h;-><init>(Landroid/support/v7/app/AlertController$a;Landroid/content/Context;II[Ljava/lang/CharSequence;Landroid/support/v7/app/AlertController$RecycleListView;)V

    .local v1, "adapter":Landroid/widget/ListAdapter;
    goto :goto_1

    .line 1009
    .end local v1    # "adapter":Landroid/widget/ListAdapter;
    :cond_0
    new-instance v9, Landroid/support/v7/app/i;

    iget-object v3, p0, Landroid/support/v7/app/AlertController$a;->a:Landroid/content/Context;

    const/4 v5, 0x0

    move-object v1, v9

    move-object v2, p0

    move-object v6, v0

    move-object v7, p1

    invoke-direct/range {v1 .. v7}, Landroid/support/v7/app/i;-><init>(Landroid/support/v7/app/AlertController$a;Landroid/content/Context;Landroid/database/Cursor;ZLandroid/support/v7/app/AlertController$RecycleListView;Landroid/support/v7/app/AlertController;)V

    .restart local v1    # "adapter":Landroid/widget/ListAdapter;
    goto :goto_1

    .line 1038
    .end local v1    # "adapter":Landroid/widget/ListAdapter;
    :cond_1
    iget-boolean v1, p0, Landroid/support/v7/app/AlertController$a;->H:Z

    if-eqz v1, :cond_2

    .line 1039
    iget v1, p1, Landroid/support/v7/app/AlertController;->N:I

    .local v1, "layout":I
    goto :goto_0

    .line 1041
    .end local v1    # "layout":I
    :cond_2
    iget v1, p1, Landroid/support/v7/app/AlertController;->O:I

    .line 1044
    .restart local v1    # "layout":I
    :goto_0
    iget-object v5, p0, Landroid/support/v7/app/AlertController$a;->K:Landroid/database/Cursor;

    const v2, 0x1020014

    if-eqz v5, :cond_3

    .line 1045
    new-instance v9, Landroid/widget/SimpleCursorAdapter;

    iget-object v3, p0, Landroid/support/v7/app/AlertController$a;->a:Landroid/content/Context;

    new-array v6, v8, [Ljava/lang/String;

    iget-object v4, p0, Landroid/support/v7/app/AlertController$a;->L:Ljava/lang/String;

    const/4 v7, 0x0

    aput-object v4, v6, v7

    new-array v10, v8, [I

    aput v2, v10, v7

    move-object v2, v9

    move v4, v1

    move-object v7, v10

    invoke-direct/range {v2 .. v7}, Landroid/widget/SimpleCursorAdapter;-><init>(Landroid/content/Context;ILandroid/database/Cursor;[Ljava/lang/String;[I)V

    move-object v1, v2

    .local v2, "adapter":Landroid/widget/ListAdapter;
    goto :goto_1

    .line 1047
    .end local v2    # "adapter":Landroid/widget/ListAdapter;
    :cond_3
    iget-object v3, p0, Landroid/support/v7/app/AlertController$a;->w:Landroid/widget/ListAdapter;

    if-eqz v3, :cond_4

    .line 1048
    iget-object v2, p0, Landroid/support/v7/app/AlertController$a;->w:Landroid/widget/ListAdapter;

    move-object v1, v2

    .restart local v2    # "adapter":Landroid/widget/ListAdapter;
    goto :goto_1

    .line 1050
    .end local v2    # "adapter":Landroid/widget/ListAdapter;
    :cond_4
    new-instance v3, Landroid/support/v7/app/AlertController$c;

    iget-object v4, p0, Landroid/support/v7/app/AlertController$a;->a:Landroid/content/Context;

    iget-object v5, p0, Landroid/support/v7/app/AlertController$a;->v:[Ljava/lang/CharSequence;

    invoke-direct {v3, v4, v1, v2, v5}, Landroid/support/v7/app/AlertController$c;-><init>(Landroid/content/Context;II[Ljava/lang/CharSequence;)V

    move-object v1, v3

    .line 1054
    .local v1, "adapter":Landroid/widget/ListAdapter;
    :goto_1
    iget-object v2, p0, Landroid/support/v7/app/AlertController$a;->O:Landroid/support/v7/app/AlertController$a$a;

    if-eqz v2, :cond_5

    .line 1055
    invoke-interface {v2, v0}, Landroid/support/v7/app/AlertController$a$a;->a(Landroid/widget/ListView;)V

    .line 1061
    :cond_5
    iput-object v1, p1, Landroid/support/v7/app/AlertController;->H:Landroid/widget/ListAdapter;

    .line 1062
    iget v2, p0, Landroid/support/v7/app/AlertController$a;->I:I

    iput v2, p1, Landroid/support/v7/app/AlertController;->I:I

    .line 1064
    iget-object v2, p0, Landroid/support/v7/app/AlertController$a;->x:Landroid/content/DialogInterface$OnClickListener;

    if-eqz v2, :cond_6

    .line 1065
    new-instance v2, Landroid/support/v7/app/j;

    invoke-direct {v2, p0, p1}, Landroid/support/v7/app/j;-><init>(Landroid/support/v7/app/AlertController$a;Landroid/support/v7/app/AlertController;)V

    invoke-virtual {v0, v2}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    goto :goto_2

    .line 1074
    :cond_6
    iget-object v2, p0, Landroid/support/v7/app/AlertController$a;->J:Landroid/content/DialogInterface$OnMultiChoiceClickListener;

    if-eqz v2, :cond_7

    .line 1075
    new-instance v2, Landroid/support/v7/app/k;

    invoke-direct {v2, p0, v0, p1}, Landroid/support/v7/app/k;-><init>(Landroid/support/v7/app/AlertController$a;Landroid/support/v7/app/AlertController$RecycleListView;Landroid/support/v7/app/AlertController;)V

    invoke-virtual {v0, v2}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 1088
    :cond_7
    :goto_2
    iget-object v2, p0, Landroid/support/v7/app/AlertController$a;->N:Landroid/widget/AdapterView$OnItemSelectedListener;

    if-eqz v2, :cond_8

    .line 1089
    invoke-virtual {v0, v2}, Landroid/widget/ListView;->setOnItemSelectedListener(Landroid/widget/AdapterView$OnItemSelectedListener;)V

    .line 1092
    :cond_8
    iget-boolean v2, p0, Landroid/support/v7/app/AlertController$a;->H:Z

    if-eqz v2, :cond_9

    .line 1093
    invoke-virtual {v0, v8}, Landroid/widget/ListView;->setChoiceMode(I)V

    goto :goto_3

    .line 1094
    :cond_9
    iget-boolean v2, p0, Landroid/support/v7/app/AlertController$a;->G:Z

    if-eqz v2, :cond_a

    .line 1095
    const/4 v2, 0x2

    invoke-virtual {v0, v2}, Landroid/widget/ListView;->setChoiceMode(I)V

    .line 1097
    :cond_a
    :goto_3
    iput-object v0, p1, Landroid/support/v7/app/AlertController;->g:Landroid/widget/ListView;

    .line 1098
    return-void
.end method


# virtual methods
.method public a(Landroid/support/v7/app/AlertController;)V
    .locals 7
    .param p1, "dialog"    # Landroid/support/v7/app/AlertController;

    .line 931
    iget-object v0, p0, Landroid/support/v7/app/AlertController$a;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 932
    invoke-virtual {p1, v0}, Landroid/support/v7/app/AlertController;->b(Landroid/view/View;)V

    goto :goto_0

    .line 934
    :cond_0
    iget-object v0, p0, Landroid/support/v7/app/AlertController$a;->f:Ljava/lang/CharSequence;

    if-eqz v0, :cond_1

    .line 935
    invoke-virtual {p1, v0}, Landroid/support/v7/app/AlertController;->b(Ljava/lang/CharSequence;)V

    .line 937
    :cond_1
    iget-object v0, p0, Landroid/support/v7/app/AlertController$a;->d:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_2

    .line 938
    invoke-virtual {p1, v0}, Landroid/support/v7/app/AlertController;->a(Landroid/graphics/drawable/Drawable;)V

    .line 940
    :cond_2
    iget v0, p0, Landroid/support/v7/app/AlertController$a;->c:I

    if-eqz v0, :cond_3

    .line 941
    invoke-virtual {p1, v0}, Landroid/support/v7/app/AlertController;->b(I)V

    .line 943
    :cond_3
    iget v0, p0, Landroid/support/v7/app/AlertController$a;->e:I

    if-eqz v0, :cond_4

    .line 944
    invoke-virtual {p1, v0}, Landroid/support/v7/app/AlertController;->a(I)I

    move-result v0

    invoke-virtual {p1, v0}, Landroid/support/v7/app/AlertController;->b(I)V

    .line 947
    :cond_4
    :goto_0
    iget-object v0, p0, Landroid/support/v7/app/AlertController$a;->h:Ljava/lang/CharSequence;

    if-eqz v0, :cond_5

    .line 948
    invoke-virtual {p1, v0}, Landroid/support/v7/app/AlertController;->a(Ljava/lang/CharSequence;)V

    .line 950
    :cond_5
    iget-object v0, p0, Landroid/support/v7/app/AlertController$a;->i:Ljava/lang/CharSequence;

    if-nez v0, :cond_6

    iget-object v0, p0, Landroid/support/v7/app/AlertController$a;->j:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_7

    .line 951
    :cond_6
    const/4 v2, -0x1

    iget-object v3, p0, Landroid/support/v7/app/AlertController$a;->i:Ljava/lang/CharSequence;

    iget-object v4, p0, Landroid/support/v7/app/AlertController$a;->k:Landroid/content/DialogInterface$OnClickListener;

    const/4 v5, 0x0

    iget-object v6, p0, Landroid/support/v7/app/AlertController$a;->j:Landroid/graphics/drawable/Drawable;

    move-object v1, p1

    invoke-virtual/range {v1 .. v6}, Landroid/support/v7/app/AlertController;->a(ILjava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;Landroid/os/Message;Landroid/graphics/drawable/Drawable;)V

    .line 954
    :cond_7
    iget-object v0, p0, Landroid/support/v7/app/AlertController$a;->l:Ljava/lang/CharSequence;

    if-nez v0, :cond_8

    iget-object v0, p0, Landroid/support/v7/app/AlertController$a;->m:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_9

    .line 955
    :cond_8
    const/4 v2, -0x2

    iget-object v3, p0, Landroid/support/v7/app/AlertController$a;->l:Ljava/lang/CharSequence;

    iget-object v4, p0, Landroid/support/v7/app/AlertController$a;->n:Landroid/content/DialogInterface$OnClickListener;

    const/4 v5, 0x0

    iget-object v6, p0, Landroid/support/v7/app/AlertController$a;->m:Landroid/graphics/drawable/Drawable;

    move-object v1, p1

    invoke-virtual/range {v1 .. v6}, Landroid/support/v7/app/AlertController;->a(ILjava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;Landroid/os/Message;Landroid/graphics/drawable/Drawable;)V

    .line 958
    :cond_9
    iget-object v0, p0, Landroid/support/v7/app/AlertController$a;->o:Ljava/lang/CharSequence;

    if-nez v0, :cond_a

    iget-object v0, p0, Landroid/support/v7/app/AlertController$a;->p:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_b

    .line 959
    :cond_a
    const/4 v2, -0x3

    iget-object v3, p0, Landroid/support/v7/app/AlertController$a;->o:Ljava/lang/CharSequence;

    iget-object v4, p0, Landroid/support/v7/app/AlertController$a;->q:Landroid/content/DialogInterface$OnClickListener;

    const/4 v5, 0x0

    iget-object v6, p0, Landroid/support/v7/app/AlertController$a;->p:Landroid/graphics/drawable/Drawable;

    move-object v1, p1

    invoke-virtual/range {v1 .. v6}, Landroid/support/v7/app/AlertController;->a(ILjava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;Landroid/os/Message;Landroid/graphics/drawable/Drawable;)V

    .line 964
    :cond_b
    iget-object v0, p0, Landroid/support/v7/app/AlertController$a;->v:[Ljava/lang/CharSequence;

    if-nez v0, :cond_c

    iget-object v0, p0, Landroid/support/v7/app/AlertController$a;->K:Landroid/database/Cursor;

    if-nez v0, :cond_c

    iget-object v0, p0, Landroid/support/v7/app/AlertController$a;->w:Landroid/widget/ListAdapter;

    if-eqz v0, :cond_d

    .line 965
    :cond_c
    invoke-direct {p0, p1}, Landroid/support/v7/app/AlertController$a;->b(Landroid/support/v7/app/AlertController;)V

    .line 967
    :cond_d
    iget-object v2, p0, Landroid/support/v7/app/AlertController$a;->z:Landroid/view/View;

    if-eqz v2, :cond_f

    .line 968
    iget-boolean v0, p0, Landroid/support/v7/app/AlertController$a;->E:Z

    if-eqz v0, :cond_e

    .line 969
    iget v3, p0, Landroid/support/v7/app/AlertController$a;->A:I

    iget v4, p0, Landroid/support/v7/app/AlertController$a;->B:I

    iget v5, p0, Landroid/support/v7/app/AlertController$a;->C:I

    iget v6, p0, Landroid/support/v7/app/AlertController$a;->D:I

    move-object v1, p1

    invoke-virtual/range {v1 .. v6}, Landroid/support/v7/app/AlertController;->a(Landroid/view/View;IIII)V

    goto :goto_1

    .line 972
    :cond_e
    invoke-virtual {p1, v2}, Landroid/support/v7/app/AlertController;->c(Landroid/view/View;)V

    goto :goto_1

    .line 974
    :cond_f
    iget v0, p0, Landroid/support/v7/app/AlertController$a;->y:I

    if-eqz v0, :cond_10

    .line 975
    invoke-virtual {p1, v0}, Landroid/support/v7/app/AlertController;->c(I)V

    .line 985
    :cond_10
    :goto_1
    return-void
.end method
