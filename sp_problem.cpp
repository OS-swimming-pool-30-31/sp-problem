#include <iostream>
#include <thread>
#include <windows.h>
#include <cstdlib>
#include <ctime>
#include <vector>
#include <mutex>
using namespace std;

bool cub[10] = {0};
int bas_num = 0,i = 1;
int bas[15];
mutex Mutex1;
mutex limit;

void entry_cub(bool,int);
void fill_bas(int,int);
void swim(int);
void entry_cub(bool state,int bather){//false => departures , true => arrivals
    Mutex1.lock();
    int a;
    for(a = 0; a < 10; a++){//find the empty cubicle
        if(cub[a] != 1){
            cub[a] = 1;
            cout<<"cub["<<a<<"] is occupied by bather"<<bather<<"!"<<endl;
            break;
        }
    }
    Mutex1.unlock();
    if(state == true){//fill the basket

        fill_bas(bather,a);
    }
    else if(state == false){//empty the basket
        Mutex1.lock();
        for(int b = 0; b < 15; b++){
            if(bas[b] == bather){
                bas[b] = 0;
                bas_num--;
                cout<<"basket["<<b<<"] is empty!"<<endl;
                cub[a] = 0;
                cout<<"bather"<<bather<<" leaves the cub["<<a<<"]!"<<endl;
                cout<<"bather"<<bather<<" leaves the swimming pool"<<endl;
                Mutex1.unlock();
                break;
            }
        }
        Mutex1.unlock();
    }
}
void fill_bas(int bather, int c){
    Mutex1.lock();
    for(int a = 0; a < 15; a++){
        if(bas[a] == 0){
            cub[c] = 0;
            bas[a] = bather;
            cout<<"bas["<<a<<"] is occupied by bather"<<bather<<"!"<<endl;
            cout<<"bather"<<bather<<" leaves the cub["<<c<<"]!"<<endl;
            Mutex1.unlock();
            swim(bather);
            break;
        }
    }
    Mutex1.unlock();
}
void swim(int bather){
    Mutex1.lock();
    cout<<"bather"<<bather<<" is swimming!"<<endl;
    Mutex1.unlock();
    srand((unsigned)time(NULL));
    Sleep((rand() % 1000) * 10);
    entry_cub(false, bather);
}
int main(){
    for(int a = 0; a < 15; a++){
        bas[a] = 0;
    }
    vector<thread> bather;
    srand((unsigned)time(NULL));
    while(1){
        bas_num++;
        Sleep(rand() % 100);
        Mutex1.lock();
        cout<<"bather"<<i<<" arrive swimming pool"<<endl;
        Mutex1.unlock();
        bather.push_back(thread(entry_cub, true, i++));
    }
    for(int a = 0; a < bather.size(); a++){
        bather[a].join();
    }

}
