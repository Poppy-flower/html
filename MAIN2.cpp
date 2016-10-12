#include <iostream>
#include <cstdlib>
#include <string>
#include <stack>
#include <vector>

#include<iomanip>
using namespace std;




int main()
{
    char rol[8] = {'+','*','i','(',')','#','-','/'};
    char col[5] = {'S','G','T','H','F'};

    string table[5][8] = {"null","null","TG","TG","null","null","null","null",
	                      "+TG","null","null","null","$","$","-TG","null",
                          "null","null","FH","FH","null","null","null","null",
	                      "$","*FH","null","null","$","$","$","/FH",
                          "null","null","i","(S)","null","null","null","null"};

    char sentence[10] = {'i','+','i','*','i','-','i','/','i','#'};
    vector<char> left ;
    vector<char> right;
    int ltop=0,rtop=0;//×óÓÒµÄÕ»¶¥ÏÂ±ê
    for(int i = 9 ; i >=0 ; i--){
        right.push_back(sentence[i]);
        rtop++;
    }
    left.push_back('#');
    left.push_back('S');
    ltop++;ltop++;
    bool flag = true;
    while(ltop!=0){
        for(int i = 0 ;i < ltop ; i++){
            cout<<left[i]<<" ";
        }
        cout<<"\t\t";
        for(int i = rtop -1 ;i >= 0 ; i--){
            cout<<right[i]<<" ";
        }
        cout<<endl;
        char topleft = left[ltop-1];
        //cout<<topleft<<endl;
        ltop--;
        char topright = right[rtop-1];
        //cout<<topright<<endl;
        if( topleft == topright ){
            rtop--;
            continue ;
        }else{
            int hang = 0 ;
            for(int i = 0 ; i < 5 ; i++){
                if(topleft == col[i]){
                    hang = i;
                    break;
                }
            }
            int lie = 0 ;
            for(int i = 0 ; i < 8 ; i++){
                if(topright == rol[i]){
                    lie = i;
                    break;
                }
            }
            string temp = table[hang][lie] ;
            if(temp.compare("null") == 0){
                    flag = false;
                    break;
            }else if(temp.compare("$") == 0){
                continue;
            }else{
                char *s = new char[temp.length()];
                strcpy(s,temp.c_str());
                for(int i = temp.length()-1 ; i >= 0 ; i--){
                    left[ltop++]=s[i];
                }
                continue;
            }

        }
    }

    if(flag==true){
        cout<<"sentince true !"<<endl;
    }else{
        cout<<"sentince false !"<<endl;
    }
    return 0;
}
