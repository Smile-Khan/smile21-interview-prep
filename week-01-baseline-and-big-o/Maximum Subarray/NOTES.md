Mistake 1: I used best (the answer) as my running sum
Why it's wrong: best is supposed to mean "max sum over all subarrays seen so far." I was treating it as "max sum of the subarray ending at the current index." Those are two different things, and I collapsed them into one variable.

Fix: Keep two separate variables with two separate jobs — one for the running sum ending here, one for the answer so far. Each one must update using its own previous value, never the other's.

Mistake 2: I added nums[i] twice
Why it's wrong: I wrote an expression where nums[i] was already inside current, and then added nums[i] again — so it was effectively counting the current element twice. My recurrence didn't match the actual rule (extend-or-restart with exactly one copy of the current element).

Fix: The recurrence should contain exactly one nums[i] per term. And the answer variable should update from the running sum — not from a freshly re-summed expression.

Mistake 3: I declared my running sum inside the loop
Why it's wrong: Declaring it inside the loop reset it to a single element every iteration, so it never carried anything forward — it wasn't a running sum at all.

Fix: Any variable that must survive from one loop iteration to the next has to be declared before the loop.

Mistake 4: My answer variable never actually accumulated
Why it's wrong: The answer variable didn't appear on the right-hand side of its own update, so it got overwritten from the current index every time instead of staying the max over all positions.

Fix: The answer variable must appear on its own right-hand side, so each step compares "the best so far" against "the candidate ending here" and keeps the larger.

Mistake 5: I initialized the answer to 0
Why it's wrong: For an all-negative array, 0 wins over the true (negative) answer, so I'd return 0 when the correct answer is negative.

Fix: Initialize the answer to the smallest possible value, since the subarray must be non-empty. (Only use 0 if the interviewer says empty subarrays are allowed.)

Mistake 6: I wasn't careful about overflow when initializing
Why it matters: If I ever seed the running sum with the smallest possible integer and then add to it, it can overflow.

Fix: Seed the running sum with 0 and let the "restart at current element" branch discard it on the first iteration — or seed it with the first element and start the loop from the second element.

The single lesson behind every mistake
All of these came from one root cause: I was not keeping the two roles separate.

One variable = "best sum of a subarray ending here" (the state).

One variable = "best sum seen anywhere so far" (the answer).

Every bug was me mixing those roles — using one where the other belonged, resetting the one that needed to persist, or failing to let the answer accumulate. The recurrence itself is simple; the difficulty is purely in keeping the two roles straight.

