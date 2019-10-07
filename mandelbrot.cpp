#include<iostream>
#include<windows.h> //library of gui functions

using namespace std;

void display(double xpos = 0, double ypos = 0, double zoom = 1)
{
    HDC window = GetDC(GetConsoleWindow()); //Handle Device Context. This line gets the console area to use as a graph
    double dwidth = 3.5, dheight = 2;
    dwidth /= zoom;
    dheight /= zoom;
    //setting the graph plane based on the desired zoom
    double top = ypos + dheight / 2;  
    double left = xpos - dwidth / 2;
    const int width = 1000, height = 500, maxIter = 8000;
    //these for loops will set each individual pixel (x,y) a color corresponding to what iteration that point exists in..
    //-----------------
    //..going down
    for(int i = 0; i < height; i++)
    {
        //..going across
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
            //if we are between 0 and 7999, color a pixel
            //SetPixelV takes 4 parameters: device context, x position, y position, and color
            if(iter >= maxIter - 1) 
                SetPixelV(window, j, i, RGB(0, 0, 0));
            else 
                SetPixelV(window, j, i, RGB(iter * 3 % 255, iter * 5 % 255, iter * 7 % 255));
        }
    }
}

int main()
{
    display(); //pass in desired x position, y position, and zoom level
    while(true); //to close out of the CMD, press X at the top right
}
