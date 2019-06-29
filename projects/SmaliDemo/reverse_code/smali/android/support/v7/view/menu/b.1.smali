.class public abstract Landroid/support/v7/view/menu/b;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Landroid/support/v7/view/menu/v;


# instance fields
.field protected a:Landroid/content/Context;

.field protected b:Landroid/content/Context;

.field protected c:Landroid/support/v7/view/menu/l;

.field protected d:Landroid/view/LayoutInflater;

.field protected e:Landroid/view/LayoutInflater;

.field private f:Landroid/support/v7/view/menu/v$a;

.field private g:I

.field private h:I

.field protected i:Landroid/support/v7/view/menu/w;

.field private j:I


# direct methods
.method public constructor <init>(Landroid/content/Context;II)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "menuLayoutRes"    # I
    .param p3, "itemLayoutRes"    # I

    .line 61
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 62
    iput-object p1, p0, Landroid/support/v7/view/menu/b;->a:Landroid/content/Context;

    .line 63
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    iput-object v0, p0, Landroid/support/v7/view/menu/b;->d:Landroid/view/LayoutInflater;

    .line 64
    iput p2, p0, Landroid/support/v7/view/menu/b;->g:I

    .line 65
    iput p3, p0, Landroid/support/v7/view/menu/b;->h:I

    .line 66
    return-void
.end method


# virtual methods
.method public a(Landroid/view/ViewGroup;)Landroid/support/v7/view/menu/w$a;
    .locals 3
    .param p1, "parent"    # Landroid/view/ViewGroup;

    .line 167
    iget-object v0, p0, Landroid/support/v7/view/menu/b;->d:Landroid/view/LayoutInflater;

    iget v1, p0, Landroid/support/v7/view/menu/b;->h:I

    const/4 v2, 0x0

    invoke-virtual {v0, v1, p1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/v7/view/menu/w$a;

    return-object v0
.end method

.method public a(Landroid/support/v7/view/menu/p;Landroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 2
    .param p1, "item"    # Landroid/support/v7/view/menu/p;
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .line 183
    instance-of v0, p2, Landroid/support/v7/view/menu/w$a;

    if-eqz v0, :cond_0

    .line 184
    move-object v0, p2

    check-cast v0, Landroid/support/v7/view/menu/w$a;

    .local v0, "itemView":Landroid/support/v7/view/menu/w$a;
    goto :goto_0

    .line 186
    .end local v0    # "itemView":Landroid/support/v7/view/menu/w$a;
    :cond_0
    invoke-virtual {p0, p3}, Landroid/support/v7/view/menu/b;->a(Landroid/view/ViewGroup;)Landroid/support/v7/view/menu/w$a;

    move-result-object v0

    .line 188
    .restart local v0    # "itemView":Landroid/support/v7/view/menu/w$a;
    :goto_0
    invoke-virtual {p0, p1, v0}, Landroid/support/v7/view/menu/b;->a(Landroid/support/v7/view/menu/p;Landroid/support/v7/view/menu/w$a;)V

    .line 189
    move-object v1, v0

    check-cast v1, Landroid/view/View;

    return-object v1
.end method

.method public a(I)V
    .locals 0
    .param p1, "id"    # I

    .line 247
    iput p1, p0, Landroid/support/v7/view/menu/b;->j:I

    .line 248
    return-void
.end method

.method public a(Landroid/content/Context;Landroid/support/v7/view/menu/l;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "menu"    # Landroid/support/v7/view/menu/l;

    .line 70
    iput-object p1, p0, Landroid/support/v7/view/menu/b;->b:Landroid/content/Context;

    .line 71
    iget-object v0, p0, Landroid/support/v7/view/menu/b;->b:Landroid/content/Context;

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    iput-object v0, p0, Landroid/support/v7/view/menu/b;->e:Landroid/view/LayoutInflater;

    .line 72
    iput-object p2, p0, Landroid/support/v7/view/menu/b;->c:Landroid/support/v7/view/menu/l;

    .line 73
    return-void
.end method

.method public a(Landroid/support/v7/view/menu/l;Z)V
    .locals 1
    .param p1, "menu"    # Landroid/support/v7/view/menu/l;
    .param p2, "allMenusAreClosing"    # Z

    .line 213
    iget-object v0, p0, Landroid/support/v7/view/menu/b;->f:Landroid/support/v7/view/menu/v$a;

    if-eqz v0, :cond_0

    .line 214
    invoke-interface {v0, p1, p2}, Landroid/support/v7/view/menu/v$a;->a(Landroid/support/v7/view/menu/l;Z)V

    .line 216
    :cond_0
    return-void
.end method

.method public abstract a(Landroid/support/v7/view/menu/p;Landroid/support/v7/view/menu/w$a;)V
.end method

.method public a(Landroid/support/v7/view/menu/v$a;)V
    .locals 0
    .param p1, "cb"    # Landroid/support/v7/view/menu/v$a;

    .line 154
    iput-object p1, p0, Landroid/support/v7/view/menu/b;->f:Landroid/support/v7/view/menu/v$a;

    .line 155
    return-void
.end method

.method protected a(Landroid/view/View;I)V
    .locals 2
    .param p1, "itemView"    # Landroid/view/View;
    .param p2, "childIndex"    # I

    .line 134
    invoke-virtual {p1}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    .line 135
    .local v0, "currentParent":Landroid/view/ViewGroup;
    if-eqz v0, :cond_0

    .line 136
    invoke-virtual {v0, p1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    .line 138
    :cond_0
    iget-object v1, p0, Landroid/support/v7/view/menu/b;->i:Landroid/support/v7/view/menu/w;

    check-cast v1, Landroid/view/ViewGroup;

    invoke-virtual {v1, p1, p2}, Landroid/view/ViewGroup;->addView(Landroid/view/View;I)V

    .line 139
    return-void
.end method

.method public a(Z)V
    .locals 10
    .param p1, "cleared"    # Z

    .line 91
    iget-object v0, p0, Landroid/support/v7/view/menu/b;->i:Landroid/support/v7/view/menu/w;

    check-cast v0, Landroid/view/ViewGroup;

    .line 92
    .local v0, "parent":Landroid/view/ViewGroup;
    if-nez v0, :cond_0

    return-void

    .line 94
    :cond_0
    const/4 v1, 0x0

    .line 95
    .local v1, "childIndex":I
    iget-object v2, p0, Landroid/support/v7/view/menu/b;->c:Landroid/support/v7/view/menu/l;

    if-eqz v2, :cond_5

    .line 96
    invoke-virtual {v2}, Landroid/support/v7/view/menu/l;->b()V

    .line 97
    iget-object v2, p0, Landroid/support/v7/view/menu/b;->c:Landroid/support/v7/view/menu/l;

    invoke-virtual {v2}, Landroid/support/v7/view/menu/l;->n()Ljava/util/ArrayList;

    move-result-object v2

    .line 98
    .local v2, "visibleItems":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v7/view/menu/MenuItemImpl;>;"
    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v3

    .line 99
    .local v3, "itemCount":I
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_0
    if-ge v4, v3, :cond_5

    .line 100
    invoke-virtual {v2, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroid/support/v7/view/menu/p;

    .line 101
    .local v5, "item":Landroid/support/v7/view/menu/p;
    invoke-virtual {p0, v1, v5}, Landroid/support/v7/view/menu/b;->a(ILandroid/support/v7/view/menu/p;)Z

    move-result v6

    if-eqz v6, :cond_4

    .line 102
    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v6

    .line 103
    .local v6, "convertView":Landroid/view/View;
    instance-of v7, v6, Landroid/support/v7/view/menu/w$a;

    if-eqz v7, :cond_1

    move-object v7, v6

    check-cast v7, Landroid/support/v7/view/menu/w$a;

    .line 104
    invoke-interface {v7}, Landroid/support/v7/view/menu/w$a;->getItemData()Landroid/support/v7/view/menu/p;

    move-result-object v7

    goto :goto_1

    :cond_1
    const/4 v7, 0x0

    .line 105
    .local v7, "oldItem":Landroid/support/v7/view/menu/p;
    :goto_1
    invoke-virtual {p0, v5, v6, v0}, Landroid/support/v7/view/menu/b;->a(Landroid/support/v7/view/menu/p;Landroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v8

    .line 106
    .local v8, "itemView":Landroid/view/View;
    if-eq v5, v7, :cond_2

    .line 108
    const/4 v9, 0x0

    invoke-virtual {v8, v9}, Landroid/view/View;->setPressed(Z)V

    .line 109
    invoke-virtual {v8}, Landroid/view/View;->jumpDrawablesToCurrentState()V

    .line 111
    :cond_2
    if-eq v8, v6, :cond_3

    .line 112
    invoke-virtual {p0, v8, v1}, Landroid/support/v7/view/menu/b;->a(Landroid/view/View;I)V

    .line 114
    :cond_3
    add-int/lit8 v1, v1, 0x1

    .line 99
    .end local v5    # "item":Landroid/support/v7/view/menu/p;
    .end local v6    # "convertView":Landroid/view/View;
    .end local v7    # "oldItem":Landroid/support/v7/view/menu/p;
    .end local v8    # "itemView":Landroid/view/View;
    :cond_4
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 120
    .end local v2    # "visibleItems":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/v7/view/menu/MenuItemImpl;>;"
    .end local v3    # "itemCount":I
    .end local v4    # "i":I
    :cond_5
    :goto_2
    invoke-virtual {v0}, Landroid/view/ViewGroup;->getChildCount()I

    move-result v2

    if-ge v1, v2, :cond_6

    .line 121
    invoke-virtual {p0, v0, v1}, Landroid/support/v7/view/menu/b;->a(Landroid/view/ViewGroup;I)Z

    move-result v2

    if-nez v2, :cond_5

    .line 122
    add-int/lit8 v1, v1, 0x1

    goto :goto_2

    .line 125
    :cond_6
    return-void
.end method

.method public abstract a(ILandroid/support/v7/view/menu/p;)Z
.end method

.method public a(Landroid/support/v7/view/menu/D;)Z
    .locals 1
    .param p1, "menu"    # Landroid/support/v7/view/menu/D;

    .line 220
    iget-object v0, p0, Landroid/support/v7/view/menu/b;->f:Landroid/support/v7/view/menu/v$a;

    if-eqz v0, :cond_0

    .line 221
    invoke-interface {v0, p1}, Landroid/support/v7/view/menu/v$a;->a(Landroid/support/v7/view/menu/l;)Z

    move-result v0

    return v0

    .line 223
    :cond_0
    const/4 v0, 0x0

    return v0
.end method

.method public a(Landroid/support/v7/view/menu/l;Landroid/support/v7/view/menu/p;)Z
    .locals 1
    .param p1, "menu"    # Landroid/support/v7/view/menu/l;
    .param p2, "item"    # Landroid/support/v7/view/menu/p;

    .line 233
    const/4 v0, 0x0

    return v0
.end method

.method protected a(Landroid/view/ViewGroup;I)Z
    .locals 1
    .param p1, "parent"    # Landroid/view/ViewGroup;
    .param p2, "childIndex"    # I

    .line 148
    invoke-virtual {p1, p2}, Landroid/view/ViewGroup;->removeViewAt(I)V

    .line 149
    const/4 v0, 0x1

    return v0
.end method

.method public b()Landroid/support/v7/view/menu/v$a;
    .locals 1

    .line 158
    iget-object v0, p0, Landroid/support/v7/view/menu/b;->f:Landroid/support/v7/view/menu/v$a;

    return-object v0
.end method

.method public b(Landroid/view/ViewGroup;)Landroid/support/v7/view/menu/w;
    .locals 3
    .param p1, "root"    # Landroid/view/ViewGroup;

    .line 77
    iget-object v0, p0, Landroid/support/v7/view/menu/b;->i:Landroid/support/v7/view/menu/w;

    if-nez v0, :cond_0

    .line 78
    iget-object v0, p0, Landroid/support/v7/view/menu/b;->d:Landroid/view/LayoutInflater;

    iget v1, p0, Landroid/support/v7/view/menu/b;->g:I

    const/4 v2, 0x0

    invoke-virtual {v0, v1, p1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/v7/view/menu/w;

    iput-object v0, p0, Landroid/support/v7/view/menu/b;->i:Landroid/support/v7/view/menu/w;

    .line 79
    iget-object v0, p0, Landroid/support/v7/view/menu/b;->i:Landroid/support/v7/view/menu/w;

    iget-object v1, p0, Landroid/support/v7/view/menu/b;->c:Landroid/support/v7/view/menu/l;

    invoke-interface {v0, v1}, Landroid/support/v7/view/menu/w;->a(Landroid/support/v7/view/menu/l;)V

    .line 80
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Landroid/support/v7/view/menu/b;->a(Z)V

    .line 83
    :cond_0
    iget-object v0, p0, Landroid/support/v7/view/menu/b;->i:Landroid/support/v7/view/menu/w;

    return-object v0
.end method

.method public b(Landroid/support/v7/view/menu/l;Landroid/support/v7/view/menu/p;)Z
    .locals 1
    .param p1, "menu"    # Landroid/support/v7/view/menu/l;
    .param p2, "item"    # Landroid/support/v7/view/menu/p;

    .line 238
    const/4 v0, 0x0

    return v0
.end method
