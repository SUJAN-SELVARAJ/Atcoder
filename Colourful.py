def main():
    n = int(input())
    ratings = [int(x) for x in input().split()]
    present_colors = set()
    free_users = 0
    for r in ratings:
        if 1 <= r <= 399:
            present_colors.add("gray")
        elif 400 <= r <= 799:
            present_colors.add("brown")
        elif 800 <= r <= 1199:
            present_colors.add("green")
        elif 1200 <= r <= 1599:
            present_colors.add("cyan")
        elif 1600 <= r <= 1999:
            present_colors.add("blue")
        elif 2000 <= r <= 2399:
            present_colors.add("yellow")
        elif 2400 <= r <= 2799:
            present_colors.add("orange")
        elif 2800 <= r <= 3199:
            present_colors.add("red")
        else:
            free_users += 1
    fixed_colors = len(present_colors)
    if fixed_colors == 0:
        min_colors = max(1, fixed_colors) 
    else:
        min_colors = fixed_colors
    max_colors = fixed_colors + free_users
    print(f"{min_colors} {max_colors}")
if __name__ == '__main__':
    main()
