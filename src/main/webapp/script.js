document.addEventListener('DOMContentLoaded', function() {
  const form = document.getElementById('character-form');
  const magicPointsContainer = document.getElementById('magic-points-container');

  form.addEventListener('change', function() {
    const character = this.elements['character'].value;

    if (character === 'wizard') {
      magicPointsContainer.classList.remove('hidden');
    } else {
      magicPointsContainer.classList.add('hidden');
    }
  });
});
