#include<iostream>
#include<windows.h>

using namespace std;

void display(double xpos = 0, double ypos = 0, double zoom = 1)
{
    HDC window = GetDC(GetConsoleWindow());
    double dwidth = 3.5, dheight = 2;
    dwidth /= zoom;
    dheight /= zoom;
    double top = ypos + dheight / 2;
    double left = xpos - dwidth / 2;
    const int width = 1000, height = 500, maxIter = 8000;
    for(int i = 0; i < height; i++)
    {
        for(int j = 0; j < width; j++)
        {
            double x0 = (j / (double)width) * dwidth + left;
            double y0 = -(i / (double)height) * dheight + top;
            double x = 0, y = 0;
            int iter = 0;
            while(x * x + y * y <= 4 && iter < maxIter)
            {
                double xt = x * x - y * y + x0;
                y = 2 * x * y + y0;
                x = xt;
                iter++;
            }
            if(iter >= maxIter - 1 || iter<17) 
				SetPixelV(window, j, i, RGB(0, 0, 0));
            else
				SetPixelV(window, j, i, RGB(iter * 0 % 255, iter * 10 % 255, iter * 10 % 255));
        }
    }
}

int main()
{
    display();
    while(true);
}
