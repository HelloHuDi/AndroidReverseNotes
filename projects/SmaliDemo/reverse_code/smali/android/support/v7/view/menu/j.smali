.class public Landroid/support/v7/view/menu/j;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Landroid/support/v7/view/menu/v;
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/support/v7/view/menu/j$a;
    }
.end annotation


# instance fields
.field a:Landroid/content/Context;

.field b:Landroid/view/LayoutInflater;

.field c:Landroid/support/v7/view/menu/l;

.field d:Landroid/support/v7/view/menu/ExpandedMenuView;

.field e:I

.field f:I

.field g:I

.field private h:Landroid/support/v7/view/menu/v$a;

.field i:Landroid/support/v7/view/menu/j$a;


# direct methods
.method public constructor <init>(II)V
    .locals 0
    .param p1, "itemLayoutRes"    # I
    .param p2, "themeRes"    # I

    .line 81
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 82
    iput p1, p0, Landroid/support/v7/view/menu/j;->g:I

    .line 83
    iput p2, p0, Landroid/support/v7/view/menu/j;->f:I

    .line 84
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;I)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "itemLayoutRes"    # I

    .line 71
    const/4 v0, 0x0

    invoke-direct {p0, p2, v0}, Landroid/support/v7/view/menu/j;-><init>(II)V

    .line 72
    iput-object p1, p0, Landroid/support/v7/view/menu/j;->a:Landroid/content/Context;

    .line 73
    iget-object v0, p0, Landroid/support/v7/view/menu/j;->a:Landroid/content/Context;

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    iput-object v0, p0, Landroid/support/v7/view/menu/j;->b:Landroid/view/LayoutInflater;

    .line 74
    return-void
.end method


# virtual methods
.method public a(Landroid/view/ViewGroup;)Landroid/support/v7/view/menu/w;
    .locals 3
    .param p1, "root"    # Landroid/view/ViewGroup;

    .line 105
    iget-object v0, p0, Landroid/support/v7/view/menu/j;->d:Landroid/support/v7/view/menu/ExpandedMenuView;

    if-nez v0, :cond_1

    .line 106
    iget-object v0, p0, Landroid/support/v7/view/menu/j;->b:Landroid/view/LayoutInflater;

    sget v1, La/b/d/a/g;->abc_expanded_menu_layout:I

    const/4 v2, 0x0

    invoke-virtual {v0, v1, p1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/v7/view/menu/ExpandedMenuView;

    iput-object v0, p0, Landroid/support/v7/view/menu/j;->d:Landroid/support/v7/view/menu/ExpandedMenuView;

    .line 108
    iget-object v0, p0, Landroid/support/v7/view/menu/j;->i:Landroid/support/v7/view/menu/j$a;

    if-nez v0, :cond_0

    .line 109
    new-instance v0, Landroid/support/v7/view/menu/j$a;

    invoke-direct {v0, p0}, Landroid/support/v7/view/menu/j$a;-><init>(Landroid/support/v7/view/menu/j;)V

    iput-object v0, p0, Landroid/support/v7/view/menu/j;->i:Landroid/support/v7/view/menu/j$a;

    .line 111
    :cond_0
    iget-object v0, p0, Landroid/support/v7/view/menu/j;->d:Landroid/support/v7/view/menu/ExpandedMenuView;

    iget-object v1, p0, Landroid/support/v7/view/menu/j;->i:Landroid/support/v7/view/menu/j$a;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 112
    iget-object v0, p0, Landroid/support/v7/view/menu/j;->d:Landroid/support/v7/view/menu/ExpandedMenuView;

    invoke-virtual {v0, p0}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 114
    :cond_1
    iget-object v0, p0, Landroid/support/v7/view/menu/j;->d:Landroid/support/v7/view/menu/ExpandedMenuView;

    return-object v0
.end method

.method public a(Landroid/content/Context;Landroid/support/v7/view/menu/l;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "menu"    # Landroid/support/v7/view/menu/l;

    .line 88
    iget v0, p0, Landroid/support/v7/view/menu/j;->f:I

    if-eqz v0, :cond_0

    .line 89
    new-instance v1, Landroid/view/ContextThemeWrapper;

    invoke-direct {v1, p1, v0}, Landroid/view/ContextThemeWrapper;-><init>(Landroid/content/Context;I)V

    iput-object v1, p0, Landroid/support/v7/view/menu/j;->a:Landroid/content/Context;

    .line 90
    iget-object v0, p0, Landroid/support/v7/view/menu/j;->a:Landroid/content/Context;

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    iput-object v0, p0, Landroid/support/v7/view/menu/j;->b:Landroid/view/LayoutInflater;

    goto :goto_0

    .line 91
    :cond_0
    iget-object v0, p0, Landroid/support/v7/view/menu/j;->a:Landroid/content/Context;

    if-eqz v0, :cond_1

    .line 92
    iput-object p1, p0, Landroid/support/v7/view/menu/j;->a:Landroid/content/Context;

    .line 93
    iget-object v0, p0, Landroid/support/v7/view/menu/j;->b:Landroid/view/LayoutInflater;

    if-nez v0, :cond_1

    .line 94
    iget-object v0, p0, Landroid/support/v7/view/menu/j;->a:Landroid/content/Context;

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    iput-object v0, p0, Landroid/support/v7/view/menu/j;->b:Landroid/view/LayoutInflater;

    .line 97
    :cond_1
    :goto_0
    iput-object p2, p0, Landroid/support/v7/view/menu/j;->c:Landroid/support/v7/view/menu/l;

    .line 98
    iget-object v0, p0, Landroid/support/v7/view/menu/j;->i:Landroid/support/v7/view/menu/j$a;

    if-eqz v0, :cond_2

    .line 99
    invoke-virtual {v0}, Landroid/support/v7/view/menu/j$a;->notifyDataSetChanged()V

    .line 101
    :cond_2
    return-void
.end method

.method public a(Landroid/support/v7/view/menu/l;Z)V
    .locals 1
    .param p1, "menu"    # Landroid/support/v7/view/menu/l;
    .param p2, "allMenusAreClosing"    # Z

    .line 155
    iget-object v0, p0, Landroid/support/v7/view/menu/j;->h:Landroid/support/v7/view/menu/v$a;

    if-eqz v0, :cond_0

    .line 156
    invoke-interface {v0, p1, p2}, Landroid/support/v7/view/menu/v$a;->a(Landroid/support/v7/view/menu/l;Z)V

    .line 158
    :cond_0
    return-void
.end method

.method public a(Landroid/support/v7/view/menu/v$a;)V
    .locals 0
    .param p1, "cb"    # Landroid/support/v7/view/menu/v$a;

    .line 138
    iput-object p1, p0, Landroid/support/v7/view/menu/j;->h:Landroid/support/v7/view/menu/v$a;

    .line 139
    return-void
.end method

.method public a(Z)V
    .locals 1
    .param p1, "cleared"    # Z

    .line 133
    iget-object v0, p0, Landroid/support/v7/view/menu/j;->i:Landroid/support/v7/view/menu/j$a;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/support/v7/view/menu/j$a;->notifyDataSetChanged()V

    .line 134
    :cond_0
    return-void
.end method

.method public a()Z
    .locals 1

    .line 178
    const/4 v0, 0x0

    return v0
.end method

.method public a(Landroid/support/v7/view/menu/D;)Z
    .locals 2
    .param p1, "subMenu"    # Landroid/support/v7/view/menu/D;

    .line 143
    invoke-virtual {p1}, Landroid/support/v7/view/menu/l;->hasVisibleItems()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x0

    return v0

    .line 146
    :cond_0
    new-instance v0, Landroid/support/v7/view/menu/m;

    invoke-direct {v0, p1}, Landroid/support/v7/view/menu/m;-><init>(Landroid/support/v7/view/menu/l;)V

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v7/view/menu/m;->a(Landroid/os/IBinder;)V

    .line 147
    iget-object v0, p0, Landroid/support/v7/view/menu/j;->h:Landroid/support/v7/view/menu/v$a;

    if-eqz v0, :cond_1

    .line 148
    invoke-interface {v0, p1}, Landroid/support/v7/view/menu/v$a;->a(Landroid/support/v7/view/menu/l;)Z

    .line 150
    :cond_1
    const/4 v0, 0x1

    return v0
.end method

.method public a(Landroid/support/v7/view/menu/l;Landroid/support/v7/view/menu/p;)Z
    .locals 1
    .param p1, "menu"    # Landroid/support/v7/view/menu/l;
    .param p2, "item"    # Landroid/support/v7/view/menu/p;

    .line 183
    const/4 v0, 0x0

    return v0
.end method

.method public b()Landroid/widget/ListAdapter;
    .locals 1

    .line 125
    iget-object v0, p0, Landroid/support/v7/view/menu/j;->i:Landroid/support/v7/view/menu/j$a;

    if-nez v0, :cond_0

    .line 126
    new-instance v0, Landroid/support/v7/view/menu/j$a;

    invoke-direct {v0, p0}, Landroid/support/v7/view/menu/j$a;-><init>(Landroid/support/v7/view/menu/j;)V

    iput-object v0, p0, Landroid/support/v7/view/menu/j;->i:Landroid/support/v7/view/menu/j$a;

    .line 128
    :cond_0
    iget-object v0, p0, Landroid/support/v7/view/menu/j;->i:Landroid/support/v7/view/menu/j$a;

    return-object v0
.end method

.method public b(Landroid/support/v7/view/menu/l;Landroid/support/v7/view/menu/p;)Z
    .locals 1
    .param p1, "menu"    # Landroid/support/v7/view/menu/l;
    .param p2, "item"    # Landroid/support/v7/view/menu/p;

    .line 188
    const/4 v0, 0x0

    return v0
.end method

.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 3
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

    .line 173
    .local p1, "parent":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    iget-object v0, p0, Landroid/support/v7/view/menu/j;->c:Landroid/support/v7/view/menu/l;

    iget-object v1, p0, Landroid/support/v7/view/menu/j;->i:Landroid/support/v7/view/menu/j$a;

    invoke-virtual {v1, p3}, Landroid/support/v7/view/menu/j$a;->getItem(I)Landroid/support/v7/view/menu/p;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, p0, v2}, Landroid/support/v7/view/menu/l;->a(Landroid/view/MenuItem;Landroid/support/v7/view/menu/v;I)Z

    .line 174
    return-void
.end method
