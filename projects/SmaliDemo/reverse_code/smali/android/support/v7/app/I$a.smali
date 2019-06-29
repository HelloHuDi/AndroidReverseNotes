.class public Landroid/support/v7/app/I$a;
.super La/b/d/d/b;
.source ""

# interfaces
.implements Landroid/support/v7/view/menu/l$a;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v7/app/I;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "a"
.end annotation


# instance fields
.field private final c:Landroid/content/Context;

.field private final d:Landroid/support/v7/view/menu/l;

.field private e:La/b/d/d/b$a;

.field private f:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference<",
            "Landroid/view/View;",
            ">;"
        }
    .end annotation
.end field

.field final synthetic g:Landroid/support/v7/app/I;


# direct methods
.method public constructor <init>(Landroid/support/v7/app/I;Landroid/content/Context;La/b/d/d/b$a;)V
    .locals 2
    .param p1, "this$0"    # Landroid/support/v7/app/I;
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "callback"    # La/b/d/d/b$a;

    .line 993
    iput-object p1, p0, Landroid/support/v7/app/I$a;->g:Landroid/support/v7/app/I;

    invoke-direct {p0}, La/b/d/d/b;-><init>()V

    .line 994
    iput-object p2, p0, Landroid/support/v7/app/I$a;->c:Landroid/content/Context;

    .line 995
    iput-object p3, p0, Landroid/support/v7/app/I$a;->e:La/b/d/d/b$a;

    .line 996
    new-instance v0, Landroid/support/v7/view/menu/l;

    invoke-direct {v0, p2}, Landroid/support/v7/view/menu/l;-><init>(Landroid/content/Context;)V

    .line 997
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/support/v7/view/menu/l;->c(I)Landroid/support/v7/view/menu/l;

    iput-object v0, p0, Landroid/support/v7/app/I$a;->d:Landroid/support/v7/view/menu/l;

    .line 998
    iget-object v0, p0, Landroid/support/v7/app/I$a;->d:Landroid/support/v7/view/menu/l;

    invoke-virtual {v0, p0}, Landroid/support/v7/view/menu/l;->a(Landroid/support/v7/view/menu/l$a;)V

    .line 999
    return-void
.end method


# virtual methods
.method public a()V
    .locals 3

    .line 1013
    iget-object v0, p0, Landroid/support/v7/app/I$a;->g:Landroid/support/v7/app/I;

    iget-object v1, v0, Landroid/support/v7/app/I;->p:Landroid/support/v7/app/I$a;

    if-eq v1, p0, :cond_0

    .line 1015
    return-void

    .line 1022
    :cond_0
    iget-boolean v1, v0, Landroid/support/v7/app/I;->x:Z

    iget-boolean v0, v0, Landroid/support/v7/app/I;->y:Z

    const/4 v2, 0x0

    invoke-static {v1, v0, v2}, Landroid/support/v7/app/I;->a(ZZZ)Z

    move-result v0

    if-nez v0, :cond_1

    .line 1025
    iget-object v0, p0, Landroid/support/v7/app/I$a;->g:Landroid/support/v7/app/I;

    iput-object p0, v0, Landroid/support/v7/app/I;->q:La/b/d/d/b;

    .line 1026
    iget-object v1, p0, Landroid/support/v7/app/I$a;->e:La/b/d/d/b$a;

    iput-object v1, v0, Landroid/support/v7/app/I;->r:La/b/d/d/b$a;

    goto :goto_0

    .line 1028
    :cond_1
    iget-object v0, p0, Landroid/support/v7/app/I$a;->e:La/b/d/d/b$a;

    invoke-interface {v0, p0}, La/b/d/d/b$a;->a(La/b/d/d/b;)V

    .line 1030
    :goto_0
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/support/v7/app/I$a;->e:La/b/d/d/b$a;

    .line 1031
    iget-object v1, p0, Landroid/support/v7/app/I$a;->g:Landroid/support/v7/app/I;

    invoke-virtual {v1, v2}, Landroid/support/v7/app/I;->e(Z)V

    .line 1034
    iget-object v1, p0, Landroid/support/v7/app/I$a;->g:Landroid/support/v7/app/I;

    iget-object v1, v1, Landroid/support/v7/app/I;->j:Landroid/support/v7/widget/ActionBarContextView;

    invoke-virtual {v1}, Landroid/support/v7/widget/ActionBarContextView;->a()V

    .line 1035
    iget-object v1, p0, Landroid/support/v7/app/I$a;->g:Landroid/support/v7/app/I;

    iget-object v1, v1, Landroid/support/v7/app/I;->i:Landroid/support/v7/widget/L;

    invoke-interface {v1}, Landroid/support/v7/widget/L;->j()Landroid/view/ViewGroup;

    move-result-object v1

    const/16 v2, 0x20

    invoke-virtual {v1, v2}, Landroid/view/ViewGroup;->sendAccessibilityEvent(I)V

    .line 1037
    iget-object v1, p0, Landroid/support/v7/app/I$a;->g:Landroid/support/v7/app/I;

    iget-object v2, v1, Landroid/support/v7/app/I;->g:Landroid/support/v7/widget/ActionBarOverlayLayout;

    iget-boolean v1, v1, Landroid/support/v7/app/I;->D:Z

    invoke-virtual {v2, v1}, Landroid/support/v7/widget/ActionBarOverlayLayout;->setHideOnContentScrollEnabled(Z)V

    .line 1039
    iget-object v1, p0, Landroid/support/v7/app/I$a;->g:Landroid/support/v7/app/I;

    iput-object v0, v1, Landroid/support/v7/app/I;->p:Landroid/support/v7/app/I$a;

    .line 1040
    return-void
.end method

.method public a(I)V
    .locals 1
    .param p1, "resId"    # I

    .line 1091
    iget-object v0, p0, Landroid/support/v7/app/I$a;->g:Landroid/support/v7/app/I;

    iget-object v0, v0, Landroid/support/v7/app/I;->c:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Landroid/support/v7/app/I$a;->a(Ljava/lang/CharSequence;)V

    .line 1092
    return-void
.end method

.method public a(Landroid/support/v7/view/menu/l;)V
    .locals 1
    .param p1, "menu"    # Landroid/support/v7/view/menu/l;

    .line 1150
    iget-object v0, p0, Landroid/support/v7/app/I$a;->e:La/b/d/d/b$a;

    if-nez v0, :cond_0

    .line 1151
    return-void

    .line 1153
    :cond_0
    invoke-virtual {p0}, Landroid/support/v7/app/I$a;->i()V

    .line 1154
    iget-object v0, p0, Landroid/support/v7/app/I$a;->g:Landroid/support/v7/app/I;

    iget-object v0, v0, Landroid/support/v7/app/I;->j:Landroid/support/v7/widget/ActionBarContextView;

    invoke-virtual {v0}, Landroid/support/v7/widget/ActionBarContextView;->d()Z

    .line 1155
    return-void
.end method

.method public a(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .line 1070
    iget-object v0, p0, Landroid/support/v7/app/I$a;->g:Landroid/support/v7/app/I;

    iget-object v0, v0, Landroid/support/v7/app/I;->j:Landroid/support/v7/widget/ActionBarContextView;

    invoke-virtual {v0, p1}, Landroid/support/v7/widget/ActionBarContextView;->setCustomView(Landroid/view/View;)V

    .line 1071
    new-instance v0, Ljava/lang/ref/WeakReference;

    invoke-direct {v0, p1}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object v0, p0, Landroid/support/v7/app/I$a;->f:Ljava/lang/ref/WeakReference;

    .line 1072
    return-void
.end method

.method public a(Ljava/lang/CharSequence;)V
    .locals 1
    .param p1, "subtitle"    # Ljava/lang/CharSequence;

    .line 1076
    iget-object v0, p0, Landroid/support/v7/app/I$a;->g:Landroid/support/v7/app/I;

    iget-object v0, v0, Landroid/support/v7/app/I;->j:Landroid/support/v7/widget/ActionBarContextView;

    invoke-virtual {v0, p1}, Landroid/support/v7/widget/ActionBarContextView;->setSubtitle(Ljava/lang/CharSequence;)V

    .line 1077
    return-void
.end method

.method public a(Z)V
    .locals 1
    .param p1, "titleOptional"    # Z

    .line 1106
    invoke-super {p0, p1}, La/b/d/d/b;->a(Z)V

    .line 1107
    iget-object v0, p0, Landroid/support/v7/app/I$a;->g:Landroid/support/v7/app/I;

    iget-object v0, v0, Landroid/support/v7/app/I;->j:Landroid/support/v7/widget/ActionBarContextView;

    invoke-virtual {v0, p1}, Landroid/support/v7/widget/ActionBarContextView;->setTitleOptional(Z)V

    .line 1108
    return-void
.end method

.method public a(Landroid/support/v7/view/menu/l;Landroid/view/MenuItem;)Z
    .locals 1
    .param p1, "menu"    # Landroid/support/v7/view/menu/l;
    .param p2, "item"    # Landroid/view/MenuItem;

    .line 1122
    iget-object v0, p0, Landroid/support/v7/app/I$a;->e:La/b/d/d/b$a;

    if-eqz v0, :cond_0

    .line 1123
    invoke-interface {v0, p0, p2}, La/b/d/d/b$a;->a(La/b/d/d/b;Landroid/view/MenuItem;)Z

    move-result v0

    return v0

    .line 1125
    :cond_0
    const/4 v0, 0x0

    return v0
.end method

.method public b()Landroid/view/View;
    .locals 1

    .line 1117
    iget-object v0, p0, Landroid/support/v7/app/I$a;->f:Ljava/lang/ref/WeakReference;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return-object v0
.end method

.method public b(I)V
    .locals 1
    .param p1, "resId"    # I

    .line 1086
    iget-object v0, p0, Landroid/support/v7/app/I$a;->g:Landroid/support/v7/app/I;

    iget-object v0, v0, Landroid/support/v7/app/I;->c:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Landroid/support/v7/app/I$a;->b(Ljava/lang/CharSequence;)V

    .line 1087
    return-void
.end method

.method public b(Ljava/lang/CharSequence;)V
    .locals 1
    .param p1, "title"    # Ljava/lang/CharSequence;

    .line 1081
    iget-object v0, p0, Landroid/support/v7/app/I$a;->g:Landroid/support/v7/app/I;

    iget-object v0, v0, Landroid/support/v7/app/I;->j:Landroid/support/v7/widget/ActionBarContextView;

    invoke-virtual {v0, p1}, Landroid/support/v7/widget/ActionBarContextView;->setTitle(Ljava/lang/CharSequence;)V

    .line 1082
    return-void
.end method

.method public c()Landroid/view/Menu;
    .locals 1

    .line 1008
    iget-object v0, p0, Landroid/support/v7/app/I$a;->d:Landroid/support/v7/view/menu/l;

    return-object v0
.end method

.method public d()Landroid/view/MenuInflater;
    .locals 2

    .line 1003
    new-instance v0, La/b/d/d/g;

    iget-object v1, p0, Landroid/support/v7/app/I$a;->c:Landroid/content/Context;

    invoke-direct {v0, v1}, La/b/d/d/g;-><init>(Landroid/content/Context;)V

    return-object v0
.end method

.method public e()Ljava/lang/CharSequence;
    .locals 1

    .line 1101
    iget-object v0, p0, Landroid/support/v7/app/I$a;->g:Landroid/support/v7/app/I;

    iget-object v0, v0, Landroid/support/v7/app/I;->j:Landroid/support/v7/widget/ActionBarContextView;

    invoke-virtual {v0}, Landroid/support/v7/widget/ActionBarContextView;->getSubtitle()Ljava/lang/CharSequence;

    move-result-object v0

    return-object v0
.end method

.method public g()Ljava/lang/CharSequence;
    .locals 1

    .line 1096
    iget-object v0, p0, Landroid/support/v7/app/I$a;->g:Landroid/support/v7/app/I;

    iget-object v0, v0, Landroid/support/v7/app/I;->j:Landroid/support/v7/widget/ActionBarContextView;

    invoke-virtual {v0}, Landroid/support/v7/widget/ActionBarContextView;->getTitle()Ljava/lang/CharSequence;

    move-result-object v0

    return-object v0
.end method

.method public i()V
    .locals 2

    .line 1044
    iget-object v0, p0, Landroid/support/v7/app/I$a;->g:Landroid/support/v7/app/I;

    iget-object v0, v0, Landroid/support/v7/app/I;->p:Landroid/support/v7/app/I$a;

    if-eq v0, p0, :cond_0

    .line 1048
    return-void

    .line 1051
    :cond_0
    iget-object v0, p0, Landroid/support/v7/app/I$a;->d:Landroid/support/v7/view/menu/l;

    invoke-virtual {v0}, Landroid/support/v7/view/menu/l;->s()V

    .line 1053
    :try_start_0
    iget-object v0, p0, Landroid/support/v7/app/I$a;->e:La/b/d/d/b$a;

    iget-object v1, p0, Landroid/support/v7/app/I$a;->d:Landroid/support/v7/view/menu/l;

    invoke-interface {v0, p0, v1}, La/b/d/d/b$a;->b(La/b/d/d/b;Landroid/view/Menu;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1055
    iget-object v0, p0, Landroid/support/v7/app/I$a;->d:Landroid/support/v7/view/menu/l;

    invoke-virtual {v0}, Landroid/support/v7/view/menu/l;->r()V

    .line 1056
    nop

    .line 1057
    return-void

    .line 1055
    :catchall_0
    move-exception v0

    iget-object v1, p0, Landroid/support/v7/app/I$a;->d:Landroid/support/v7/view/menu/l;

    invoke-virtual {v1}, Landroid/support/v7/view/menu/l;->r()V

    throw v0
.end method

.method public j()Z
    .locals 1

    .line 1112
    iget-object v0, p0, Landroid/support/v7/app/I$a;->g:Landroid/support/v7/app/I;

    iget-object v0, v0, Landroid/support/v7/app/I;->j:Landroid/support/v7/widget/ActionBarContextView;

    invoke-virtual {v0}, Landroid/support/v7/widget/ActionBarContextView;->b()Z

    move-result v0

    return v0
.end method

.method public k()Z
    .locals 2

    .line 1060
    iget-object v0, p0, Landroid/support/v7/app/I$a;->d:Landroid/support/v7/view/menu/l;

    invoke-virtual {v0}, Landroid/support/v7/view/menu/l;->s()V

    .line 1062
    :try_start_0
    iget-object v0, p0, Landroid/support/v7/app/I$a;->e:La/b/d/d/b$a;

    iget-object v1, p0, Landroid/support/v7/app/I$a;->d:Landroid/support/v7/view/menu/l;

    invoke-interface {v0, p0, v1}, La/b/d/d/b$a;->a(La/b/d/d/b;Landroid/view/Menu;)Z

    move-result v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1064
    iget-object v1, p0, Landroid/support/v7/app/I$a;->d:Landroid/support/v7/view/menu/l;

    invoke-virtual {v1}, Landroid/support/v7/view/menu/l;->r()V

    return v0

    :catchall_0
    move-exception v0

    iget-object v1, p0, Landroid/support/v7/app/I$a;->d:Landroid/support/v7/view/menu/l;

    invoke-virtual {v1}, Landroid/support/v7/view/menu/l;->r()V

    throw v0
.end method
