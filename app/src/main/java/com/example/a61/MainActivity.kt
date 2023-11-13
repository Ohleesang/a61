package com.example.a61

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        class Solution {
            fun score(n : Int) :Int{
                // 6->1 5->2 4->3 3->4 2->5 1,0->6
                when(n){
                    6 -> return 1
                    5 -> return 2
                    4 -> return 3
                    3 -> return 4
                    2 -> return 5
                    1,0 -> return 6
                }
                return 0
            }

            fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
                //구매한 로또 번호 lottos
                //당첨 번호 win_nums
                var answer: IntArray = intArrayOf()
                //오름차순으로 정렬
                lottos.sort()
                win_nums.sort()
                //로또 번호 몇개 맞췄는지 count
                var count = 0
                var zeroCount = 0
                for(i in 0..5){
                    if(lottos[i].equals(0)) {
                        zeroCount++
                        continue
                    }

                    for(j in 0..5){
                        if(lottos[i]==win_nums[j]){
                            count++
                            break
                        }
                    }
                }
                // count와 zeroCount 값을 계산하여 answer값 출력
                // zeroCount 가 0 이면 결과값이 하나밖에
                // zeroCount 가 n 이상이면 최소값 : 등수 -n 최대값 등수
                // zeroCount 가 6 이면 [1,6]
                // 6->1 5->2 4->3 3->4 2->5 1,0->6
                when(zeroCount)
                {
                    0 -> answer= intArrayOf(score(count),score(count))
                    6 -> answer= intArrayOf(1,6)
                    1,2,3,4,5 -> answer = intArrayOf(score(count+zeroCount),score(count))
                }
                return answer
            }
        }
        var a = Solution()
        a.solution(intArrayOf(44,1,0,0,31,25),intArrayOf(31,10,45,1,6,19))//[3,5]
        a.solution(intArrayOf(0,0,0,0,0,0),intArrayOf(38,19,20,40,15,25))//[1,6]
        a.solution(intArrayOf(45,4,35,20,3,9),intArrayOf(20,9,3,45,4,35))//[1,1]
    }
}